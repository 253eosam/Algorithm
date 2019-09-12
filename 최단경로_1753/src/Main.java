import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static int V,E,K;
	public static ArrayList<Data>[] arr;
	public static int[] p;
	public static int[] dis;
	public static PriorityQueue<Data> pq = new PriorityQueue<>();
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		arr = new ArrayList[V+1];
		p = new int[V+1];
		dis = new int[V+1];
		
		for(int i = 1 ; i <= V ; i++)
			dis[i] = Integer.MAX_VALUE;
		
		for(int i = 0 ; i <= V ; i++)
			arr[i] = new ArrayList<>();

		for(int i = 0 ; i < E ; i++)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr[a].add(new Data(b,w));
		}//for input

		//logic
		makeSet();
		infinite();
		dijkstra(K);

		for(int i = 1 ; i <= V ; i++)
		{
			if(dis[i] == Integer.MAX_VALUE)
				bw.write("INF\n");
			else
				bw.write(String.valueOf(dis[i]) + "\n");
		}
		bw.flush();
		bw.close();

	}
	public static void infinite()
	{
		for(int i = 1 ; i <= V ; i++)
			dis[i] = Integer.MAX_VALUE;
	}
	public static void dijkstra(int start)
	{
		// starting point
		PriorityQueue<Data> pq = new PriorityQueue<>();
		pq.offer(new Data(start,0));
		dis[start] = 0;
		
		while(!pq.isEmpty())
		{
			Data pos = pq.poll();
			
//			System.out.println(pos.index + " : index , w : " + pos.w);
			for(Data idx : arr[pos.index])
			{
				if(dis[idx.index] > idx.w + dis[pos.index])
				{
					dis[idx.index] = dis[pos.index] + idx.w;
					pq.offer(new Data(idx.index , pos.w + dis[pos.index]));
				}
			}
		}
		
	}
	public static void makeSet()
	{
		for(int i = 1 ; i <= V ; i++)
			p[i] = i;
	}
	public static int findSet(int x)
	{
		if(p[x] == x) return x;
		return p[x] = findSet(p[x]);
	}
	public static void unionSet(int a, int b)
	{
		int pa = findSet(a);
		int pb = findSet(b);
		if(pa != pb)
			p[pb] = pa;
	}
}
class Data implements Comparable<Data>
{
	public int index,w;
	Data( int b, int w)
	{
		this.index =b;
		this.w =w;
	}
	@Override
	public int compareTo(Data o) {
		return this.w - o.w;
	}
}