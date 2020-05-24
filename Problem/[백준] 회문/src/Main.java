import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int tc = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < tc ; i++) {
			answer = 2;
			String str = br.readLine();
			inspecPalindrome(str,0,str.length()-1,0);
			bw.append(String.format("%d\n", answer));
		}
		bw.close();
	}
	public static void inspecPalindrome(String str, int left, int right, int removeCnt) {
		if(left > right) {
			answer = Math.min(answer, removeCnt);
			return;
		}
		if(removeCnt >= 2) {
			answer = Math.min(answer, removeCnt);
			return;
		}
		if(str.charAt(left) == str.charAt(right)) inspecPalindrome(str, left+1, right-1,removeCnt);
		else {
			if(str.charAt(left+1) == str.charAt(right)) {
				inspecPalindrome(str, left+2, right-1,removeCnt+1);
			}
			if(str.charAt(left) == str.charAt(right-1)) {
				inspecPalindrome(str, left+1, right-2,removeCnt+1);
			}
			return;
		}
	}
}
