import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N,M;
	public static int[][] arr;
	public static boolean[] visited;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//init
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		//input
		for(int i = 0 ; i < M ; i++)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = arr[b][a] = 1;
		}
		
		
		//logic
		int minimum = Integer.MAX_VALUE ; int miniIdx = 0;
		for(int i = 1 ; i <= N ; i++)
		{
			int bCnt = 0;
			for(int j = 1 ; j <= N ; j++)
			{
				if(i == j) continue;
				bCnt += bfs(i,j);
				visited = new boolean[N+1];
			}
//			System.out.println(bCnt + "BCnt");
			if(minimum > bCnt)
			{
				minimum = bCnt;
				miniIdx = i;
			}
		}
		
		//print
		bw.write(String.valueOf(miniIdx));
		bw.flush();
		bw.close();
	}
	public static int bfs(int start, int target)
	{
		Queue<Data> q = new LinkedList<>();
		q.offer(new Data(start,0));
		visited[start] = true;
		int output = 0;
		while(!q.isEmpty())
		{
			Data pos = q.poll();
			
			if(pos.index == target)
			{
				output = pos.cnt;
				break;
			}
			
			for(int i = 1 ; i <= N ; i++)
			{
				if(arr[pos.index][i] == 1 && !visited[i])
				{
					visited[i] = true;
					q.offer(new Data(i,pos.cnt+1));
				}
			}
		}//while no empty
		return output;
	}
}
class Data
{
	public int index,cnt;
	Data(int index, int cnt)
	{
		this.index = index;
		this.cnt = cnt;
	}
}