import java.util.Scanner;
import java.util.Stack;

public class S3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tNum = 1; tNum <= T; tNum++)
		{
			Stack<Character> s = new Stack<Character>();
			String str = sc.next();
			char[] list = str.toCharArray();
			
			int sum = 0;
			for(int i = 0 ; i < list.length; i++)
			{
				if(list[i] == '(')
				{
					s.push(list[i]);
				}
				else if(list[i] == ')' && list[i-1] == ')')
				{
					s.pop();
					sum ++;
				}
				else if(list[i] == ')' && list[i-1] == '(')
				{
					s.pop();
					sum += s.size();
				}
			}
			
			System.out.println("#" + tNum+ " "+sum);
			
		}
		
		
		
	}

}
