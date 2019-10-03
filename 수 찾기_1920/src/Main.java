import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0 ; i < N ; i++)
		{
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int M = sc.nextInt();
		for(int i = 0 ; i < M ; i++)
		{
			int findVal = sc.nextInt();
			System.out.println(bs(arr,0,N,findVal));
		}
			
		
	}
	
	public static int bs(int[] arr, int left, int right, int val)
	{
		int mid = (left + right) /2;
		
		if(left >= right) return 0;
		if(arr[mid] == val) return 1;
		
		if(arr[mid] < val)
			return bs(arr,mid+1,right,val);
		else
			return bs(arr,left,mid,val);
	}
}
