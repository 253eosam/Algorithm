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
	
	public static int N;
	public static String answer;
	public static int[] arr;
	public static boolean finish;
	public static int[] p = { 1,2,3 };
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		logic();
	}


	private static void print() throws IOException {
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < N ; i++) sb.append(arr[i]);
		bw.append(sb.toString());
		bw.flush();
	}

	private static void logic() throws IOException {
		arr[0] = 1;
		dfs(1);
	}
	
	public static void dfs(int idx) throws IOException {
		if(finish)return;
		if(idx == N ) {
			finish = true;
			print();
			return;
		}
		
		for(int i = 0 ; i < p.length ; i++) {
			arr[idx] = p[i];
			if(inspectSequnce(idx+1)) dfs(idx+1); 
		}
	}
	
	public static boolean inspectSequnce(int n) {
//System.out.println(Arrays.toString(arr));
		for(int k = 1 ; k <= n / 2 ; k++) {
			StringBuilder sb = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
			for(int i = 0 ; i < k ; i++) {
				sb.append(arr[n-i-1]);
				sb2.append(arr[n-i-k-1]);
			}
//			System.out.println("sb : " + sb.toString());
//			System.out.println("sb2 : " + sb2.toString());
			if(sb.toString().equals(sb2.toString())) return false;
		}
		return true;
	}

	private static void input() throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N]; answer = ""; finish = false;
	}

}
