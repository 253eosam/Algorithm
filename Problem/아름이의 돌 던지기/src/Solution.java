import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tNum = 1 ; tNum <= T ; tNum++)
		{
			int N = Integer.parseInt(br.readLine());
			int disNum = 0;
			int dis = 100000;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens())
			{
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp < 0)
					tmp *= -1;
				if(dis > tmp)
				{
					dis = tmp;
					disNum = 1;
				}
				else if(dis == tmp)
					disNum++;
			}
			bw.write("#"+tNum+" "+dis+" "+disNum+"\n");
		}
		bw.flush();
		bw.close();
	}//main
}
