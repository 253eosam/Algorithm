import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tNum = 1 ; tNum <= T ; tNum++)
		{
			int N = Integer.parseInt(br.readLine());
			int arr[][] = new int[N][N];
			int n = N;
			int sw = 1;
			int y = 0;
			int x = -1 ;
			int val = 1;
			while(true)
			{
				for(int p = 0 ; p < N ; p++)
				{
					x += sw;
					arr[y][x] = val++;
				}
				N--;
				if(N == 0)
					break;
				
				for(int p = 0 ; p < N ; p++)
				{
					y += sw;
					arr[y][x] = val++;
				}
				sw *= -1;
			}
			
			
			bw.write("#" + tNum + "\n");
			for(int i = 0 ; i < n ; i++)
			{
				for(int j = 0 ; j < n ; j++)
					bw.write(arr[i][j] + " ");
				bw.write("\n");
			}
		}
		bw.flush();
		bw.close();
		
	}//main
}
