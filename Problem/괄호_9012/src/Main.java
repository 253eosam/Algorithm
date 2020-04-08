import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tNum = 1; tNum <= T ; tNum++)
		{
			String str = sc.next();
			Stack<Character> s = new Stack<>();
			boolean pass = true;
			for(int i = 0 ; i < str.length() ; i++)
			{
				if(str.charAt(i) == '(')
					s.push(str.charAt(i));
				else
				{
					if(!s.isEmpty())
						s.pop();
					else
					{
						pass = false;
						break;
					}
				}
			}
			if(s.size() != 0 || !pass)
				System.out.println("NO");
			else
				System.out.println("YES");
			
		}
		
		
	}

}
