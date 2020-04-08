import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tNum = 1; tNum <= T; tNum++)
		{
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			int cnt = 0;
			for(int i = 0 ; i < N ; i++)
			{
				arr[i] = Integer.parseInt(st.nextToken());
				if((i == 0 && arr[i] == 0) || (i == N-1 && arr[i] == 0))
				{	arr[i] =1; cnt++; } 
				
			}
			
			for(int i = 0 ; i < N-D ;)
			{
				for(int j = 1 ; j <= D; j++)
				{
					if(arr[i+j] == 1)
					{
						i += j;
						break;
					}
					else if(j == D)
					{
						cnt++;
						arr[i+j] = 1;
						i += j;
					}
				}
			}
//			System.out.println(Arrays.toString(arr));
			bw.write("#"+tNum+" "+cnt+"\n");

		
		}//for tNum
	bw.flush();
	bw.close();
	
	}

}
