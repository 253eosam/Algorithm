import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tNum = 1; tNum <= T; tNum++)
		{
			ArrayList<String> arr = new ArrayList<>();
			int maximum = 0;
			int minimum = 987654321;
			for(int i = 0 ; i < 5; i++)
			{
				String tmp = sc.next();
				if(maximum < tmp.length())
					maximum = tmp.length();
				arr.add(tmp);
			}
			for(int i = 0 ; i < arr.size() ; i++)
			{
				String tmp = arr.get(i);
				for(int j = arr.get(i).length() ; j < maximum ; j++)
					 tmp += "-";
				arr.set(i, tmp);
			}
			
			
			String str = "";
			for(int i = 0 ; i < maximum ; i++)
			{
				for(int j = 0 ; j < 5 ; j++)
				{
					if(arr.get(j).charAt(i) != '-')
						str += arr.get(j).charAt(i); 
				}
				
			}
			
			System.out.printf("#%d %s\n",tNum,str);
			
		}
	}

}
