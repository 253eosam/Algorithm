import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int val = a*b;
		while(b > 0)
		{
			int tmp = b%10;
			System.out.println(a * tmp);
			b /= 10;
		}
		System.out.println(val);
	}

}
