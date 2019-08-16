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
			int N = Integer.parseInt(br.readLine());
			int cnt = 0;
			for(int i = 1 ; i <= N/2 ; i++)
			{
				int sum = 0;
				for(int j = i ; j <= N ; j++)
				{
					sum += j;
					if(sum == N)
						cnt++;
					else if(sum > N)
						break;
				}
			}
			cnt++; // 본인 포함
			bw.write("#"+tNum+" "+cnt+"\n");
		}//for tNum
		bw.flush();
		bw.close();
	}

}
