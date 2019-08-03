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
		
		int[] lastDay = { 31,28 ,31,30,31,30,31,31,30,31,30,31};
		
		int T = Integer.parseInt(br.readLine());
		
		int[] month = new int[2];
		int[] day = new int[2];
		
		for(int tNum = 1 ; tNum <= T ; tNum++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 0 ; i < 2 ; i++)
			{
				month[i] = Integer.parseInt(st.nextToken());
				day[i] = Integer.parseInt(st.nextToken());
			}
			
			int sumDay = 0;
			for(int i = 1 ; i <= month[1]; i++)
			{
				sumDay += lastDay[i-1];
				if(month[0] == i+1)
					day[0] += sumDay;
				if(month[1] == i+1)
					day[1] += sumDay;
			}
			
			int solv = day[1] - day[0] +1;
			
			bw.write("#"+tNum+" "+solv+"\n");
		}
		bw.flush();
		bw.close();
		
	}//main

}
