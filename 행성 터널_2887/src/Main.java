import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int[] p;
	public static int N;
	public static ArrayList<Edge> list;
	public static int solv;
	public static int minEdgeNum;
	public static class Edge implements Comparable<Edge>
	{
		int a,b,cost;
		Edge(int a, int b, int cost)
		{
			this.a=a;
			this.b=b;
			this.cost=cost;
		}
		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
	public static class Vertex
	{
		int x,y,z;
		int index;
		Vertex(int x, int y, int z, int index)
		{
			this.x=x;
			this.y=y;
			this.z=z;
			this.index = index;
		}
		
	}
	public static Vertex[] vertexs;
	public static void main(String[] args) throws Exception 
	{
		N = Integer.parseInt(br.readLine());
		p = new int[N];
		list = new ArrayList<>();
		minEdgeNum = N-1;
		vertexs = new Vertex[N];
		
		for(int i = 0 ; i < N ; i++)
		{
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			vertexs[i] = new Vertex(x,y,z,i);
		}
		int tx,ty,tz,cost;
		
		Arrays.sort(vertexs, new Comparator<Vertex>() {

			@Override
			public int compare(Vertex o1, Vertex o2) {
				return o1.x-o2.x;
			}
		});
		for(int i = 0 ; i < N-1 ; i++)
		{
			tx = Math.abs(vertexs[i].x - vertexs[i+1].x);
			ty = Math.abs(vertexs[i].y - vertexs[i+1].y);
			tz = Math.abs(vertexs[i].z - vertexs[i+1].z);
			cost = Math.min(Math.min(tx, ty),tz);
			list.add(new Edge(vertexs[i].index,vertexs[i+1].index,cost));
		}
		
		Arrays.sort(vertexs, new Comparator<Vertex>() {

			@Override
			public int compare(Vertex o1, Vertex o2) {
				return o1.y-o2.y;
			}
		});
		for(int i = 0 ; i < N-1 ; i++)
		{
			tx = Math.abs(vertexs[i].x - vertexs[i+1].x);
			ty = Math.abs(vertexs[i].y - vertexs[i+1].y);
			tz = Math.abs(vertexs[i].z - vertexs[i+1].z);
			cost = Math.min(Math.min(tx, ty),tz);
			list.add(new Edge(vertexs[i].index,vertexs[i+1].index,cost));
		}
		
		Arrays.sort(vertexs, new Comparator<Vertex>() {

			@Override
			public int compare(Vertex o1, Vertex o2) {
				return o1.z-o2.z;
			}
		});
		for(int i = 0 ; i < N-1 ; i++)
		{
			tx = Math.abs(vertexs[i].x - vertexs[i+1].x);
			ty = Math.abs(vertexs[i].y - vertexs[i+1].y);
			tz = Math.abs(vertexs[i].z - vertexs[i+1].z);
			cost = Math.min(Math.min(tx, ty),tz);
			list.add(new Edge(vertexs[i].index,vertexs[i+1].index,cost));
		}
		/*
		int tx,ty,tz,cost;
		for(int i = 1 ; i <= N ; i++)
		{
			for(int j = i+1 ; j <= N ; j++)
			{
				tx = Math.abs(x[i]-x[j]);
				ty = Math.abs(y[i]-y[j]);
				tz = Math.abs(z[i]-z[j]);
				cost = Math.min(Math.min(tx, ty),tz);
				if(minLen[i] > cost)
				{
					minLen[i] = cost;
					list.add(new Edge(i,j,cost));
				}
			}
		}
		*/
		Collections.sort(list);
		makeSet();
		
		for(Edge e : list)
		{
			unionSet(e);
			if(minEdgeNum == 0) break;
		}
		
		bw.write(String.valueOf(solv));
		bw.close();
		
	}
	public static void makeSet()
	{
		for(int i = 0 ; i < N ; i ++)
			p[i] = i;
	}
	public static int findSet(int x)
	{
		if(p[x] == x) return x;
		return p[x] = findSet(p[x]);
	}
	public static void unionSet(Edge e)
	{
		int alpha = findSet(e.a);
		int beta = findSet(e.b);
		
		if(alpha != beta)
		{
			p[beta] = alpha;
			solv += e.cost;
			minEdgeNum--;
		}
	}
}
