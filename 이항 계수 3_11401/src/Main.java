import java.util.Scanner;

public class Main {
	public static final long c = 1_000_000_007;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		long N = sc.nextLong();
		long K = sc.nextLong();

		System.out.println(com(N,K));
	}
	public static long com(long a, long b)
	{
		if(b== 0 || a == b) return 1;
		else if(b == 1) return a%c;
		long tmp = com(a-1,b-1)%c;
		long tmp2 = com(a-1,b)%c;
		return (tmp + tmp2) % c;
	}
}
