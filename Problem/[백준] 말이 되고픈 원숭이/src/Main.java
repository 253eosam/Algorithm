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
	public static int stoi(String str) { return Integer.parseInt(str); }
	
	public static int K,W,H,answer;
	public static int[][] arr;
	public static boolean[][][] visited;
	
	public static class Pos{
		int y,x,c,k;

		public Pos(int y, int x, int c, int k) {
			super();
			this.y = y;
			this.x = x;
			this.c = c;
			this.k = k;
		}

		@Override
		public String toString() {
			return "Pos [y=" + y + ", x=" + x + ", c=" + c + ", k=" + k + "]";
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

	private static void logic() {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(0,0,0,K));
		visited[0][0][K] = true;
		Pos p = null;
		
		int[][] dy = {{-1,0,1,0},{-1,-2,-2,-1,1,2,2,1}};
		int[][] dx = {{0,1,0,-1},{-2,-1,1,2,2,1,-1,-2}};
		
		while(!q.isEmpty()) {
			p = q.poll();
			
			if(p.y == H-1 && p.x == W-1) {
				answer = p.c;
				break;
			}
			
			for(int i = 0 ; i < dy.length ; i++) {
				if(i == 1 && p.k == 0) break;
				for(int j = 0 ; j < dy[i].length ; j++) {
					int ty = dy[i][j] + p.y;
					int tx = dx[i][j] + p.x;
					if(0 <= ty && ty < H && 0 <= tx && tx < W && arr[ty][tx] == 0 && !visited[ty][tx][p.k-i]) {
						q.add(new Pos(ty,tx,p.c+1,p.k-i));
						visited[ty][tx][p.k-i] = true;
					}
				}
			}
			
		}// while q not empty
	}

	private static void input() throws IOException {
		K = stoi(br.readLine());
		st= new StringTokenizer(br.readLine());
		W = stoi(st.nextToken());
		H = stoi(st.nextToken());
		
		arr = new int[H][W];
		visited = new boolean[H][W][K+1];
		answer = -1;
		
		for(int i = 0 ; i < H ; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j = 0 ; j < W ; j++) {
				arr[i][j] = stoi(st.nextToken());
			}
		}
	}

}
