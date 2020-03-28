import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int N;
	public static String alpha,beta;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int tc = Integer.parseInt(br.readLine());
		for(int i = 1 ; i <= tc ; i++) {
			input();
			int answer = logic();
			print(i,answer);
		}
	}

	private static void print(int i, int answer) throws IOException {
		bw.append(String.format("#%d %d\n", i,answer));
		bw.flush();
	}

	private static int logic() {
		int correct = 0;
		for(int i = 0 ; i < N ; i++) {
			if(alpha.charAt(i) - beta.charAt(i) == 0) correct++;
		}
		return correct;
	}

	private static void input() throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		alpha = br.readLine();
		beta = br.readLine();
	}
}
