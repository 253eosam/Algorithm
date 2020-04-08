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
	public static int N,M;
	public static ArrayList<Edge> list;
	public static int edgeNumber;
	public static class Edge implements Comparable<Edge>
	{
		int a,b,cost;
		Edge(int a, int b, int cost)
		{
			this.a =a;
			this.b =b;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
	public static void main(String[] args) throws Exception 
	{
		while(true)
		{

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			edgeNumber = N-1;
			if(N == 0 && M == 0) break;
			list = new ArrayList<>();
			int allCostSum = 0;
			for(int i = 0 ; i < M ; i++)
			{
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				list.add(new Edge(a,b,cost));
				allCostSum += cost;
			}

			Collections.sort(list);

			p = new int[N];
			makeSet();

			for(Edge e : list)
			{
				if(edgeNumber == 0) break;
				allCostSum -= unionSet(e);
			}

			bw.write(String.valueOf(allCostSum) + "\n");
		}
		bw.close();
	}
	public static int[] p;
	public static void makeSet()
	{
		for(int i = 0 ; i < N ; i++)
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
			edgeNumber--;
		}

		return cost;
	}
}
