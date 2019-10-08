import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int N,M;
	public static ArrayList<Edge> list;
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
			return this.cost-o.cost;
		}
	}
	public static void main(String[] args) throws Exception
	{
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		p = new int[N+1];
		
		bw.write(String.valueOf(N-1) + "\n");
		makeSet();
		list = new ArrayList<>();
		
		for(int i = 0 ; i < M ; i++)
		{
			st = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
//			if(a == 1)
//				unionSet(new Edge(a,b,cost));
//			else
				list.add(new Edge(a,b,cost));
		}
		
		Collections.sort(list);
		
		for(Edge e : list)
			unionSet(e);
		
		bw.close();
		
	}
	public static int[] p ;
	public static void makeSet()
	{
		for(int i = 1 ; i <= N ; i++)
			p[i] = i;
	}
	public static int findSet(int x)
	{
		if(p[x] == x) return x;
		return p[x] = findSet(p[x]);
	}
	public static void unionSet(Edge e) throws IOException
	{
		int alpha = findSet(e.a);
		int beta = findSet(e.b);
		if(alpha != beta)
		{
			bw.write(alpha + " " + beta + "\n");
			p[beta] = alpha;
		}
	}

}
