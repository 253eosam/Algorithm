import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		long c = sc.nextLong();
		System.out.println(muti(a,b,c));
	}
	public static long muti(long a, long b , long c)
	{
		if(b== 0) return 1;
		else if(b == 1) return a%c;
		if(b % 2 == 0)
		{
			long tmp = muti(a,b/2,c)%c;
			return (tmp * tmp) % c;
		}
		else
		{
			long tmp = muti(a, (b - 1) / 2, c)%c;
			return ((tmp * tmp)%c * a%c) % c;
		}
	}
}
