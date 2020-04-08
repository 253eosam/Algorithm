import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int edge;
	public static int[][] arr, brr;
	public static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//init
		edge = Integer.parseInt(br.readLine());
		arr = new int[edge+1][edge+1];
		brr = new int[edge+1][edge+1];
		
		//input
		for(int i = 1 ; i < edge+1 ; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j < edge+1 ; j++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//logic
		for(int i = 1 ; i < edge+1 ; i++)
		{
			visited = new boolean[edge+1][edge+1];
			bfs(i);
		}
		
		//print
		for(int i = 1 ; i < edge+1 ; i++)
		{
			for(int j = 1 ; j < edge+1 ; j++)
			{
				bw.write(brr[i][j]+" ");
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		
	}
	public static void bfs(int starting)
	{
		//starting point
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1 ; i < edge+1 ; i++)
		{
			if(arr[starting][i] == 1)
			{
				q.offer(i);
				visited[starting][i] = true;
			}
		}
		
		while(!q.isEmpty())
		{
			int pos = q.poll();
			brr[starting][pos] = 1;
			for(int i = 1 ; i < edge+1 ; i++)
			{
				if(arr[pos][i] == 1 && !visited[pos][i])
				{
					q.offer(i);
					visited[pos][i] = true;
				}
			}
		}
	}
}
