import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int H,W,M,solv;
	public static boolean[][] targets, visited, arr;
	public static class Node
	{
		int y,x,cnt;
		Node(int y, int x, int cnt)
		{
			this.y=y;
			this.x=x;
			this.cnt=cnt;
		}
		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", cnt=" + cnt + "]";
		}
	}
	public static void main(String[] args) throws Exception 
	{
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken())+1;
		H = Integer.parseInt(st.nextToken())+1;
		
		targets = new boolean[H][W];
		visited = new boolean[H][W];
		arr = new boolean[H][W];
		for(int i = 1 ; i < H-1 ; i++)
		{
			for(int j  = 1 ; j < W-1 ; j++)
			{
				arr[i][j] = true;
			}
		}
		M = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i <= M ; i++)
		{
			st= new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int loc = Integer.parseInt(st.nextToken());

			int y=0,x=0;
			// 1 북, 2 남, 3 서, 4 동
			switch(dir)
			{
			case 1:
				y = 0;
				x = loc;
				break;
			case 2:
				y = H-1;
				x = loc;
				break;
			case 3:
				y = loc;
				x = 0;
				break;
			case 4:
				y = loc;
				x = W-1;
				break;
			}
			
			if(i == M)
				BFS(new Node(y,x,0));
			else
				targets[y][x] = true;
		}
		bw.write(String.valueOf(solv));
		bw.close();
	}//main
	public static int[] dy = { -1, 0 , 1 , 0 };
	public static int[] dx = {  0, 1 , 0 ,-1 };
	public static void BFS(Node start)
	{
		Queue<Node> q = new LinkedList<>();
		q.add(start);
		visited[start.y][start.x] = true;
		
		Node pos = null;
		while(!q.isEmpty())
		{
			pos = q.poll();
//			System.out.println(pos);
			if(targets[pos.y][pos.x])
			{
				solv += pos.cnt;
			}
			
			for(int i = 0 ; i < 4 ; i++)
			{
				int ty = dy[i] + pos.y;
				int tx = dx[i] + pos.x;
				if(0 <= ty && ty < H && 0 <= tx && tx < W
						&& !arr[ty][tx] && !visited[ty][tx])
				{
					q.add(new Node(ty,tx,pos.cnt+1));
					visited[ty][tx] = true;
				}
			}
		}
	}
}
