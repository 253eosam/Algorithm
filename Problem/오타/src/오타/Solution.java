package ø¿≈∏;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	public static final int REMAINDER = 1_000_000_007;
	public static String str;
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int tNum = 1 ; tNum <= T ;tNum++)
		{
			long sum = 0;
			str = br.readLine();
			
			if(str.length() <= 1)
			{
				sum = 1;
				bw.write("#" + tNum + " " + sum + "\n");
				break;
			}
//			else if(str.length() == 2)
//				sum = str.charAt(0) == str.charAt(1) ? 1 : 4;
			else
				sum = edge();
			
			for(int i = 1 ; i < str.length()-1 ; i++)
			{
				int mid = middle(i);
				sum = (sum * (mid == 0 ? 1 : mid)) % REMAINDER;
			}
			
			bw.write("#" + tNum + " " + sum + "\n");
		}//for tNum
		bw.flush();
		bw.close();
	}
	public static int middle(int index)
	{
		int caseNum = 0;
		
		if(str.charAt(index) != str.charAt(index-1))
			caseNum++;
		if(str.charAt(index) != str.charAt(index+1))
			caseNum++;
		if(str.charAt(index-1) != str.charAt(index+1))
			caseNum++;
		
		return caseNum;
	}
	public static int edge()
	{
		int caseNum = 1;
		
		caseNum *= str.charAt(0) == str.charAt(1) ? 1 : 2;
		caseNum *= str.charAt(str.length()-1) == str.charAt(str.length()-2) ? 1 : 2;
		
		return caseNum;
	}
	
}
