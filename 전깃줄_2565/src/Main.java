import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int N;
	public static int[] arr;
	public static int[] dp;
	public static boolean[] isCut;
	public static final int MAX_SIZE = 101;
	public static void main(String[] args) throws Exception
	{
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[MAX_SIZE];
		dp = new int[MAX_SIZE];
		isCut = new boolean[MAX_SIZE];
		for(int i = 1 ; i <= N ; i++)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a] = b;
		}
		LIS();
		if(true)
		{
			for(int i = 0 ; i <= 10 ; i++)
			{
				System.out.print(dp[i] + " ");
			}
		}
		
	}
	public static void LIS()
	{
		int count = 1;
		
		for(int i = 1; i <= N ; i++)
		{
			if(dp[i-1] < arr[i])
				dp[count++] = arr[i];
			else 
			{
				dp[i-1] = arr[i];
			}
		}
	}
	public static int bs(int left, int right, int val)
	{
		int mid = (left + right) /2;
		
		if(dp[mid] == val) return mid;
		else if(left > right) return left;
		
		if(dp[mid] < val)
			return bs(mid+1, right, val);
		else
			return bs(left, mid-1, val);
	}
}
