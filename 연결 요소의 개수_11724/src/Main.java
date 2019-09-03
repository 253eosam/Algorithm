import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static boolean[] visited;
	public static int N,M,cnt;
	public static boolean[][] arr;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new boolean [N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i  = 0 ; i < M ; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[b][a] = arr[a][b] = true;
		}
		
		for(int i = 1 ; i <= N ; i++)
		{
			if(visited[i]) continue;
			visited[i] = true;
			bfs(i);
			cnt++;
		}
		
		System.out.println(cnt);
	}
	public static void bfs(int start)
	{
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		while(!q.isEmpty())
		{
			int pos = q.poll();
			for(int i = 1 ; i <= N ; i++)
			{
				if(visited[i]) continue;
				if(arr[pos][i])
				{
					q.offer(i);
					visited[i]=true;
				}
			}
		}
	}
}
