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
	public static int stoi(String str) { return Integer.parseInt(str); }
	
	public static int n,k,s;
	public static boolean[][] arr;
	
	public static void main(String[] args) throws IOException {
		init();
		logic();
		bw.flush();
	}

	private static void logic() throws IOException {
		s = stoi(br.readLine());
		for(int i = 0 ; i < s ; i++) {
			st=new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken());
			int b = stoi(st.nextToken());
			if(arr[a][b]) bw.append("-1");
			else if(arr[b][a]) bw.append("1");
			else bw.append("0");
			bw.append("\n");
		}
	}

	private static void init() throws IOException {
		st=new StringTokenizer(br.readLine());
		n = stoi(st.nextToken());
		k = stoi(st.nextToken());
		arr=new boolean[n+1][n+1];
		for(int i = 0 ; i < k ; i++) {
			st=new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken());
			int b = stoi(st.nextToken());
			arr[a][b] = true;
		}
		
		floyd();
	}

	private static void floyd() {
		for(int c = 1 ; c <= n ; c++) {
			for(int a = 1 ; a <= n ; a++) {
				for(int b = 1 ; b <= n ; b++) {
					if(arr[a][c] && arr[c][b])
						arr[a][b] = true;
				}
			}
		}
	}

}
