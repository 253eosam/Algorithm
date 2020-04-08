import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char base64[] = { 'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P',
				'Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f',
				'g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v',
				'w','x','y','z','0','1','2','3','4','5','6','7','8','9','+','/'
		};
		int T = Integer.parseInt(br.readLine());
		
		for(int tNum = 1 ; tNum <= T ; tNum++)
		{
			bw.write("#"+tNum+" ");
			String str = br.readLine();
			String longBit = "";
			//to base64
			for(int i = 0 ; i < str.length(); i++)
			{
				for(int j = 0 ; j < 64 ; j++)
				{
					if(str.charAt(i) == base64[j])
					{
						int cod = j;
						int binary = 32;
						while(binary > 0)
						{
							longBit += (cod / binary) > 0 ? "1" : "0";
							cod %= binary;
							binary >>= 1;
						}
						break;
					}
				}
			}//for i
			
			//to cut bit8 and convert to ASCII
			String tmp = ""; int cutting = 8;
			for(int i = 1 ; i <= longBit.length() ; i++)
			{
				tmp += longBit.charAt(i-1);
				if( i % cutting == 0)
				{
					int binary = 128; int sum = 0;
					for(int j = 0 ; j < tmp.length() ; j++)
					{
						sum += tmp.charAt(j) == '1' ? binary : 0;
						binary >>= 1;
					}
					bw.write((char)sum);
					tmp ="";
				}
			}
			
			
			bw.write("\n");
		}//for tNum
		
		bw.flush();
		bw.close();
		
	}//main

}
