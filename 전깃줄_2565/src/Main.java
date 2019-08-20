import java.util.Scanner;

public class Main {
	public static final int MAX_SIZE = 500;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[MAX_SIZE+1];
		for(int i = 1 ; i <= N ; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a] = b;
		}
		int allCnt = 0;
		for(int i = 1; i <= MAX_SIZE ; i++)
		{
			if(arr[i] == 0) continue;
			int dir = arr[i] - i;
			int min = Math.min(arr[i], i);
			int max = Math.max(arr[i], i);
			dir = dir >= 0 ? 1 : -1;
			int cnt = 0;
			for(int j = i+dir ; min < j && j < max ; j += dir)
			{
				if(arr[j] != 0 )
					++cnt;
				
			}
			if(cnt > 0) allCnt++;
//			System.out.println(i+"cnt : " + cnt);
		}
		
		System.out.println(allCnt);
		
	}
}
