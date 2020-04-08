import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
//	public static String specialStr = "0";
	public static void main(String[] args) throws Exception 
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tNum = 1 ; tNum <= T ; tNum++)
		{
			long N = Long.parseLong(br.readLine());
			
			int output = binarySearch(N);
			
			bw.write("#"+tNum+" "+output+"\n");
			
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
	
	public static int binarySearch(long target)
	{
		int solv = 0;
		
		long left = 1 , right = 1;
		
		while(right <= target)	// find right
			right <<= 1;
		
		while(true)
		{
			long mid = (left + right) / 2;
			
			if(target == mid) break;
			else
			{
				if(target < mid)
				{
					solv = 0;
					right = mid;
				}
				else
				{
					solv = 1;
					left = mid;
				}
			}
		}
		
		return solv;
	}
	
//	public static String copyP(String str)
//	{
//		String output = "";
//		
//		output += str + "0" + reverse(str);
//		
//		return output;
//	}
//	public static String reverse(String str)
//	{
//		String output = "";
//		
//		char[] tmp = reflect(str).toCharArray();
//		for(char t : tmp)
//			output += t == '0' ? '1' : '0';
//		
//		return output;
//	}
//	public static String reflect(String str)
//	{
//		String output = "";
//		
//		for(int i = str.length()-1 ; i >= 0 ; i--)
//			output += str.charAt(i);
//		
//		return output;
//	}
}
