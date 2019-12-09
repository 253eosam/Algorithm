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
	public static ArrayList<Node>[] list;
	public static int[] dis;
	public static final int INF = Integer.MAX_VALUE;
	public static int stoi(String str) { return Integer.parseInt(str); }
	public static class Node implements Comparable<Node>
	{
		int idx,w;
		public Node(int idx, int w) {
			this.idx = idx;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return this.w-o.w;
		}
		@Override
		public String toString() {
			return "Node [idx=" + idx + ", w=" + w + "]";
		}
		
	}
	public static void main(String[] args) throws Exception
	{
		input();
		logic();
		print();
	}
	private static void print() throws IOException {
		int max = 0;
		ArrayList<Integer> maxList = new ArrayList<>();
		for(int i = 1 ; i <= N ; i++)
		{
			if(max < dis[i])
			{
				maxList.clear();
				maxList.add(i);
				max = dis[i];
			}
			else if(max == dis[i])
				maxList.add(i);
		}
		
		bw.write(maxList.get(0) + " " + max + " " + maxList.size() + "\n");
		bw.flush();
	}
	private static void input() throws IOException {
		st= new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		
		list = new ArrayList[N+1];
		for(int i = 0 ; i <= N ; i++)
			list[i] = new ArrayList<>();
		
		dis= new int[N+1];
		
		for(int i = 0 ; i < M ; i++)
		{
			st=new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken());
			int b = stoi(st.nextToken());
			list[a].add(new Node(b,1));
			list[b].add(new Node(a,1));
		}
	}
	private static void logic() {
		dijkstar(1);
	}
	public static void makeINF(int start)
	{
		for(int i = 1 ; i <= N ;i++)
			dis[i] = INF;
		dis[start] = 0;
	}
	private static void dijkstar(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start,0));
		makeINF(start);
		
		while(!pq.isEmpty())
		{
			Node cur= pq.poll();
			for(Node next : list[cur.idx])
			{
				if(dis[next.idx] > dis[cur.idx] + next.w)
				{
					dis[next.idx] = dis[cur.idx] + next.w;
					pq.add(new Node(next.idx,dis[cur.idx]+next.w));
				}
			}
		}
	}
}
