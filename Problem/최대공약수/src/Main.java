import java.util.Scanner;

public class Main {
	
	public static int gcd(int a, int b)
	{
		if(a % b == 0)
			return b;
		return gcd(b , a % b);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if(a < b)
		{
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		int g = gcd(a,b);
		System.out.println(g);
		System.out.println(a*b/g);
	}

}
