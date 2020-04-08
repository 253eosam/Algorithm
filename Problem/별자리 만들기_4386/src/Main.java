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
	public static int N;
	public static ArrayList<Edge> edges;
	public static double[] x,y;
	public static int[] p;
	public static double solv;
	public static int minimunEdgeNumber;
	public static class Edge implements Comparable<Edge>
	{
		int a,b; double cost;
		Edge(int a, int b, double cost)
		{
			this.a=a;
			this.b=b;
			this.cost=cost;
		}
		@Override
		public int compareTo(Edge o) {
			return this.cost-o.cost >= 0 ? 1 : -1;
		}
	}
	public static void main(String[] args) throws Exception
	{

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		minimunEdgeNumber = N-1;
		edges = new ArrayList<>();
		x= new double[N]; y=new double[N];
		p = new int[N];
		
		for(int i = 0 ; i < N ; i++)
		{
			st=new StringTokenizer(br.readLine());
			x[i] = Double.parseDouble(st.nextToken());
			y[i] = Double.parseDouble(st.nextToken());
			for(int j = 0 ; j < i ; j++)
			{
				edges.add(new Edge(i,j,Math.sqrt(Math.pow(x[i]-x[j],2) + Math.pow(y[i]-y[j],2))));
			}
		}
		
		makeSet();
		Collections.sort(edges);
		
		for(Edge e : edges)
		{
			if(minimunEdgeNumber == 0) break;
			unionSet(e);
		}
		
		bw.write(String.format("%.2f", solv));
		bw.flush();
		bw.close();
	}
	public static void makeSet()
	{
		for(int i = 0 ; i < N ; i++)
			p[i] = i;
	}
	public static int findSet(int x)
	{
		if(p[x] == x) return x;
		return p[x]=findSet(p[x]);
	}
	public static void unionSet(Edge e)
	{
		int alpha = findSet(e.a);
		int beta = findSet(e.b);
		if(alpha != beta)
		{
			p[beta] = alpha;
			solv += e.cost;
			minimunEdgeNumber--;
		}
	}

}
