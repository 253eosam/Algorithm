import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int N,M,H;
	public static int[] arr;
	public static void main(String[] args) throws Exception 
	{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		long high = 0;
		for(int i = 0 ; i < N ; i++)
		{
			arr[i] = Integer.parseInt(st.nextToken());
			high = Math.max(high, arr[i]);
		}
		
		System.out.println(bs(0,high));
	}
	/*
	 * 1. bs를 통해 나무를 자른다. 
	 * 2. 자른 나무에서 가지고갈수 있는 나무의 근사값을 찾는다.
	 */
	
	// H를 찾는 이진탐색
	public static long bs(long left, long right)
	{
		boolean isOdd = (left + right) % 2 == 1;
		long mid = (left + right) / 2;
		if(isOdd)
			mid++;
		
		
		long remainSum = 0;
		for(int i = 0 ; i < N ; i++)
		{
			long remain = arr[i] - mid;
			remainSum += (remain >= 0 ? remain : 0);
		}
		
		if(left > right) return right;
		
		if(M < remainSum)
			return bs(mid+1,right);
		else if(remainSum < M)
			return bs(left,mid-1);
		else 
			return mid;
	}
}
