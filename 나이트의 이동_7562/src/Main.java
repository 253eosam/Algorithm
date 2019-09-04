import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int N;
	public static int[][] arr;
	public static boolean[][] visited;
	public static Data starting,target;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tNum = 1 ; tNum <= T ; tNum++)
		{
			// init
			N = sc.nextInt();
			arr = new int[N][N];
			visited = new boolean[N][N];
			
			//input
			starting = new Data(sc.nextInt(),sc.nextInt(),0);
			target = new Data(sc.nextInt(),sc.nextInt(),0);
			
			//logic
			Data solv = bfs(starting);
			
			//print
			System.out.println(solv.cnt);
		}//for tNum
	}
	public static int[] dy = { -2,-1,1,2,2,1,-1,-2};
	public static int[] dx = { 1,2,2,1,-1,-2,-2,-1};
	public static Data bfs(Data starting)
	{
		Queue<Data> q = new LinkedList<>();
		q.offer(starting);
		visited[starting.y][starting.x] = true;
		Data output = null;
		while(!q.isEmpty())
		{
			Data d = q.poll();
			if(d.y == target.y && d.x == target.x)
			{
				output = d;
				break;
			}
			
			for(int i = 0 ; i < dy.length ; i++)
			{
				int ty = d.y + dy[i];
				int tx = d.x + dx[i];
				if(0 <= ty && ty < N && 0 <= tx && tx < N && !visited[ty][tx])
				{
					visited[ty][tx] = true;
					q.offer(new Data(ty,tx,d.cnt+1));
				}
			}
		}
		
		return output;
	}

}
class Data
{
	public int y,x,cnt;
	Data(int y, int x , int c)
	{
		this.y = y;
		this.x = x;
		this.cnt = c;
	}
}