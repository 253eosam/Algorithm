import java.util.Scanner;
import java.util.Stack;

public class S {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tNum = 1; tNum <= T; tNum++)
		{
			Stack<Integer> s = new Stack();
			
			String a = sc.next();
			String b = sc.next();

			if(a.length() < b.length())
			{
				String tmp = a;
				a = b;
				b = tmp;
			}
			
			char[] aList = a.toCharArray();
			char[] bList = b.toCharArray();
			
			int maxSize = aList.length;
			int minSize = bList.length;
			
			for(int i = 0 ; i < maxSize - minSize; i++ )
			{
				s.push(aList[i] - '0');
			}
			for(int i = 0 ; i < minSize ; i++)
			{
				int tmp = (aList[maxSize-minSize+i] - '0') + (bList[i] - '0');
				s.push(tmp);
			}
			
			int up = 0;
			String str = "";
			while(!s.isEmpty())
			{
				int i = s.pop();
//				System.out.println("i : " + i);
				i += up;
				if (i >= 10)
					up = 1;
				else
					up = 0;
				i%=10;
				str += Integer.toString(i);
			}
			if(up == 1)
				str += "1";
			char[] output = str.toCharArray();
			System.out.print("#" + tNum + " ");
			for(int i = str.length()-1 ; i >= 0 ; i--)
				System.out.print(output[i]);
			System.out.println();
		}
	}

}
