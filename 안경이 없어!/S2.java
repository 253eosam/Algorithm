import java.util.Scanner;

public class S2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		char[] one = { 'A' , 'D', 'O' , 'P','Q','R'};
		char two = 'B';
		for(int tNum = 1; tNum <= T ;tNum++)
		{
			String[] str = new String[2];
			
			for(int i = 0 ; i < 2 ; i++)
			{
				str[i] = sc.next();
			}
			
			boolean same = true;
			if(str[0].length() == str[1].length())
			{
				for(int i = 0 ; i < str[0].length() ; i++)
				{
					int check1 = 0;
					int check2 = 0;
					if(str[0].charAt(i) == two)
					{
						check1 = 2;
					}
					else
					{
						for(int j = 0 ; j < one.length; j++)
						{
							if(str[0].charAt(i) == one[j])
								check1 = 1;
							if(str[1].charAt(i) == one[j])
								check2 = 1;
						}
					}
					if(str[1].charAt(i) == two)
						check2 = 2;
					
					if(check1 != check2)
						same = false;
					
				}
			}
			else 
				same = false;
		
			if(same)
				System.out.println("#"+(tNum)+" SAME");
			else
				System.out.println("#"+(tNum)+" DIFF");
			
		}
	}

}
