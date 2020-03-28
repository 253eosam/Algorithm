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
	
	public static int N,answer1,answer2;
	public static boolean[][] visited;
	public static char[][] arr;
	
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
		bw.append(answer1 + " " + answer2);
		bw.flush();
	}

	private static void logic() {
		// 1. 모든 배열을 돌면서 BFS 실행
		// 2. 모든 배열을 돌면서 바로 현재 칸이 입력받은 칸이랑 다를때 확장하지 않음
		for(int y = 0 ; y < N ; y++) {
			for(int x = 0 ; x < N ; x++) {
				if(!visited[y][x]) BFS(new Pos(y,x),true);
			}
		}
		
		visited = new boolean[N][N];

		for(int y = 0 ; y < N ; y++) {
			for(int x = 0 ; x < N ; x++) {
				if(!visited[y][x]) BFS(new Pos(y,x),false);
			}
		}
	}
	public static int[] dy = {-1,0,1,0};
	public static int[] dx = {0,1,0,-1};
	public static void BFS(Pos pPos , boolean simpleBFS) {
		if(simpleBFS) answer1++;
		else answer2++;
		visited[pPos.y][pPos.x] = true;
		Queue<Pos> q = new LinkedList<>();
		q.add(pPos);
		char mainVal = arr[pPos.y][pPos.x];
		while(!q.isEmpty()) {
			Pos p = q.poll();
			
			for(int i = 0 ; i < 4 ; i++) {
				int ty = dy[i] + p.y;
				int tx = dx[i] + p.x;
				if(0 <= ty && ty < N && 0 <= tx && tx < N && !visited[ty][tx]) {
					if(simpleBFS && arr[ty][tx] == mainVal) {
						visited[ty][tx] = true;
						q.add(new Pos(ty,tx));
					}else if(!simpleBFS && 
							(mainVal == 'R' && arr[ty][tx] == 'G' || 
							mainVal == 'G' && arr[ty][tx] == 'R' ||
							mainVal == arr[ty][tx])) {
						visited[ty][tx] = true;
						q.add(new Pos(ty,tx));
					}
				}
			}
		}
	}

	private static void input() throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N][N];
		arr = new char[N][N];
		answer1 = answer2 = 0;
		
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < N ; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
	}

}
