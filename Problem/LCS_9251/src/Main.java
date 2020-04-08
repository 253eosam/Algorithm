import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int[][] dp;
	public static String str,in;
	public static void main(String[] args) throws Exception
	{
		str = br.readLine();
		in = br.readLine();
		
		int N = in.length();
		int M = str.length();
		dp = new int[N+1][M+1];
		for(int i = 1 ; i <= in.length() ; i++)
		{
			for(int j = 1 ; j <= str.length() ; j++)
			{
				if(in.charAt(i-1) == str.charAt(j-1))
				{
					int max = Math.max(dp[i-1][j-1], dp[i][j-1]);
					dp[i][j] = max+1;
				}
				else
				{
					int max = Math.max(dp[i-1][j], dp[i][j-1]);
					dp[i][j] = max;
				}
			}
		}
//		for(int i = 0 ; i <= N ; i++)
//		{
//			for(int j = 0 ; j <= M ; j++)
//			{
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		System.out.println(dp[N][M]);
	}

}
