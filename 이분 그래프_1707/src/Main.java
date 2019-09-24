import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static final int MAX_SIZE = 20_001;
	public static int vertex, edge;
	public static ArrayList<Integer>[] arr;
	public static boolean[] visited;
	public static int[] vertexSet;
	public static String solv;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for(int tNum = 1 ; tNum <= T ; tNum++)
		{
			st = new StringTokenizer(br.readLine());
			vertex = Integer.parseInt(st.nextToken());
			edge = Integer.parseInt(st.nextToken());
			arr = new ArrayList[MAX_SIZE];
			visited = new boolean[MAX_SIZE];
			vertexSet = new int[MAX_SIZE];
			
			for(int i = 0 ; i < MAX_SIZE ; i++)
				arr[i] = new ArrayList<Integer>();
			int maxNum = 0;
			for(int i = 0 ; i < edge ; i++)
			{
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				maxNum = Math.max(maxNum, a>b?a:b);
				arr[a].add(b); arr[b].add(a);
			}
			solv = "YES";
			for(int i = 1 ; i <= maxNum ; i++)
			{
				if(solv.equals("NO")) break;
				if(!visited[i])
					dfs(i,1);
			}
			bw.write(solv + "\n");
		}//for tNum
		bw.flush();
		bw.close();
	}
	public static void dfs(int index , int sw)
	{
		if(vertexSet[index] != 0 && vertexSet[index] != sw)
		{
			solv = "NO";
		}
		if(visited[index]) return; 
		visited[index] = true;
		vertexSet[index] = sw;
		for(int i = 0 ; i < arr[index].size(); i++)
		{
			dfs(arr[index].get(i),sw*-1);
		}
	}
}
