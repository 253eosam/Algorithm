import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for(int tNum = 1 ; tNum <= T ; tNum++)
		{
			bw.write("#"+tNum+" ");
			String tmp = st.nextToken();
			int[] arr = new int[tmp.length()];
			for(int i = 0 ; i < tmp.length() ; i++)
				arr[i] = tmp.charAt(i)-'0';
			int swap = Integer.parseInt(st.nextToken());
			
			
			
		}//for tNum
		bw.flush();
		bw.close();
		
	}

}
