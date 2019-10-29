import java.util.Scanner;

public class Main {
	public static void main(String[] args)throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		for(int i = 1 ; i <= N ; i++)
			arr[i] = sc.nextInt();
		
		int[][] dp = new int[N+1][3];
		for(int i = 1 ; i <= N ; i++)
		{
			dp[i][0] = dp[i-1][2] + arr[i];
			dp[i][1] = dp[i-1][0] + arr[i];
			dp[i][2] = Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][2]);
		}
		
		if(true)
		{
			for(int i = 0 ; i < 3 ; i++)
			{
				for(int j = 0 ; j <= N ; j++)
				{
					System.out.print(dp[j][i]+ "\t");
				}
				System.out.println();
			}
		}
		
		int max = 0;
		for(int i = 0 ; i < 3 ; i++)
		{
			max = Math.max(max, dp[N][i]);
		}
		System.out.println(max);
	}
}
