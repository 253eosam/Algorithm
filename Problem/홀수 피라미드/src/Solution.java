import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tNum = 1 ; tNum <= T ; tNum++)
		{
			bw.write("#"+tNum+" ");
			long N = Integer.parseInt(br.readLine());
			long mid = 2*N*(N-1)+1;
			long first = mid - ((N-1)*2);
			long last = mid + ((N-1)*2);
			bw.write(first+ " " + last + "\n");
		}
		bw.flush();
		bw.close();
		
	}

}
