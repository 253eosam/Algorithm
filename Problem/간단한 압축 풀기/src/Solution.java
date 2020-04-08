import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int tNum = 1 ; tNum <= T ; tNum++)
		{
			int N = Integer.parseInt(br.readLine());
			String output = "";
			String alpa = "";
			int num = 0;
			bw.write("#"+tNum+"\n");
			for(int i = 0 ; i < N ;i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				alpa = st.nextToken();
				num = Integer.parseInt(st.nextToken());
				
				for(int j = 0; j < num ; j++)
				{
					output += alpa;
					bw.write(alpa);
					if(output.length() == 10)
					{
						bw.write("\n");
						output="";
					}
				}
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}
