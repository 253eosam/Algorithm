import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	
	public static int N,M,answer;
	public static int[][] arr;
	public static boolean[][] visited;
	public static int[] parent;
	public static ArrayList<Node> list;
	public static int bridgeNum;
	public static class Pos{
		int y,x;
		public Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	public static class Node implements Comparable<Node>{
		int a,b,w;
		public Node(int a, int b, int w) {
			this.a = a;
			this.b = b;
			this.w = w;
		}
		@Override
		public int compareTo(Node n) {
			return w-n.w;
		}
		@Override
		public String toString() {
			return "Node [a=" + a + ", b=" + b + ", w=" + w + "]";
		}
	}
	
	public static void main(String[] args) throws IOException {
		input();
		logic();
		print();
	}

	private static void print() throws IOException {
		if(bridgeNum != 0) bw.append("-1");
		else bw.append(String.valueOf(answer));
		bw.flush();
	}

	private static void logic() {
		/*
		 * 1. BFS를 통해 구역 나누기
		 * 2. 다리 연결하기 ( 크루스칼을 이용 - 다리 값을 모두 넣어 작은 다리부터 뽑아서 싸이클이 발생하지않는 최소의 다리를 연결 )
		 */
		int cnt = 0;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(arr[i][j] == 0 || visited[i][j]) continue;
				bfs(new Pos(i,j),++cnt);
			}
		}
		
		makeBridge();
		makeSet(cnt);
		Collections.sort(list);
		bridgeNum = cnt-1;
		for(Node n : list) {
			if(bridgeNum == 0) break; 
			unionSet(n);
		}
	}
	private static void makeBridge() {
		for(int y = 0 ; y < N ; y++) {
			for(int x = 0 ; x < M ; x++) {
				if(arr[y][x] == 0) continue;
				
				for(int i = 0 ; i < 4 ; i++) {
					int ty = dy[i] + y;
					int tx = dx[i] + x;
					int w = 0;
					while(0 <= ty && ty < N && 0 <= tx && tx < M) {
						
						if(arr[ty][tx] != 0 && arr[ty][tx] != arr[y][x] ) {
							if(w < 2) break;
							list.add(new Node(arr[y][x],arr[ty][tx],w));
							break;
						}else if(arr[ty][tx] == arr[y][x]) break;
						ty += dy[i];
						tx += dx[i];
						w++;
					}
				}
			}
		}
	}

	public static void unionSet(Node n) {
		int alpha = findSet(n.a);
		int beta = findSet(n.b);
		if(alpha != beta) {
			parent[beta] = alpha;
			answer += n.w;
			bridgeNum--;
		}
	}
	public static int findSet(int idx) {
		if(parent[idx] == idx) return idx;
		return parent[idx] = findSet(parent[idx]);
	}
	private static void makeSet(int cnt) {
		parent = new int[cnt+1];
		for(int i = 1 ; i <= cnt ; i++) {
			parent[i] = i;
		}
	}
	public static int[] dy = {-1,0,1,0};
	public static int[] dx = {0,1,0,-1};
	private static void bfs(Pos pos, int cnt) {
		Queue<Pos> q = new LinkedList<>();
		q.add(pos);
		visited[pos.y][pos.x] = true;
		while(!q.isEmpty()) {
			Pos p = q.poll();
			arr[p.y][p.x] = cnt;
			
			for(int i = 0 ; i < 4 ; i++) {
				int ty = dy[i] + p.y;
				int tx = dx[i] + p.x;
				if(0 <= ty && ty < N && 0 <= tx && tx < M && !visited[ty][tx] && arr[ty][tx] != 0) {
					q.add(new Pos(ty,tx));
					visited[ty][tx] = true;
				}
			}
		}
	}

	private static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		answer = 0 ; bridgeNum = 0;
		list= new ArrayList<>();
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

}
