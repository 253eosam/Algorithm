import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		
		int 처음번호 = 0;
		int 현재번호 = L;	// 미리 한번 던진횟수	
		int 던진회수 = 1;
		
		while(처음번호 != (현재번호 % N))
		{
			현재번호 += L;
			던진회수++;
		}
		
		던진회수 *= (M-1);
		System.out.println(던진회수);
	}

}
