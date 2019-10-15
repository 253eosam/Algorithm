import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int N,M,K;
	public static int[][] dp;
	public static int[] dis;
	public static ArrayList<Edge>[] arr;
	public static final int INF = Integer.MAX_VALUE;
	public static final int START = 1;
	public static boolean visited[];
	public static int target;
	public static int solv;
	public static class Edge implements Comparable<Edge>
	{
		int idx,cost,dis;
		Edge(int idx , int cost, int dis)
		{
			this.idx=idx;
			this.cost=cost;
			this.dis=dis;
		}
		@Override
		public String toString() {
			return "Edge [idx=" + idx + ", cost=" + cost + ", dis=" + dis + "]";
		}
		@Override
		public int compareTo(Edge o) {
			return this.dis-o.dis;
		}
	}
	public static class Vertex implements Comparable<Vertex>
	{
		int idx,dis;
		Vertex(int idx , int dis)
		{
			this.idx=idx;
			this.dis=dis;
		}
		@Override
		public int compareTo(Vertex o) {
			return this.dis-o.dis;
		}
	}
	public static void main(String[] args) throws IOException {
		
		int T = Integer.parseInt(br.readLine());
		for(int tNum = 1 ; tNum <= T ; tNum++)
		{
			init();
			makeINF();
			Dijkstra();
			test();
//			print();
		}//for tNum
		bw.close();
	}
	public static void test()
	{
		for(int i = 1 ; i <= N ; i++)
			System.out.print(dis[i] + " ");
	}
	public static void Dijkstra2()
	{
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(START,M,0));
		Edge cur;
		while(!pq.isEmpty())
		{
			cur = pq.poll();
			if(dp[cur.idx] > cur.cost) continue;
			if(cur.idx == target)
			{
				solv = dis[cur.idx];
				break;
			}
			
			for(Edge next : arr[cur.idx])
			{
				if(dis[next.idx] > dis[cur.idx] + next.dis)
				{
					dis[next.idx] = dis[cur.idx] + next.dis;
					pq.add(new Edge(next.idx, cur.cost-next.cost ,dis[cur.idx] + next.dis));
				}
			}
		}
	}
	public static void Dijkstra()
	{
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.add(new Vertex(START,0));
		
		while(!pq.isEmpty())
		{
			Vertex cur = pq.poll();
			
			for(Edge e : arr[cur.idx])
			{
				if(dis[e.idx] > dis[cur.idx] + e.dis)
				{
					dis[e.idx] = dis[cur.idx] + e.dis;
					
					pq.add(new Vertex(e.idx,dis[cur.idx] + e.dis));
				}
			}
		
		}
	}
	public static void print() throws IOException
	{
		if(dis[target] == INF)
			bw.write("Poor KCM");
		else
			bw.write(String.valueOf(dis[target]));
		bw.write("\n");
	}
	public static void makeINF()
	{
		for(int i = 1 ; i <= N ; i++)
			dis[i] = INF;
		dis[START] = 0;
	}
	public static void init() throws IOException
	{
		st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dp = new int[][N+1];
		dis = new int[N+1];
		arr = new ArrayList[N+1];
		visited = new boolean[N+1];
		for(int i = 0 ; i <= N ; i++)
		{
			arr[i] = new ArrayList<>();
			dp[i] = INF;
		}
		
		for(int i = 0 ; i < K ; i++)
		{
			st=new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			arr[a].add(new Edge(b,c,d));
		}
		
		target = N;
	}

}
