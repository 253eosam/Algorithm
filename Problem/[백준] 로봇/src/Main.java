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
	public static int[][] arr;
	public static boolean[][][] visited;
	public static int N,M,answer;
	public static int[] dy = {0,0,1,-1};
	public static int[] dx = {1,-1,0,0};
	public static int sy,sx,sd,ey,ex,ed;
	public static class Pos{
		int y,x,c,d;
		public Pos(int y, int x, int c, int d) {
			super();
			this.y = y;
			this.x = x;
			this.c = c;
			this.d = d;
		}
		@Override
		public String toString() {
			return "Pos [y=" + y + ", x=" + x + ", c=" + c + ", d=" + d + "]";
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
		q.add(new Pos(sy,sx,0,sd));
		visited[sy][sx][sd] = true;
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			if(p.y == ey && p.x == ex && p.d == ed) {
				answer = p.c;
				break;
			}
			
			// Go
			int ty = 0, tx = 0;
			for(int i = 1 ; i <= 3 ; i++) {
				if(p.d < 2) {	// 가로
					ty = p.y;
					tx = p.x + ((p.d%2==0)? i : -i);
				}else {
					ty = p.y + ((p.d%2==0)? i : -i);
					tx = p.x;
				}
				if(0 <= ty && ty < N && 0 <= tx && tx < M 
						&& !visited[ty][tx][p.d]) {
					if(arr[ty][tx] == 1)break;
					visited[ty][tx][p.d] = true;
					q.add(new Pos(ty,tx,p.c+1,p.d));
				}
			}
			
			// Turn
			int turn = p.d;
			if(turn % 2 == 0) {
				turn = (turn + 2) % 4;
			}else {
				turn = (turn + 1) % 4;
			}
			for(int i = 0 ; i < 2 ; i++) {
				if(!visited[p.y][p.x][turn+i]) {
					visited[p.y][p.x][turn+i] = true;
					q.add(new Pos(p.y,p.x,p.c+1,turn+i));
				}
			}
			
		}// while : q is not empty
	}
	private static void input() throws IOException {
		st=new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		answer = 0;
		arr = new int[N][M];
		visited = new boolean[N][M][5];
		for(int i = 0 ; i < N ; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				arr[i][j] = stoi(st.nextToken());
			}
		}
		
		st=new StringTokenizer(br.readLine());
		sy = stoi(st.nextToken())-1;
		sx = stoi(st.nextToken())-1;
		sd = stoi(st.nextToken())-1;
		
		st=new StringTokenizer(br.readLine());
		ey = stoi(st.nextToken())-1;
		ex = stoi(st.nextToken())-1;
		ed = stoi(st.nextToken())-1;
	}

}
