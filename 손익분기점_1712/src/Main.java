import java.util.Scanner;

public class Main {
	public static long A,B,C;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		long tmp =  C - B;
		if(tmp <= 0)
		{
			System.out.println(-1);
			return;
		}
		long remain = A%tmp;
		remain = remain >= 0 ? 1 : 0;
		System.out.println(A/tmp + remain);
	}

}
