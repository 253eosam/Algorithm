import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int N, M;
	public static int solv;
	public static int[] p;
	public static ArrayList<Edge> list;
	public static int setNum;
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
	public static void main(String[] args) throws Exception
	{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		p = new int[N+1];
		setNum = N;
		list = new ArrayList<>();
		for(int i = 0 ; i < M ; i++)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list.add(new Edge(a,b,cost));
		}
		
		makeSet();
		Collections.sort(list);
		
		int tmp = 0;
		for(Edge e : list)
		{
			if(setNum == 1) break;
			tmp = unionSet(e);
			solv += tmp;
		}
		solv -= tmp;
		
		bw.write(String.valueOf(solv));
		bw.flush();
		bw.close();
	}

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
	public static int unionSet(Edge e)
	{
		int cost = 0;
		int alpha = findSet(e.a);
		int beta = findSet(e.b);
		if(alpha != beta)
		{
			p[beta] = alpha;
			cost = e.cost;
			setNum--;
		}
		return cost;
	}
	public static boolean DEBUG = false;
}
