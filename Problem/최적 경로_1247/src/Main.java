import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static int V,E,K;
	public static ArrayList<Pos>[] arr;
	public static int[] p;
	public static int[] dis;
	public static PriorityQueue<Pos> pq = new PriorityQueue<>();
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
			arr[a].add(new Pos(b,w));
		}//for input

		//logic
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
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		pq.offer(new Pos(start,0));
		dis[start] = 0;
		
		while(!pq.isEmpty())
		{
			Pos pos = pq.poll();
			
			for(Pos p : arr[pos.next])
			{
				if(dis[p.next] > p.w + dis[pos.next])
				{
					dis[p.next] = dis[pos.next] + p.w;
					pq.offer(new Pos(p.next , pos.w + dis[pos.next]));
				}
			}
		}
		
	}
}
class Pos implements Comparable<Pos>
{
	public int next,w;
	Pos( int b, int w)
	{
		this.next =b;
		this.w =w;
	}
	@Override
	public int compareTo(Pos o) {
		return this.w - o.w;
	}
}