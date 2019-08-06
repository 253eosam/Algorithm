package ø¿≈∏;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int tNum = 1 ; tNum <= T ;tNum++)
		{
			String tmp = br.readLine();
			char[] chars = tmp.toCharArray();
			int sum = 0;
			for(int i = 1; i < chars.length-1 ; i++)
			{
				char pre = chars[i-1];
				char post = chars[i+1];
				int cnt = 0;
				if(pre != post)
				{
					if(chars[i] == pre || chars[i] == post)
						cnt = 2;
				}
				else if(pre == post)
				{
					cnt = chars[i] == pre ? 1 : 2;
				}
				sum *= cnt;
			}
			bw.write("#" + tNum + " " + sum + "\n");
		}//for tNum
		bw.flush();
		bw.close();
	}
}
