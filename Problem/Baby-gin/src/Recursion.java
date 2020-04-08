import java.util.Arrays;
import java.util.Scanner;

public class Recursion {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int[] arr = new int[str.length()];
		for(int i = 0 ; i < str.length() ; i++)
			arr[i] = str.charAt(i)-'0';
		
		System.out.println(permutation(arr, 0));
	}
	
	public static boolean permutation(int[] arr, int depth)
	{
		boolean isBabyGin = false; 
		if(depth == arr.length-1)
		{
			if(triple(arr,0,2) || straight(arr, 0, 2))
				if(triple(arr, 3, 5) || straight(arr, 3, 5))
					isBabyGin = true;
			return isBabyGin;
		}
		for(int i = depth ; i < arr.length ; i++)
		{
			if(isBabyGin) break;
			swap(arr,depth,i);
			isBabyGin = isBabyGin == true ? isBabyGin : permutation(arr, depth+1);
			swap(arr,depth,i);
		}
		return isBabyGin;
	}
	
	public static boolean triple(int[] arr, int left, int right)
	{
		boolean pass = true;
		
		for(int i = left+1 ; i <= right ; i++)
			if(arr[left] != arr[i])
				pass = false;
		
		return pass;
	}
	public static boolean straight(int[] arr, int left, int right)
	{
		boolean pass = true;
		
		for(int i = left+1 ; i <= right ; i++)
			if(arr[i-1]+1 != arr[i])
				pass = false;
		
		return pass;
	}
	public static void swap(int[] arr, int a  , int b)
	{
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
