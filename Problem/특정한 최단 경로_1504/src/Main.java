import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static ArrayList<Edge>[] arr;
	public static PriorityQueue<Edge> pq;
	public static int V,E;
	public static final int midNum = 4;
	public static int[] mid;
	public static int[] dis;
	public static final int INF = Integer.MAX_VALUE;
	public static class Edge implements Comparable<Edge>
	{
		int idx, w;
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
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		arr = new ArrayList[V+1];
		for(int i = 0 ; i <= V ; i++ )
			arr[i] = new ArrayList<>();
		pq = new PriorityQueue<>();
		mid = new int[midNum];
		dis = new int[V+1];
		for(int i = 0 ; i < E ; i++)
		{
			st=new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr[a].add(new Edge(b,w)); arr[b].add(new Edge(a,w));
		}

		st = new StringTokenizer(br.readLine());
		int start = 1; 
		int target = V;
		for(int i = 1 ; i < midNum-1 ; i++)
			mid[i] = Integer.parseInt(st.nextToken());
		mid[0] = start; 
		mid[midNum-1] = target;

		int solv = Integer.MAX_VALUE;
		for(int k = 0 ; k < 2 ; k++)
		{
			int sum = 0;
			for(int i = 0 ; i < midNum-1 ; i++)
			{
				makeInfi(mid[i]);
				int tmp = dijkstra(mid[i],mid[i+1]);
				if(tmp == INF) 
				{
					sum = INF;
					break;
				}
				sum += tmp;
			}
			
//			System.out.println();
			swap(1,2);
			solv = Math.min(solv, sum);
		}


		if(solv == INF) 
			bw.write("-1");
		else 
			bw.write(String.valueOf(solv));
		bw.close();
	}
	public static void swap(int a, int b)
	{
		int tmp = mid[a];
		mid[a] = mid[b];
		mid[b] = tmp;
	}
	public static void makeInfi(int start)
	{
		for(int i = 0 ; i <= V ; i++)
			dis[i] = INF;
		dis[start] = 0;
	}
	public static int dijkstra(int start, int target)
	{
		pq.add(new Edge(start,0));

		Edge cur;
		while(!pq.isEmpty())
		{
			cur = pq.poll();


			for(Edge next : arr[cur.idx])
			{
				if(dis[next.idx] > dis[cur.idx] + next.w)
				{
					pq.add(new Edge(next.idx,dis[cur.idx] + next.w));
					dis[next.idx] = dis[cur.idx] + next.w;
				}
			}
		}

//		System.out.println("dis : " + dis[target]);
		return dis[target];
	}

}
