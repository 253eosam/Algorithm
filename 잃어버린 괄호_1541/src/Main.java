import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		
		int result = 0;
		String tmp = "";
		boolean minus = false;
		for(int i = 0 ; i < str.length() ; i++)
		{
			char c = str.charAt(i);
			if(c == '+' || c == '-' )
			{
				if(minus)
					result -= Integer.parseInt(tmp);
				else 
					result += Integer.parseInt(tmp);
				tmp = "";
				if(c == '-')
					minus = true;
				continue;
			}
			tmp += c;
		}
		if(minus)
			result -= Integer.parseInt(tmp);
		else 
			result += Integer.parseInt(tmp);
		System.out.println(result);
	}


}
