import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	
	public static int N,M,O,V;
	public static char[][] arr;
	public static boolean[][] visited;
	public static ArrayList<Pos> list;
	public static class Pos{
		int y,x;

		public Pos(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	public static void main(String[] args) throws IOException {
		input();
		logic();
		print();
	}

	private static void print() throws IOException {
		bw.append(String.valueOf(O + " " + V));
		bw.flush();
	}

	private static void logic() {
		for(Pos p : list) {
			if(visited[p.y][p.x]) continue; 
			bfs(p.y,p.x);
		}
	}
	public static int[] dy = {-1,0,1,0};
	public static int[] dx = {0,1,0,-1};
	private static void bfs(int y, int x) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(y,x));
		visited[y][x] = true;
		int o = 0 , v = 0;
		while(!q.isEmpty()) {
			Pos p = q.poll();
			
			if(arr[p.y][p.x] == 'o') o++;
			else if(arr[p.y][p.x] == 'v') v++;
			
			for(int i = 0 ; i < 4 ; i++) {
				int ty = dy[i] + p.y;
				int tx = dx[i] + p.x;
				if(0 <= ty && ty < N && 0 <= tx && tx < M && !visited[ty][tx]) {
					q.add(new Pos(ty,tx));
					visited[ty][tx] = true;
				}
			}
		}
		if(o <= v) V += v;
		else O += o;
	}

	private static void input() throws IOException {
		st=new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		visited = new boolean[N][M];
		list = new ArrayList<>();
		O = V = 0;
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				char c = str.charAt(j);
				arr[i][j] = c;
				if(c == '#') visited[i][j] = true;
				else list.add(new Pos(i,j));
			}
		}
	}

}
