import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static Scanner sc = new Scanner(System.in);
	public static int N;
	public static int[] arr,dp;
	public static int solv;
	public static Data[] data;
	public static class Data
	{
		int idx, val;
		Data(int idx, int val)
		{
			this.idx=idx;
			this.val=val;
		}
		@Override
		public String toString() {
			return "Data [idx=" + idx + ", val=" + val + "]";
		}
	}
	public static void main(String[] args) 
	{
		init();
		LIS();
		print();
	}
	private static void print() {
		System.out.println(solv);
	}
	private static void LIS() {
		int idx = 0;
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
				
				data[i] = new Data(bsIdx,arr[i]);
			}
		}
		
		solv = idx + 1;
	}
	private static int bs(int right, int n) {
		int left = 0 ;
		
		while(left < right)
		{
			int mid = (left + right) /2;
			if(dp[mid] >= n)
			{
				right = mid;
			}
			else
			{
				left = mid + 1;
			}
		}
		
		return right;
	}
	private static void init() {
		N = sc.nextInt();
		arr = new int[N]; dp = new int[N];
		for(int i = 0 ; i < N ; i++)
			arr[i] = sc.nextInt();
		data=new Data[N];
	}
	
}
