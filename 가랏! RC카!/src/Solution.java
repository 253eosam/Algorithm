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
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int tNum = 1 ; tNum <= T ; tNum++)
		{
			int speed = 0;
			int distance = 0;
			
			int N = Integer.parseInt(br.readLine());
			for(int i = 0 ; i < N ; i++)
			{
				st = new StringTokenizer(br.readLine());
				int moving = Integer.parseInt(st.nextToken());
				if(st.hasMoreTokens())
				{
					int tmp = Integer.parseInt(st.nextToken());
					speed += moving == 1 ? tmp : -tmp;
					if(speed < 0)
						speed = 0;
				}
				distance += speed;
			}
			bw.write("#"+tNum+" "+distance+"\n");
		}//for tNum
		bw.flush();
		bw.close();
		
	}//main
	
}
