import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args)
	{
		int T = sc.nextInt();
		for(int tNum = 1 ; tNum <= T ; tNum++)
		{
			int N = sc.nextInt();
			
			Integer arr[] = new Integer[N];
			
			for(int i = 0 ; i < N ; i++)
				arr[i] = sc.nextInt();
			Arrays.sort(arr, Collections.reverseOrder());
			
			int sum = 0;
			for(int i = 0 ; i < N ; i++)
			{
				if((i+1) % 3 == 0)
				{
					sum -= arr[i];
				}
				sum+=arr[i];
			}
			
			System.out.println("#"+tNum + " " + sum);
		}
	}

}
