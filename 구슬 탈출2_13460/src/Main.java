import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static int N,M;
	public static char[][] arr;
	public static Map<String,Integer> visited;
	public static Queue<String> q;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//init
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		visited = new HashMap<>();
		q = new LinkedList<>();
		
		//input
		for(int i = 0 ; i < N ; i++)
		{
			String tmp = br.readLine();
			for(int j = 0 ; j < M ; j++)
			{
				arr[i][j] = tmp.charAt(j);
			}
		}
		
		//logic
		int solv = bfs();
		
		//print
		if(solv == 0)
			bw.write(String.valueOf(solv)+"\n");
		else
			bw.write(String.valueOf(solv)+"\n");
		bw.flush();
		bw.close();
	}
	public static String arrToString()
	{
		String output = "";
		for(int i = 0 ; i < N ; i++)
		{
			for(int j = 0 ; j < M ; j++)
			{
				output += arr[i][j];
			}
		}
		return output;
	}
	public static char[][] strToArr(String str)
	{
		for(int i = 0 ; i < N ; i++)
		{
			for(int j = 0 ; j < M ; j++)
			{
				arr[i][j] = str.charAt((i*M)+j);
			}
		}
		return arr;
	}
	public static int[] dy = { -1, 0 , 1, 0 };
	public static int[] dx = { 0 , 1 , 0 , -1};
	public static int bfs()
	{
		int output = 0;
		
		visited.put(arrToString(), 0);
		q.offer(arrToString());
		
		while(!q.isEmpty())
		{
			String pos = q.poll();
			strToArr(pos);
			
			
		}
		
		return output;
	}
	public static String right(char[][] brr)
	{
		Stack<Character> s = new Stack<>();
		
		for(int i = 1 ; i < brr.length -1 ; i++)
		{
			for(int j = 1 ; j < brr[i].length -1 ; j++)
			{
				s.push(brr[i][j]);
			}
		}
		
		return null;
	}
}