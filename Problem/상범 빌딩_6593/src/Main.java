import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int L,R,C;
	public static int[][][] dis ;
	public static char[][][] arr;
	public static int targetY,targetX,targetZ;
	public static int startY, startX, startZ;
	public static final int INF = Integer.MAX_VALUE;
	public static int stoi(String str) { return Integer.parseInt(str);	}
	public static void main(String[] args) throws Exception 
	{
		while(true)
		{
			
			if(!init())
				break;
			dijkstra();
			print();
		}
		
		
		
	}
	public static int solv;
	private static void print() throws IOException {
		if(solv == INF)
			bw.write("Trapped!\n");
		else
			bw.write("Escaped in "+solv+" minute(s)."+"\n");
		bw.flush();
	}
	public static class Edge implements Comparable<Edge>
	{
		int z,y,x,w;
		Edge(int z, int y, int x, int w)
		{
			this.z=z;
			this.y=y;
			this.x=x;
			this.w=w;
		}
		@Override
		public int compareTo(Edge o) {
			return this.w-o.w;
		}
		
	}
	public static int[] dy = { -1,0,1,0,0,0 };
	public static int[] dx = { 0,1,0,-1,0,0 };
	public static int[] dz = { 0,0,0,0,1,-1 };
	private static void dijkstra() 
	{
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		pq.add(new Edge(startZ,startY,startX,0));
		
		Edge cur;
		while(!pq.isEmpty())
		{
			cur = pq.poll();
			
			if(arr[cur.z][cur.y][cur.x] == 'E')
			{
				solv = dis[cur.z][cur.y][cur.x];
				break;
			}
			
			for(int i = 0 ; i < dy.length ; i++)
			{
				int tz = dz[i] + cur.z;
				int ty = dy[i] + cur.y;
				int tx = dx[i] + cur.x;
				
				if(!(0 <= tz && tz < L 
						&& 0 <= ty && ty < R 
						&& 0 <= tx && tx < C)) continue;
				if(arr[tz][ty][tx] == '#') continue;
				if(dis[tz][ty][tx] > dis[cur.z][cur.y][cur.x] + 1)
				{
					dis[tz][ty][tx] = dis[cur.z][cur.y][cur.x] + 1;
					pq.add(new Edge(tz,ty,tx,dis[tz][ty][tx]));
				}
			}
		}
	}
	public static boolean init() throws Exception
	{
		st=new StringTokenizer(br.readLine());
		L = stoi(st.nextToken());
		R = stoi(st.nextToken());
		C = stoi(st.nextToken());
		solv = INF;
		
		if(L == 0 && R == 0 && C == 0)
			return false;
		
		dis =new int[L][R][C];
		arr =new char[L][R][C];
		
		makeINF();
		
		for(int i = 0 ; i < L ; i ++)
		{
			for(int j = 0 ; j < R ; j++)
			{
				String tmp = br.readLine();
				for(int k = 0 ; k < C ; k++)
				{
					char tmpChar = tmp.charAt(k);
					arr[i][j][k] = tmpChar;
					if(tmpChar == 'S')
					{
						startZ = i; startY = j; startX = k;
						dis[i][j][k] = 0;
					}
				}
			}
			br.readLine();
		}
		
		
		return true;
	}
	public static void makeINF()
	{
		for(int i = 0 ; i < L ; i ++)
		{
			for(int j = 0 ; j < R ; j++)
			{
				for(int k = 0 ; k < C ; k++)
				{
					dis[i][j][k] = INF;
				}
			}
		}
	}
}
