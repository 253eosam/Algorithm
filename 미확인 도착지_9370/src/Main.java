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
	public static int T;
	public static int n,m,t;	// 교차로, 도로, 목적지 후보의  개수
	public static int s,g,h;	// 예술가 출발지, 교차로 양 쪽의 정점
	public static int a,b,d;	// a 와 b 사이의 양뱡향 도로
	public static ArrayList<Integer> targets;	//목적지 후도들
	public static int[] dis;
	public static PriorityQueue<Edge> pq;
	public static ArrayList<Edge>[] arr;
	public static final int INF = Integer.MAX_VALUE;
	public static class Edge implements Comparable<Edge>
	{
		int idx,w;
		Edge(int idx, int w)
		{
			this.idx=idx;
			this.w=w;
		}
		@Override
		public int compareTo(Edge o) {
			return this.w-o.w;
		}
		
	}
	public static void main(String[] args) throws Exception 
	{

		T = Integer.parseInt(br.readLine());
		for(int tNum = 1 ; tNum <= T ; tNum++)
		{
			init();
			
		}//for tNum
	}
	public static void makeInfi(int start)
	{
		dis = new int[n+1];
		for(int i = 0 ; i <= n ; i++)
			dis[i] = INF;
		dis[start] = 0;
	}
	public static void init() throws Exception
	{
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		pq = new PriorityQueue<>();
		arr = new ArrayList[n+1];
		for(int i = 0 ; i <= n ; i++)
			arr[i] = new ArrayList<>();
		
		for(int i = 0 ; i < m ; i++)
		{
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			arr[a].add(new Edge(b,d));
			arr[b].add(new Edge(a,d));
		}
		
		targets = new ArrayList<>();
		for(int i = 0 ; i < t ; i++)
			targets.add(Integer.parseInt(br.readLine()));
		
	}

}
