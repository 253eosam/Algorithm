import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
			long n = sc.nextLong();
			long k = sc.nextLong();
			long solv = n;
			solv += buyChickenByCoupon(n,k);
			System.out.println(solv);
		}
	}
	
	public static long buyChickenByCoupon(long n , long k)
	{
		if(n / k <= 0) return 0;
		long chicken = n / k;
		long coupon = chicken + (n%k);
		chicken += buyChickenByCoupon(coupon, k);
		return chicken;
	}
	

}
