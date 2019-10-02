import java.util.Scanner;

public class Main {
	public static int N;
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		int val = 666;
		int cnt = 1;
		while(true)
		{
			if(cnt == N) break;
			
			val++;
			int tmp = val;
			int sixNum = 0;
			while(tmp > 0)
			{
				if(sixNum >= 3) break;
				if(tmp % 10 == 6)
					sixNum++;
				else
					sixNum = 0;
				tmp /= 10;
			}
			
		}
		
		System.out.println(val);
	}
}
