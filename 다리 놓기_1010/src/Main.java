import java.util.Scanner;

public class Main {
	public static int n,m;
	public static int[][] com = new int[n][m];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tNum = 1 ; tNum <= T ; tNum++)
		{
			n = sc.nextInt();
			m = sc.nextInt();
			System.out.println(combination(n, m));
		}
	}
	public static int combination(int n, int m)
	{
		if(n == m || m == 0) return 1;
		if(com[n][m] > 0 ) return com[n][m];
		return com[n][m] = com[n][n-m] = combination(n-1,m) + combination(n-1,m-1);
	}

}
