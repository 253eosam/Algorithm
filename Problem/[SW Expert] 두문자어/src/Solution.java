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
	public static void main(String[] args) throws NumberFormatException, IOException {

		int tc = Integer.parseInt(br.readLine());
		
		for(int num = 1 ; num <= tc ; num++) {
			StringBuilder sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			
			while(st.hasMoreTokens()) {
				 sb.append(st.nextToken().toUpperCase().charAt(0));
			}
			
			bw.append(String.format("#%d %s\n",num,sb.toString()));
		}
		bw.close();
	}

}
