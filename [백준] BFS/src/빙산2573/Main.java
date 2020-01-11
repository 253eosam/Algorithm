package 빙산2573;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;

	public static int stoi(String str) {
		return Integer.parseInt(str);
	}

	public static int N, M, answer;
	public static int[][] arr, brr;
	public static boolean[][] visited;
	public static Queue<Pos> q;
	
	public static int[] dy = { -1, 0, 1, 0 };
	public static int[] dx = { 0, 1, 0, -1 };
	
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
		bw.append(String.valueOf(answer));
		bw.flush();
	}

	public static void melt() {
		// given
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				int loc = arr[y][x];
				if (loc > 0) {
					for (int dir = 0; dir < 4; dir++) {
						int ty = dy[dir] + y;
						int tx = dx[dir] + x;
						if (0 <= ty && ty < N && 0 <= tx && tx < M && arr[ty][tx] == 0) {
							brr[y][x]++;
						}
					} // for dir
				} // value of location is not empty
			}
		}
		
		//then
		for(int y = 0 ; y < N ; y++) {
			for(int x = 0 ; x < M ; x++) {
				if(arr[y][x] > 0) {
					arr[y][x] -= brr[y][x];
					if(arr[y][x] < 0) arr[y][x] = 0;
				}
			}
		}
	}
	
	public static void bfs(int y, int x) {
		visited[y][x] = true;
		q.add(new Pos(y,x));
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			
			for(int i = 0 ; i < 4 ; i++) {
				int ty = dy[i] + p.y;
				int tx = dx[i] + p.x;
				if(0 <= ty && ty < N && 0 <= tx && tx < M && !visited[ty][tx] && arr[ty][tx] > 0) {
					q.add(new Pos(ty,tx));
					visited[ty][tx] = true;
				}
			}
		}//while : q not empty
	}
	private static void logic() {
		int level = 0;
		while (true) {
			level++;
			q = new LinkedList<>();
			visited = new boolean[N][M];
			brr = new int[N][M];
			int island = 0;
			
			melt();
			
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < M ; j++) {
					int loc = arr[i][j];
					if(loc > 0 && !visited[i][j]) {
						bfs(i,j);
						island++;
					}
				}
			}
			
			if(island >= 2) {
				answer = level;
				break;
			}
			else if(island == 0) {
				answer = 0;
				break;
			}
		}// while : not loc >= 2 
	}// logic

	private static void input() throws IOException {
		answer = 0;
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());

		arr = new int[N][M];
		brr = new int[N][M];
		visited = new boolean[N][M];
		q = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int in = stoi(st.nextToken());
				arr[i][j] = in;
			}
		}
	}

}
