import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	
	public static int N,answer;
	public static int[][] arr;
	public static boolean[][][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		logic();
		print();
	}

	private static void print() throws IOException {
		bw.append(String.valueOf(answer));
		bw.flush();
	}

	private static void logic() {
		dfs(1,0,0,1);
	}

	private static void dfs(int bitmask, int idx, int cost, int num) {
		if(visited[bitmask][idx][cost]) return;
		visited[bitmask][idx][cost] = true;
		if(answer < num) answer = num;
		for(int i = 0 ; i < N ; i++) {
			if(arr[idx][i] >= cost && (bitmask & (1 << i)) == 0) {
				dfs(1 << i | bitmask ,i,arr[idx][i],num+1);
			}
		}
	}

	private static void input() throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited=new boolean[1 << 15][16][10];
		answer = 0;
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < N ; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
	}

}
