import java.util.Scanner;

public class Main 
{
	public static long[] dp = new long[101];
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		dp[1] = dp[2] = dp[3] = 1;
		for(int tNum = 1 ; tNum <= T ; tNum++)
		{
			int n = sc.nextInt();
			
			for(int i = 4 ; i <= n ; i++)
			{
				dp[i] = dp[i-2] + dp[i-3];
			}
			System.out.println(dp[n]);
		}//for tNum
	}
}
