import java.util.Scanner;

public class Main {
	public static int[][] dp = new int[1001][3];
	public static int h;
	public static Scanner sc = new Scanner(System.in);
	public static int min(int a, int b) { return Math.min(a, b); }
	public static void main(String[] args) {
		h = sc.nextInt();
		for(int i = 0 ; i < h ; i++)
		{
			for(int j = 0 ; j < 3 ; j++)
			{
				dp[i][j] = sc.nextInt();
				if(i >= 1)
				{
					int a = 0 ; int b = 0;
					if(j == 0)
					{
						a = dp[i-1][1] + dp[i][j];
						b = dp[i-1][2] + dp[i][j];
						dp[i][j] = min(a,b);
					}
					else if(j==1)
					{
						a = dp[i-1][0] + dp[i][j];
						b = dp[i-1][2] + dp[i][j];
						dp[i][j] = min(a,b);
					}
					else if(j==2)
					{
						a = dp[i-1][0] + dp[i][j];
						b = dp[i-1][1] + dp[i][j];
						dp[i][j] = min(a,b);
					}
				}
			}
		}
		
		int val = dp[h-1][0];
		for(int i = 1 ; i < 3; i++)
			val = min(val,dp[h-1][i]);
		System.out.println(val);
		
	}

}
