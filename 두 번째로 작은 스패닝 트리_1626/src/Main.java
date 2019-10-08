import java.util.ArrayList;
import java.util.Collections;

public class Main 
{
	public static class Edge implements Comparable<Edge>
	{
		int a,b,cost;
		Edge(int a,int b,int cost)
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
	public static int V,E;
	public static ArrayList<Edge> list;
	public static int[] p;
	public static void main(String[] args) throws Exception
	{
		list = new ArrayList<>();
		p = new int[V+1];
		
		list.add(new Edge(1,2,1));
		
		
		
		Collections.sort(list);
		
		int minCost = 0;
		for(Edge e : list)
			minCost += unionSet(e);
		
		
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
	public static int unionSet(Edge e)
	{
		int cost = 0;
		int alpha = findSet(e.a);
		int beta = findSet(e.b);
		if(alpha != beta)
		{
			p[beta] = alpha;
			cost += e.cost;
		}
		return cost;
	}
}
