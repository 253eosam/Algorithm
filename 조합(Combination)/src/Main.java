import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = 4;
		int[] arr = new int[N];
		String tmp = sc.next();
		for(int i = 0 ; i < N ; i++)
			arr[i] = tmp.charAt(i)-'0';
		
		combination(arr, 0, 3, "");
		
	}
	
	public static void combination(int[] arr, int cur, int len, String output)
	{
		if(cur == len)
		{
			System.out.println(output);
			return;
		}
		for(int i = cur ; i < arr.length ; i++)
		{
			swap(arr,cur,i);
			combination(arr,cur+1,len,output+String.valueOf(arr[cur]));
			swap(arr,cur,i);
		}
	}
	public static void swap(int[] arr, int a ,int b)
	{
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

}
