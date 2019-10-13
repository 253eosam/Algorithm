import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
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
	public static ArrayList<Integer> targets;	//목적지 후보들
	public static int[] dis,dis2;
	public static PriorityQueue<Edge> pq;
	public static ArrayList<Edge>[] arr;
	public static final int INF = Integer.MAX_VALUE;
	public static int ghDis, fIdx , sIdx, allDis;	// g에서 h까지의 거리, s에서 g or h중 가까운 곳을 fIdx , 먼곳을 sIdx로 잡음, allDis = s -> fIdx -> sIdx
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
		@Override
		public String toString() {
			return "Edge [idx=" + idx + ", w=" + w + "]";
		}
	}
	public static void main(String[] args) throws Exception 
	{

		T = Integer.parseInt(br.readLine());
		for(int tNum = 1 ; tNum <= T ; tNum++)
		{
			init();
			
			makeInfi(dis,s);
			dijkstra(dis,s);
			findFastMidVertex();
			
			allDis = dis[fIdx] + ghDis;
			
			makeInfi(dis2,sIdx);
			dijkstra(dis2,sIdx);
			
			print();
	
			
		}//for tNum
		bw.close();
	}
	public static void print() throws IOException
	{
		for(int i : targets)
		{
			if(allDis + dis2[i] == dis[i])
			{
				bw.write(i + " ");
			}
		}
		bw.write("\n");
	}
	public static void findFastMidVertex()
	{
		if(dis[g] < dis[h])
		{
			fIdx = g;
			sIdx = h;
		}
		else
		{
			fIdx = h;
			sIdx = g;
		}
	}
	public static void dijkstra(int[] dis, int start)
	{
		pq.add(new Edge(start,0));
		
		Edge cur = null;
		while(!pq.isEmpty())
		{
			cur = pq.poll();
			
			for(Edge next : arr[cur.idx])
			{
				if(dis[next.idx] > dis[cur.idx] + next.w)
				{
					pq.add(new Edge(next.idx, dis[cur.idx] + next.w));
					dis[next.idx] = dis[cur.idx] + next.w;
				}
				
			}
		}
	}
	public static void makeInfi(int[] dis, int start)
	{
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
			if((a == g && b == h) || (a == h && b == g))
				ghDis = d;
		}
		
		targets = new ArrayList<>();
		for(int i = 0 ; i < t ; i++)
			targets.add(Integer.parseInt(br.readLine()));
		
		Collections.sort(targets);
		
		dis = new int[n+1];
		dis2 = new int[n+1];
	}

}
