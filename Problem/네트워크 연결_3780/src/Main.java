import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int N;
	public static int[] p;
	public static int[] arr;
	public static void main(String[] args) throws Exception
	{
		int T = Integer.parseInt(br.readLine());
		
		for(int tNum = 1 ; tNum <= T ; tNum++)
		{
			N = Integer.parseInt(br.readLine());
			
			p = new int[N+1];
			arr = new int[N+1];
			makeSet();
			
			outer:while(true)
			{
				st = new StringTokenizer(br.readLine());
				switch(st.nextToken())
				{
				case "E":
					int index = Integer.parseInt(st.nextToken());
					findSet(index);
					bw.write(String.valueOf(arr[index]) + "\n");
					break;
				case "I":
					int a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
					unionSet(new Edge(a,b,Math.abs(a-b)%1000));
					break;
				case "O":
					break outer;
				}
			}
		}//for tNum
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
		int tmp = findSet(p[x]);
		arr[x] += arr[p[x]];
		return p[x] = tmp;
	}
	public static void unionSet(Edge e)
	{
		int alpha = findSet(e.a);
		int beta = findSet(e.b);
		if(alpha != beta)
		{
			p[e.a] = e.b;
			arr[e.a] = e.cost;
		}
	}
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
}
