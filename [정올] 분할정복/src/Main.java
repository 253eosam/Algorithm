import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/* 
 * Á¤¿Ã : Á¦°ö±Ù(1240)
 */

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static long stoi(String str) { return Long.parseLong(str); }
	
	public static long N;
	public static long value;
	public static void main(String[] args) throws IOException {
		
		input();
		logic();
		print();
	}
	private static void print() throws IOException {
		bw.append(String.valueOf(value));
		bw.flush();
		System.out.println();
		System.out.println();
	}
	private static void logic() {
		long left = 0, right = (long)(Math.pow(2, 31)*1.4142135623), mid=0;
		while(left <= right) {
			mid = (long) ((left+right)/2);
			if(N < mid*mid) right = mid-1;
			else if(N > mid*mid) left = mid+1;
			else {
				right = mid;
				break;
			}
		}
		value = (long) right;
	}
	private static void input() throws IOException {
		N = stoi(br.readLine());
	}
}
