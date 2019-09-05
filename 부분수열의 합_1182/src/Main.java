import java.util.Scanner;

public class Main {
	public static int N,M,cnt;
	public static int[] arr;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		
		for(int i = 0 ; i < N ; i++)
			arr[i] = sc.nextInt();
		
		search(0,0);
		
		System.out.println(cnt);
	}
	public static void search(int index, int sum)
	{
		if(Math.abs(sum) == M) cnt++;
		
		for(int i = index ; i < N ; i++)
		{
			search(i+1,sum + arr[i]);
		}
		
		return;
	}

}
