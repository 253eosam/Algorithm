import java.util.Scanner;

public class Main {
	public static int[] dp , arr;
	public static int N, solv;
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		init();
		LIS();
		print();
	}
	
	private static void print() {
		System.out.println(solv);
	}

	private static void init() {
		N = sc.nextInt();
		dp = new int[N];
		arr = new int[N];
		for(int i = 0 ; i < N ; i++)
			arr[i] = sc.nextInt();
	}

	private static void LIS() {
		int idx = 0 ;
		dp[0] = arr[0];
		
		for(int i = 1 ; i < N ; i++)
		{
			if(dp[idx] < arr[i])
			{
				dp[++idx] = arr[i];
			}
			else
			{
				int bsIdx = bs(idx,arr[i]);
				dp[bsIdx] = arr[i];
			}
		}
//		for(int i = 0 ;  i <= idx ; i++)
//			System.out.print(dp[i] + " ");
//		System.out.println();
		solv = idx + 1;
	}

	private static int bs(int right, int n) {
		int left = 0;
		
		while(left < right)
		{
			int mid = (left + right) / 2;
			if(dp[mid] >= n)
			{
				right = mid;
			}
			else
				left = mid +1;
		}
		
		return right;
	}

}
