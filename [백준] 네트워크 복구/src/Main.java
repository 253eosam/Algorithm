import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	
	public static int N,M;
	public static PriorityQueue<Pos> pq;
	public static HashMap<Integer,Integer>[] arr;
	public static int[] connection;
	public static int[] cost;
	public static class Pos implements Comparable<Pos>{
		int idx,cost;
		public Pos(int idx, int cost) {
			super();
			this.idx = idx;
			this.cost = cost;
		}
		@Override
		public int compareTo(Pos o) {
			return this.cost - o.cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		input();
		logic();
		print();
	}

	private static void print() {
		System.out.println(N-1);
		for(int i = 2 ; i <= N ; i++) {
			System.out.println(i + " " + connection[i]);
		}
			
	}

	private static void logic() {
		dijkstra();
	}

	private static void dijkstra() {
		pq.add(new Pos(1,0));
		cost[1] = 0;
		
		while(!pq.isEmpty()) {
			Pos p = pq.poll();
			
			for(int next : arr[p.idx].keySet()) {
				if(cost[next] > arr[p.idx].get(next) + p.cost) {
					cost[next] = arr[p.idx].get(next) + p.cost;
					pq.add(new Pos(next,cost[next]));
					connection[next] = p.idx;
				}
			}
		}
	}

	private static void input() throws IOException {
		st=new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cost = new int[N+1]; connection = new int[N+1];
		for(int i = 0 ; i <= N ; i++) cost[i] = Integer.MAX_VALUE;
		pq = new PriorityQueue<Main.Pos>();
		arr = new HashMap[N+1];
		for(int i = 0 ; i <= N ; i++)
			arr[i] = new HashMap<Integer, Integer>();
		for(int i = 0 ; i < M ; i++) {
			st=new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr[a].put(b, w);
			arr[b].put(a, w);
		}
	}

}
