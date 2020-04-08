import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {

		Stack<Integer> s = new Stack<>();
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tNum = 1; tNum <= T ; tNum++)
		{
			int tmp = sc.nextInt();
			if(tmp == 0 && !s.isEmpty())
				s.pop();
			else
				s.push(tmp);
		
		}
		int sum = 0;
		while(!s.isEmpty())
			sum += s.pop();
		System.out.println(sum);
	}

}
