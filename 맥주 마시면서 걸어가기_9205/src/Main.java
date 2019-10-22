import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int N , M ;
	public static int startY,startX;
	public static int[] midY,midX;
	public static int targetY, targetX;
	public static final int INF = Integer.MAX_VALUE;
	public static int[] dis;
	public static int stoi(String str) { return Integer.parseInt(str); }
	public static void main(String[] args) throws Exception 
	{
		int T = stoi(br.readLine());
		
		
		for(int tNum = 1 ; tNum <= T ; tNum++)
		{
			M = stoi(br.readLine());
			
			st=new StringTokenizer(br.readLine());
			startX = stoi(st.nextToken());
			startY = stoi(st.nextToken());
			
			midY = new int[M+2]; midX = new int[M+2];
			midY[0] = startY ; midX[0] = startX;
			for(int i = 1 ; i <= M ; i++)
			{
				st=new StringTokenizer(br.readLine());
				midX[i] = stoi(st.nextToken());
				midY[i] = stoi(st.nextToken());
			}
			
			st=new StringTokenizer(br.readLine());
			midX[M+1] = targetX = stoi(st.nextToken());
			midY[M+1] = targetY = stoi(st.nextToken());
			
			dis = new int[M+3];
			dijkstra(0);
			/*
			 * 맥주가 20개
			 * 목이 마르면 안되기 때문에 50미터에 한병
			 */
			if(dis[M+1] == INF)
				bw.write("sad\n");
			else
				bw.write("happy\n");
		}
		bw.close();
	}
	public static void makeINF(int start)
	{
		for(int i = 0 ; i <= M+1 ; i++)
			dis[i] = INF;
		dis[start] = 0;
	}
	public static boolean dijkstra(int start)
	{
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		makeINF(start);
		pq.add(new Edge(0 , 0));
		Edge cur ;
		while(!pq.isEmpty())
		{
			cur = pq.poll();
			if(cur.idx == M+1)	return true;
			
			for(int i = 1 ; i <= M+1 ; i++)
			{
				int x = Math.abs(midX[cur.idx] - midX[i]);
				int y = Math.abs(midY[cur.idx] - midY[i]);
				int w = x+y;
				if(dis[i] > dis[cur.idx] + w && w <= 1000)
				{
					pq.add(new Edge(dis[cur.idx] + w, i));
					dis[i] = dis[cur.idx] + w;
				}
			}
		}
		
		return false;
	}
	public static class Edge implements Comparable<Edge>
	{
		int w,idx;
		Edge( int w , int idx)
		{
			this.w=w;
			this.idx = idx;
		}
		@Override
		public int compareTo(Edge o) {
			return this.w-o.w;
		}
		@Override
		public String toString() {
			return "Edge [w=" + w + ", idx=" + idx + "]";
		}
		
	}
}
