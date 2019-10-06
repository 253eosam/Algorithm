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
	public static ArrayList<Vertex> arr;
	public static int edgeNumber;
	public static class Edge implements Comparable<Edge>
	{
		int a,b; double cost;
		Edge(int a, int b, double cost)
		{
			this.a =a;
			this.b =b;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost >= 0 ? 1 : -1;
		}
	}
	public static class Vertex 
	{
		int y,x,index;
		Vertex(int y, int x, int index)
		{
			this.y=y;
			this.x=x;
			this.index=index;
		}
	}
	public static void main(String[] args) throws Exception 
	{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		arr = new ArrayList<>();
		edgeNumber = N -1;
		
		for(int i = 0 ; i < N ; i++)
		{
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr.add(new Vertex(y,x,i));
		}
		
		Vertex e1, e2;
		p = new int[N];
		makeSet();
		double costSum = 0;
		
		//이미 있는 간선 미리 입력
		for(int i = 0 ; i < M ; i++)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			e1 = arr.get(a);
			e2 = arr.get(b);
			double distance = Math.sqrt(Math.pow(e1.x-e2.x, 2) + Math.pow(e2.y-e2.y,2));
			unionSet(new Edge(e1.index,e2.index,distance));
		}
		
		for(int i = 0 ; i < N ; i++)
		{
			for(int j = 0 ; j < i ; j++)
			{
				e1 = arr.get(i);
				e2 = arr.get(j);
				double distance = Math.sqrt(Math.pow(e1.x-e2.x, 2) + Math.pow(e1.y-e2.y,2));
				list.add(new Edge(e1.index,e2.index,distance));
			}
		}
		
		Collections.sort(list);
		
		for(Edge e : list)
		{
			if(edgeNumber == 0) break;
			costSum += unionSet(e);
		}
		
		bw.write(String.format("%.2f",costSum));
		bw.flush();
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
	public static double unionSet(Edge e)
	{
		double cost = 0;
		
		int alpha = findSet(e.a);
		int beta = findSet(e.b);
		
		if(alpha != beta)
		{
			p[beta] = alpha;
			cost = e.cost;
			edgeNumber--;
//			System.out.println(e.a + " , " + e.b + " : " + e.cost);
		}
		
		return cost;
	}
}
