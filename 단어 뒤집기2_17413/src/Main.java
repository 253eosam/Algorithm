import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Deque<Character> list = new LinkedList<>();
		String str = sc.nextLine();
		StringBuilder output=new StringBuilder();
		for(int i = 0 ; i < str.length() ; i++)
		{
			if(str.charAt(i) == '<')
			{
				while(!list.isEmpty())
				{
					output.append(list.pollLast());
//					output += list.pollLast();
				}
				while(str.charAt(i) != '>')
				{
					list.add(str.charAt(i++));
				}
				list.add(str.charAt(i));
				while(!list.isEmpty())
				{
					output.append(list.pollFirst());
//					output += list.pollFirst();
				}
			}
			else if(str.charAt(i) == ' ')
			{
				while(!list.isEmpty())
				{
					output.append(list.pollLast());
//					output += list.pollLast();
				}
				output.append(' ');
//				output += ' ';
			}
			else
			{
				list.add(str.charAt(i));
			}
		}
		while(!list.isEmpty())
		{
			output.append(list.pollLast());
//			output += list.pollLast();
		}
		System.out.println(output);
		
		
		
	}

}
