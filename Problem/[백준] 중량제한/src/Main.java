import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static final int MAXIMUM = 1_000_000_000;
	
	public static int N,M,ts,te;
	public static ArrayList<Pos>[] list;
	public static class Pos{
		int x, w;
		public Pos(int x, int w) {
			super();
			this.x = x;
			this.w = w;
		}
	}
	public static void main(String[] args) throws IOException {
		input();
		logic();
	}
	private static void logic() throws IOException {
		bw.append(String.valueOf(bs()));
		bw.close();
	}
	public static int bs() {
		int left = 1;
		int right = MAXIMUM;
		
		while(left <= right) {
			int mid = (left+right)/2;
			if(!bfs(mid)) right = mid-1;
			else left = mid+1;
		}
		
		return right;
	}
	public static boolean bfs(int val) {
		boolean[] visited = new boolean[N+1];
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(ts,0));
		visited[ts] = true;
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			if(p.x == te) return true;
			for(Pos tmp : list[p.x]) {
				if(val <= tmp.w && !visited[tmp.x]) {
					q.add(tmp);
					visited[tmp.x] = true;
				}
			}
		}
		
		return false;
	}
	private static void input() throws IOException {
		StringTokenizer st=new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list=new ArrayList[N+1];
		for(int i = 1 ; i <= N ; i++) list[i] = new ArrayList<>();
		
		for(int i = 0 ; i < M ; i++) {
			st= new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[s].add(new Pos(e,w));
			list[e].add(new Pos(s,w));
		}
		st=new StringTokenizer(br.readLine());
		ts = Integer.parseInt(st.nextToken());
		te = Integer.parseInt(st.nextToken());
	}
}