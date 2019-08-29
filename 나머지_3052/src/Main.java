import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T = 10; 
		int n = 42;
		int[] arr = new int[n];
		for(int i = 0 ; i < T ; i++)
		{
			arr[sc.nextInt() % n]++;
		}
		
		int cnt = 0;
		for(int i = 0 ; i < n ; i++)
		{
			if(arr[i] > 0)
				cnt++;
		}
		
		System.out.println(cnt);
	}

}
