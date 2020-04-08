import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main 
{
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int N,M;
	public static int[][] dis,arr;
	public static final int INF = Integer.MAX_VALUE;
	public static class Edge implements Comparable<Edge>
	{
		int y,x, w;
		Edge(int y,int x, int w)
		{
			this.y=y;
			this.x=x;
			this.w=w;
		}
		@Override
		public int compareTo(Edge o) {
			return w-o.w;
		}
	}
	public static void main(String[] args) throws Exception
	{
		init();
		makeINF(0, 0);
		dijkstra();
		print();
	}
	public static void print() throws IOException
	{
		bw.write(String.valueOf(dis[N-1][M-1]));
		bw.close();
	}
	public static int[] dy = { -1,0,1,0 };
	public static int[] dx = { 0,1,0,-1 };
	public static void makeINF(int startY, int startX)
	{
		for(int i = 0 ; i < N ; i++)
		{
			for(int j = 0 ; j < M ; j ++)
			{
				dis[i][j] = INF;
				if(i == startY && j == startX)
					dis[i][j] = 0;
			}
		}
	}
	public static void dijkstra()
	{
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(0,0,0));
		
		Edge cur;
		while(!pq.isEmpty())
		{
			cur = pq.poll();
			
			if(cur.y == N-1 && cur.x == M-1)
				break;
			
			for(int i = 0 ; i < 4 ; i++)
			{
				int ty = dy[i] + cur.y;
				int tx = dx[i] + cur.x;
				if(!(0 <= ty && ty < N && 0 <= tx && tx < M)) continue;
				
				if(dis[ty][tx] > dis[cur.y][cur.x] + arr[ty][tx])
				{
					dis[ty][tx] = dis[cur.y][cur.x] + arr[ty][tx];
					pq.add(new Edge(ty,tx,dis[ty][tx]));
				}
			}
		}
	}
	public static void init() throws Exception
	{
		st=new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		dis=new int[N][M];
		arr=new int[N][M];
		
		for(int i = 0 ; i < N ; i++)
		{
			String tmp = br.readLine();
			for(int j = 0 ; j < M ; j++)
			{
				arr[i][j] = tmp.charAt(j) - '0';
			}
		}
	}
}
