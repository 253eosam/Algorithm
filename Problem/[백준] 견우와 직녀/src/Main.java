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
	public static int stoi(String str ) {return Integer.parseInt(str);}
	public static int status(boolean s) {return s ? 1 : 0;}
	public static int N,M,answer;
	public static int[][] arr;
	public static boolean[][][]	visited;
	public static boolean[][] noCome;
	public static class Pos{
		int y,x,c;
		boolean s;
		public Pos(int y, int x, int c, boolean s) {
			super();
			this.y = y;
			this.x = x;
			this.c = c;
			this.s = s;
		}
		@Override
		public String toString() {
			return "Pos [y=" + y + ", x=" + x + ", c=" + c + ", s=" + s + "]";
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
		brute();
		BFS();
	}
	private static void brute() {
		int[][] dy = {{-1,0},{0,1},{1,0},{0,-1}};
		int[][] dx = {{0,1},{1,0},{0,-1},{-1,0}};
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				int tmp = arr[i][j];
				if(tmp != 0) continue;
				outer:for(int a = 0 ; a < dy.length ; a++) {
					tmp = 0;
					for(int b = 0 ; b < dy[a].length ; b++) {
						int ty = i + dy[a][b];
						int tx = j + dx[a][b];
						if(!(0 <= ty && ty < N && 0 <= tx && tx < N)) continue outer;
						tmp += arr[ty][tx];
					}
					if(tmp == 0) {
						noCome[i][j] = true;
						break;
					}
				}// for : a
			}
		}
	}
	private static void BFS() {
		int[] dy = {0,-1,0,1,0};
		int[] dx = {0,0,1,0,-1};
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(0,0,0,false));
		visited[0][0][0] = true;
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
//			System.out.println(p);
			
			if(p.c == 105) break;
			if(p.y == N-1 && p.x == N-1) {
				answer = p.c;
				break;
			}
			
			for(int i = 0 ; i < dy.length ; i++) {
				int ty = dy[i] + p.y;
				int tx = dx[i] + p.x;
				if(0 <= ty && ty < N && 0 <= tx && tx < N) {
					if((arr[p.y][p.x] == 0 || arr[p.y][p.x] > 1) && (arr[ty][tx] == 0 || arr[ty][tx] > 1)) continue;
					if(noCome[ty][tx]) continue;
					if(arr[ty][tx] == 0 && !p.s && (p.c+1) % M == 0 && !visited[ty][tx][status(p.s)]) {
						q.add(new Pos(ty,tx,p.c+1,true));
						visited[ty][tx][1] = true;
					}// 0일때 오작교 만들기
					else if(arr[ty][tx] > 1 && (p.c+1) % arr[ty][tx] == 0 && !visited[ty][tx][status(p.s)]) {
						q.add(new Pos(ty,tx,p.c+1,p.s));
						visited[ty][tx][status(p.s)] = true;
					}// 기존 오작교
					else if(arr[ty][tx] == 1 && !visited[ty][tx][status(p.s)]) {
						q.add(new Pos(ty,tx,p.c+1,p.s));
						visited[ty][tx][status(p.s)] = true;
					}// 그냥 길
					else if(p.y == ty && p.x == tx) {
						q.add(new Pos(ty,tx,p.c+1,p.s));
					}// 머무르기
				}
			}
		}// while : q is not empty
	}
	private static void input() throws IOException {
		st=new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		answer = 0;
		arr = new int[N][N];
		visited = new boolean[N][N][2];
		noCome = new boolean[N][N];
		for(int i = 0 ; i < N ; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				arr[i][j] = stoi(st.nextToken());
			}
		}
	}

}
