import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int N;
	public static ArrayList<Integer>[] list;
	public static int[] arr;
	public static boolean visited[], mainVisited[];
	public static int MIN = Integer.MAX_VALUE;
	public static int stoi(String str) { return Integer.parseInt(str); }
	public static boolean DEBUG	= true;
	public static int sum;
	public static void main(String[] args) throws Exception{
		
		//init
		N = stoi(br.readLine());
		list = new ArrayList[11];
		for(int i = 0 ; i < 11 ; i++)
			list[i] = new ArrayList<Integer>();
		visited = new boolean[11];
		arr = new int[11];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i <= N ; i++)
			arr[i] = stoi(st.nextToken());
		
		for(int i = 1 ; i <= N ; i++)
		{
			st = new StringTokenizer(br.readLine());
			int M = stoi(st.nextToken());
			for(int j = 0 ; j < M ; j++)
			{
				list[i].add(stoi(st.nextToken()));
			}
		}
		
		for(int i = 1 ; i <= N ; i++)
		{
			mainVisited = new boolean[11];
			sum = 0;
			dfs(i);
		}
		
		if(MIN == Integer.MAX_VALUE)
			bw.write("-1");
		else
			bw.write(String.valueOf(MIN));
		bw.flush();
		bw.close();
	}
	public static void dfs(int x)
	{
		mainVisited[x] = true;
		visited = new boolean[11];
		sum += arr[x];
		int remainSum = 0;
		for(int i = 1 ; i <= N ; i++)
		{
			if(!mainVisited[i])
			{
				remainSum = remainDfs(i);
				break;
			}
		}
		
		if(allVisited())
		{
			MIN = Math.min(MIN, Math.abs(sum - remainSum));
			if(DEBUG)
			{
				for(int i = 1 ; i <= N ; i++)
					if(mainVisited[i])
						System.out.print(arr[i] + " ");
				System.out.println("sum : " + sum + " remainSum : " + remainSum + " MIN :" + MIN);
				
			}
		}
		
		for(int i = 0 ; i < list[x].size() ; i++)
		{
			if(!mainVisited[list[x].get(i)])
				dfs(list[x].get(i));
		}
	}
	public static int remainDfs(int x)
	{
		visited[x] = true;
		int val = arr[x];
		for(int i = 0 ; i < list[x].size() ; i++)
		{
			if(!visited[list[x].get(i)] && !mainVisited[list[x].get(i)])
				val += remainDfs(list[x].get(i));
		}
		return val;
	}
	public static boolean allVisited()
	{
		boolean pass = true;
		for(int i = 1 ; i <= N ; i++)
		{
			if(!(visited[i] || mainVisited[i]))
			{
				pass = false;
				break;
			}
		}
		return pass;
	}
}
