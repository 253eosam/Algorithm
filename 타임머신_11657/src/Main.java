import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int N,M;
	public static int[] dis,solv;
	public static ArrayList<Node> arr;
	public static void main(String[] args) throws Exception 
	{
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new ArrayList<>();
		
		for(int i = 0 ; i < M ; i++)
		{
			st=new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr.add(new Node(a,b,c));
		}
		dis = new int[N+1];
		
		makeINF(1);
		bellman(1);
		print();
	}
	public static final int INF = Integer.MAX_VALUE;
	public static void print() throws IOException
	{
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 2 ; i <= N ; i++)
		{
			if(dis[i] != solv[i])
			{
				bw.write("-1");
				bw.close();
				return;
			}
		}
		
		for(int i = 2 ; i <= N ; i++)
		{
			if(dis[i] == INF)
				bw.write("-1");
			else
				bw.write(String.valueOf(dis[i]));
			bw.write("\n");
		}
		bw.close();
	}
	public static void makeINF(int start)
	{
		for(int i = 0 ; i <= N ; i++)
			dis[i] = INF;
		dis[start] = 0;
	}
	public static void bellman(int start)
	{
		for(int i = 0 ; i < N-1 ; i++)
			ssp(start);
		
		solv = dis.clone();
		ssp(start);
	}
	public static void ssp(int start)
	{
		for(Node edge : arr)
		{
			if(dis[edge.a] != INF && dis[edge.b] > dis[edge.a] + edge.w)
			{
				dis[edge.b] = dis[edge.a] + edge.w;
			}
		}
	}
	public static class Node implements Comparable<Node>
	{
		int a,b,w;
		Node(int a, int b, int w)
		{
			this.a=a;
			this.b=b;
			this.w=w;
		}
		@Override
		public int compareTo(Node o) {
			return this.w-o.w;
		}
	}
	
}
