import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static int N, M;
	public static int[] arr;
	public static int[] pick;
	public static ArrayList<String> list;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N+1];
		list = new ArrayList<>();
		pick = new int[M+1];
		
		for(int i = 1 ; i <= N ; i++)
		{
			arr[i] = i;
		}
		
		permutation(1,0);
		
		Collections.sort(list);
		
		for(String str : list)
			System.out.println(str);
	}
	public static void permutation(int index, int depth)
	{
		if(depth == M)
		{
			String str = "";
			for(int i = 1 ; i <= M ; i++)
			{
				str += pick[i] + " ";
			}
			list.add(str);
			return ;
		}
		
		for(int i = index ; i <= N ; i++)
		{
			pick[depth+1] = i;
			permutation(i+1,depth+1);
		}
	}
	public static void swap(int a, int b)
	{
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
