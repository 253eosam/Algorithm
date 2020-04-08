import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		int N = str.length();
		
		int maxCol = 0;
		for(int i = 1 ; i <= Math.sqrt(N) ; i++)
		{
			if(N % i == 0)
				maxCol = Math.max(maxCol, i);
		}
		
		char[][] arr = new char[N/maxCol][maxCol];
		int cnt = 0;
		for(int i = 0 ; i < arr.length ; i++)
		{
			for(int j = 0 ; j < arr[i].length ; j++)
			{
				arr[i][j] = str.charAt(cnt++);
			}
		}
		
		for(int i = 0 ; i < arr[0].length ; i++)
		{
			for(int j = 0 ; j < arr.length ; j++)
			{
				System.out.print(arr[j][i]);
			}
		}
	}
}