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
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			// p,q,r,s,w
			int pivot = w - r;
			if(pivot < 0 )
				pivot = 0;
			int solv = 0;
			solv = p * w < q + s * pivot ? p * w : q + s * pivot;
			bw.write("#"+tNum+" "+solv+"\n");
		}//for tNum
		bw.flush();
		bw.close();
	}//main
}
