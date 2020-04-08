import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int prime[] = { 2,3,5,7,11 };
		int T = Integer.parseInt(br.readLine());
		for(int tNum = 1; tNum <= T ; tNum++)
		{
			int num = Integer.parseInt(br.readLine());
			bw.write("#"+tNum + " ");
			for(int i = 0 ; i < prime.length ; i++)
			{
				int cnt = 0;
				while(num%prime[i] == 0)
				{
					num/=prime[i];
					cnt++;
				}
				bw.write(cnt + " ");

			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();

	}

}
