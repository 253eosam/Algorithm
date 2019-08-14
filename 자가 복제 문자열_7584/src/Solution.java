import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	public static String specialStr = "0";
	public static void main(String[] args) throws Exception 
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tNum = 1 ; tNum <= T ; tNum++)
		{
			int N = Integer.parseInt(br.readLine());
			
			
			
//			while(N > specialStr.length()-1)
//			{
//				specialStr = copyP(specialStr);
//				System.out.println(specialStr);
//			}
//			bw.write("#"+tNum+" "+specialStr.charAt(N-1)+"\n");
		}//for tNum
		bw.flush();
		bw.close();
	
	}
	
	public static String copyP(String str)
	{
		String output = "";
		
		output += str + "0" + reverse(str);
		
		return output;
	}
	public static String reverse(String str)
	{
		String output = "";
		
		char[] tmp = reflect(str).toCharArray();
		for(char t : tmp)
			output += t == '0' ? '1' : '0';
		
		return output;
	}
	public static String reflect(String str)
	{
		String output = "";
		
		for(int i = str.length()-1 ; i >= 0 ; i--)
			output += str.charAt(i);
		
		return output;
	}
}
