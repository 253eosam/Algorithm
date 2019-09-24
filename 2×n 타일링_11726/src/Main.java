import java.util.Scanner;

public class Main 
{
	public static final int MOD = 10_007;
	public static long[] p;
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		p = new long[1001];
		System.out.println(useFor(n));
	}
	public static long recursion(int x)
	{
		if(x == 1 || x == 2) return x;
		if(p[x] > 0) return p[x];
		return p[x] = (recursion(x-1) + recursion(x-2)) % MOD;
	}
	public static long useFor(int x)
	{
		p[1] = 1; p[2] = 2;
		for(int i = 3 ; i <= x ; i++)
		{
			p[i] = (p[i-1] + p[i-2]) % MOD;
		}
		return p[x];
	}
}
