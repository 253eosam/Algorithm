import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String s1 = sc.next();
		String s2 = sc.next();
		
		int rowIndex = 0, colIndex = 0 ;
		outer : for(int i = 0 ; i < s1.length() ; i++)
		{
			for(int j = 0 ; j < s2.length() ; j++)
			{
				if(s1.charAt(i) == s2.charAt(j))
				{
					colIndex = i;
					rowIndex = j;
					break outer;
				}
			}
		}
		
		char[][] arr = new char[s2.length()][s1.length()];
		for(int i = 0 ; i < s2.length() ; i ++)
		{
			for(int j = 0 ; j < s1.length() ; j++)
			{
				if(colIndex == j)
					arr[i][j] = s2.charAt(i);
				else if(rowIndex == i)
					arr[i][j] = s1.charAt(j);
				else
					arr[i][j] = '.';
			}
		}
		for(int i = 0 ; i < s2.length() ; i++)
		{
			for(int j = 0 ; j < s1.length() ; j++)
			{
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}

}
