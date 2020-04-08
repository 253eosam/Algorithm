import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int F,S,G,U,D;
	public static int[] arr;
	public static boolean visited[];
	public static final int MAX_SIZE = 1_000_001;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		F = sc.nextInt();
		S = sc.nextInt();
		G = sc.nextInt();
		U = sc.nextInt();
		D = sc.nextInt();
		long time = System.currentTimeMillis();
		arr = new int[MAX_SIZE*3];
		visited = new boolean[MAX_SIZE*3];
		
		int solv = bfs(S);
		if(solv == -1)
			System.out.println("use the stairs");
		else
			System.out.println(solv);
		
		System.out.println(System.currentTimeMillis()-time);
	}
	public static int bfs(int start)
	{
		Queue<Data> q = new LinkedList<>();
		q.offer(new Data(start,0));
		visited[start] = true;
		int output = -1;
		Data pos = null;
		while(!q.isEmpty())
		{
			pos = q.poll();
			
			if(pos.x == G)
				output = pos.cnt;
			
			// Up
			int tmp = pos.x + U;
			if(tmp <= F && !visited[tmp])
			{
				visited[tmp] = true;
				q.offer(new Data(tmp,pos.cnt+1));
			}
			
			//Down
			tmp = pos.x - D;
			if(0 < tmp && !visited[tmp])
			{
				visited[tmp] = true;
				q.offer(new Data(tmp,pos.cnt+1));
			}
		}
		
		return output;
	}
}
class Data
{
	public int x,cnt;
	Data(int x, int c)
	{
		this.x = x;
		this.cnt = c;
	}
}