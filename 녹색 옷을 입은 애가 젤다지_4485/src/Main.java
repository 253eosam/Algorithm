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
	public static int N;
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
	public static int cnt;
	public static void main(String[] args) throws Exception
	{
		cnt = 1;
		while(true)
		{
			N = Integer.parseInt(br.readLine());
			if(N == 0 ) break;
			dis=new int[N][N];
			arr=new int[N][N];
			
			for(int i = 0 ; i < N ; i++)
			{
				st=new StringTokenizer(br.readLine());
				for(int j = 0 ; j < N ; j++)
				{
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			makeINF(0, 0);
			dijkstra();
			print();
		}
	}
	public static void print() throws IOException
	{
		bw.write(String.valueOf("Problem "+(cnt++)+": "+dis[N-1][N-1]) + "\n");
		bw.flush();
	}
	public static int[] dy = { -1,0,1,0 };
	public static int[] dx = { 0,1,0,-1 };
	public static void makeINF(int startY, int startX)
	{
		for(int i = 0 ; i < N ; i++)
		{
			for(int j = 0 ; j < N ; j ++)
			{
				dis[i][j] = INF;
			}
		}
	}
	public static void dijkstra()
	{
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		pq.add(new Edge(0,0,arr[0][0]));
		dis[0][0] = arr[0][0];
		
		Edge cur;
		while(!pq.isEmpty())
		{
			cur = pq.poll();
			
			if(cur.y == N-1 && cur.x == N-1)
				break;
			
			for(int i = 0 ; i < 4 ; i++)
			{
				int ty = dy[i] + cur.y;
				int tx = dx[i] + cur.x;
				if(!(0 <= ty && ty < N && 0 <= tx && tx < N)) continue;
				
				if(dis[ty][tx] > dis[cur.y][cur.x] + arr[ty][tx])
				{
					dis[ty][tx] = dis[cur.y][cur.x] + arr[ty][tx];
					pq.add(new Edge(ty,tx,dis[ty][tx]));
				}
			}
		}
	}
}
