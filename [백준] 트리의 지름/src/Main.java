import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int stoi(String str) { return Integer.parseInt(str); }
	
	public static int N, maximum, standNode;
	public static ArrayList<Node>[] graph;
	public static boolean[] visited;
	
	public static class Node{
		int idx,w;

		public Node(int idx, int w) {
			super();
			this.idx = idx;
			this.w = w;
		}
		
	}
	public static void main(String[] args) throws IOException {
		input();
		logic();
		print();
	}

	private static void print() throws IOException {
		bw.append(String.valueOf(maximum));
		bw.flush();
	}

	private static void logic() {
	
		// 아무 위치에서 가장 거리가 긴 노드하나를 잡는다
		visited=new boolean[N+1];
		dfs(new Node(standNode,0));

		// 긴 노드를 찾았다면 이 노드를 기준으로 갈수있는 가장 긴 노드를 찾는다.
		visited=new boolean[N+1];
		dfs(new Node(standNode,0));
		
	}


	private static void dfs(Node n) {
		if(visited[n.idx]) return ;
		visited[n.idx] = true;
		
		if(n.w > maximum) {
			maximum = n.w;
			standNode = n.idx;
		}
		
		for(Node next : graph[n.idx]) {
			dfs(new Node(next.idx,n.w+next.w));
		}
	}

	private static void input() throws IOException {
		N = stoi(br.readLine());
		standNode = 1;
		
		graph = new ArrayList[N+1];
		for(int i = 0 ; i <= N ; i++)
			graph[i] = new ArrayList<>();
		
		for(int i = 0 ; i < N-1 ; i++) {
			st= new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken());
			int b = stoi(st.nextToken());
			int w = stoi(st.nextToken());
			
			graph[a].add(new Node(b,w));
			graph[b].add(new Node(a,w));
			
		}
	}

}
