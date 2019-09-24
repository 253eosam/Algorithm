
public class Main {
	public static final int MAX_SIZE = 1_000_000;
	public static long[] dp = new long[MAX_SIZE];
	public static long fibo(int x)
	{
		if(x == 1 || x == 2) return 1;
		if(dp[x] > 0 ) return dp[x];
		return dp[x] = fibo(x-1) + fibo(x-2);
	}
	public static void main(String[] args) {

		System.out.println(fibo(40));
	}

}
