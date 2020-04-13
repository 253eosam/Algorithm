import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws NumberFormatException, IOException {
		int tc = Integer.parseInt(br.readLine());
		for(int num = 1 ; num <= tc ; num++) {
			int L = Integer.parseInt(br.readLine());
			int answer = calCirSentenceNumber(L);
			bw.append(String.format("#%d %d\n", num,answer));
		}
		bw.close();
	}
	private static int calCirSentenceNumber(int L) {
		return (int)Math.pow(L/2,2);
	}
	// L=3, aba  	: aba
	// L=5, ababa	: aba ababa bab aba
	// L=7, abababa	: aba ababa abababa bab babab aba ababa bab aba
}
