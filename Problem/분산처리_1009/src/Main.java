import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tNum = 1; tNum <= T ; tNum++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = remainderPow(a,b);
			long d = c == 0 ? 10 : c;
			System.out.println(d);
		}
		
	}
	public static int remainderPow(int a, int b)
	{
		int solv = a;
		for(int i = 1 ; i < b; i++)
		{
			solv *= a;
			solv %= 10;
		}
		return solv;
	}

}
