import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main 
{
	public static int N,M;
	public static int startNode , targetNode;
	public static int[] dis;
	public static final int INF = Integer.MAX_VALUE;
	public static int stoi(String str) { return Integer.parseInt(str) ; }
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int[][] arr;
	public static int preVal;
	public static ArrayList<deleteNode> deleteList;
	public static class deleteNode
	{
		public int a,b;
		public deleteNode(int a, int b) {
			this.a=a;
			this.b=b;
		}
	}
	public static class Edge implements Comparable<Edge>
	{
		int idx, w;
		String nodes;
		Edge(int idx, int w, String n)
		{
			this.idx = idx;
			this.w =w ;
			this.nodes = n;
		}
		@Override
		public int compareTo(Edge o) {
			return this.w-o.w;
		}
		@Override
		public String toString() {
			return "Edge [idx=" + idx + ", w=" + w + ", nodes=" + nodes + "]";
		}
		
	}
	public static void main(String[] args) throws Exception
	{
		while(true)
		{

			if(!init()) break;
			dijkstra(1);
			remove();
			dijkstra(2);
			print();
		}
	}
	private static void remove() {
		for(deleteNode dn : deleteList)
			arr[dn.a][dn.b] = INF;
	}
	private static void print() throws Exception
	{
		int solv = dis[targetNode];
		if(solv == INF)
			bw.write("-1\n");
		else
			bw.write(String.valueOf(solv)+"\n");
			
		bw.flush();
	}
	public static void makeINF()
	{
		for(int i = 0 ; i < N ; i++)
			dis[i] = INF;
		dis[startNode] = 0;
	}
	public static boolean init() throws Exception
	{
		st=new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		if( N==0 && M == 0)
			return false;

		st=new StringTokenizer(br.readLine());
		startNode = stoi(st.nextToken());
		targetNode = stoi(st.nextToken());

		dis = new int[N];
		arr = new int[N][N];
		deleteList = new ArrayList<>();
		preVal = INF;
		
		for(int i = 0 ; i < N ; i++)
			for(int j = 0 ;  j < N ; j++)
				arr[i][j] = (i==j) ? 0 : INF;
		
		for(int i = 0 ; i < M ; i++)
		{
			st=new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken());
			int b = stoi(st.nextToken());
			int w = stoi(st.nextToken());
			arr[a][b] = w;
		}

		return true;
	}
	public static void dijkstra(int c)
	{
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(startNode,0,String.valueOf(startNode)));
		Edge cur;
		makeINF();
		while(!pq.isEmpty())
		{
			cur = pq.poll();
			if(cur.idx == targetNode)
			{
				if(c == 1)
				{
					if(cur.w > dis[cur.idx])continue;
					String[] d = cur.nodes.split("-");
					for(int i = 0 ; i < d.length-1 ; i++)
					{
						deleteList.add(new deleteNode(stoi(d[i]), stoi(d[i+1])));
					}
				}
				else
				{
					break;
				}
			}

			for(int index = 0 ; index < N ; index++)
			{
				if(arr[cur.idx][index] > 0 && arr[cur.idx][index] != INF)
				{
					if(dis[index] >= dis[cur.idx] + arr[cur.idx][index])
					{
						dis[index] = dis[cur.idx] + arr[cur.idx][index];
						pq.add(new Edge(index,dis[index],cur.nodes+"-"+String.valueOf(index)));
					}
				}
			}
		}
	}
}
