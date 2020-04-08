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
	
	public static int tc, N, answer;
	public static String[] words;
	public static int[] pick;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		tc = Integer.parseInt(br.readLine());
		for(int i = 1 ; i <= tc ; i++) {
			input();
			logic();
			print(i);
		}
	}

	private static void print(int num) throws IOException {
		bw.append(String.format("#%d %d\n",num,answer));
		bw.flush();
	}

	private static void input() throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		words = new String[N];
		pick = new int[N];
		answer = 0;
		
		for(int i = 0 ; i < N ; i++)
			words[i] = br.readLine();
	}

	private static void logic() {
		for(int i = 1 ; i <= N ; i++) {
			com(0,0,i);
		}
	}

	private static void com(int idx, int deep, int target) {
		if(deep == target) {
			if(inspecAllAlphabet(getAllPickStr(deep))) answer++;
			return;
		}
		
		for(int i = idx ; i < N ; i++) {
			pick[deep] = i;
			com(i+1,deep+1,target);
		}
	}
	public static String getAllPickStr(int deep) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < deep ; i++) {
			sb.append(words[pick[i]]);
		}
		return sb.toString();
	}
	private static boolean inspecAllAlphabet(String pStr) {
		char alphabet = 'a';
		for(int i = 0 ; i <= 'z'-'a' ; i++) {
			if(pStr.indexOf(alphabet+i) < 0) return false;
		}
		return true;
	}

}
