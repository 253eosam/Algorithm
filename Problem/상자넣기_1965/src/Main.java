import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int[] arr;
	public static int[] dp;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int N;
	public static int stoi(String str) { return Integer.parseInt(str); }
	public static void main(String[] args) throws Exception 
	{
		N = stoi(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++)
		{
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[N];
		
		int solv = lis();
		bw.write(String.valueOf(solv));
		bw.flush();
		bw.close();
	}
	public static int lis()
	{
		dp[0] = arr[0];
		int cnt = 1;
		
		for(int i = 1 ; i < N ; i++)
		{
			if(dp[cnt-1] < arr[i])
				dp[cnt++] = arr[i];
			else
			{
				int index = binarySearch(0, cnt, arr[i]);
				dp[index] = arr[i];
			}
//			System.out.println(Arrays.toString(dp));
		}
		
		return cnt;
	}
	public static int binarySearch(int left , int right, int value)
	{
		int mid = (left + right) / 2;
		while(left < right)
		{
			if(dp[mid] >= value)
			{
				right = mid;
			}
			else if(dp[mid] < value)
			{
				left = mid + 1;
			}
			mid = (left + right) / 2;
		}
		return right;
	}
	
	
}
