import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int N,K;
	public static int[][] arr;
	public static long[][] dp;
	public static long solv = Integer.MIN_VALUE;
	public static boolean DEBUG = false;
	public static void main(String[] args) throws Exception{
		
		int T = Integer.parseInt(br.readLine());
		for(int tNum = 1; tNum <= T ; tNum++)
		{
			//init
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N+1][2];
			for(int i = 1 ; i <= N ; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < 2 ; j++)
				{
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dp = new long[N+1][K+1];
			// i : 갯수(아이템의 index) , j = 무게 
			// arr : 부피, 가치
			for(int i = 1 ; i <= N ; i ++)
			{
				for(int j = 1 ;  j <= K ; j++)
				{
					if(arr[i][0] > j)
					{
						dp[i][j] = dp[i-1][j];
					}
					else
					{
						dp[i][j] = Math.max(dp[i-1][j] , dp[i-1][j - arr[i][0]] + arr[i][1]);
						solv = Math.max(solv, dp[i][j]);
					}
				}
			}
				
			if(DEBUG)
			{
				for(long [] m : dp)
				{
					System.out.println(Arrays.toString(m));
				}
				
			}
			
			bw.write("#"+tNum+" "+dp[N][K]+"\n"); 
		}
		bw.flush();
		bw.close();
		
	}

}
