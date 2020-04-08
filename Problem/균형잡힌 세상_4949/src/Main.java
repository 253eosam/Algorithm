import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			String str = sc.nextLine();
			if(str.equals("."))
				break;
			Stack<Character> s = new Stack<>();
			boolean pass = true;
			for(int i = 0 ; i < str.length() ; i++)
			{
				char cTmp = str.charAt(i);
				if(cTmp == '(' || cTmp == '[')
					s.push(cTmp);
				else if(cTmp == ')' || cTmp == ']')
				{
					if(!s.isEmpty())
					{
						char tmp = s.pop();
						if((cTmp == ')' ? '(' : '[') != tmp)
						{
							pass = false;
							break;
						}
					}
					else
					{
						pass = false;
						break;
					}
				}
				
			}
			
			if(pass && s.size() == 0)
				System.out.println("yes");
			else
				System.out.println("no");
		}//while
	}

}
