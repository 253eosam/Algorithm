import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	
	public static int  N,M;
	public static long answer;
	public static long [][] arr, dp;
	
	public static void main(String[] args) throws IOException {
		input();
		logic();
		print();
	}

	private static void print() throws IOException {
		answer = dp[0][0];
		bw.append(String.valueOf(answer));
		bw.flush();
	}

	private static void logic() {
		dp[0][0] = dfs(0,0);
	}

	private static void testprint() {
		for(int i = 0 ; i < N ; i++) {
			System.out.println();
			for(int j = 0 ; j < M ; j++) {
				System.out.print(dp[i][j] + " ");
			}
		}
		System.out.println();
	}

	public static int[] dy = {-1,0,1,0};
	public static int[] dx = {0,1,0,-1};
	private static long dfs(int y, int x) {
		if(y == N-1 && x == M-1) return 1;
		if(dp[y][x] != 0) return dp[y][x];
		dp[y][x] = 0;
		int targetCase = 0;
		for(int i = 0 ; i < 4 ; i++) {
			int ty = dy[i] + y;
			int tx = dx[i] + x;
			if(0 <= ty && ty < N && 0 <= tx && tx < M &&
					arr[y][x] > arr[ty][tx]) {
				targetCase += dfs(ty,tx);
			}
		}
		
		return dp[y][x] += targetCase;
	}

	private static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = 0;
		
		arr = new long[N][M]; 
		dp = new long[N][M];
		
		 for(int i = 0 ; i < N ; i++)
         	Arrays.fill(dp[i], -1);
		 
		for(int i = 0 ; i < N ; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
	}

	
}
