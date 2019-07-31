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
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tNum = 1 ; tNum <= T ; tNum++)
		{
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			for(int i = 0 ; i < N ; i++)
			{
				arr[i] = Integer.parseInt(br.readLine())-1;
			}
			int cnt=0;
			for(int i = 1 ; i < N ; i++)
			{
				if(arr[i]==0)
					continue;
				for(int j = i+1 ; j < N ; j++)
				{
					if(arr[j] != 0 && arr[j] % arr[i] == 0)
					{
						arr[j] = 0;
						cnt++;
					}
				}
			}
			
			bw.write("#"+tNum+" "+(N-cnt-1)+"\n");
			
		}//for tNum
		bw.flush();
	}//main

}
