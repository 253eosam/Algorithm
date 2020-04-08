import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	public static String[] crypt = { "0001101","0011001","0010011","0111101","0100011","0110001","0101111","0111011","0110111","0001011"};
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for(int tNum = 1; tNum <= T ; tNum++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[][] arr = new int[N][M];
			String str = "";
			String input = ""; int lastIndex = 0;
			boolean full = false;
			outer : for(int i = 0 ; i < N ; i++)
			{
				input = br.readLine();
				for(int j  = input.length()-1 ; j >= 0 ; j--)
				{
					if(input.charAt(j) - '0' == 1)
					{
						str = input;
						if(!full)
						{
							lastIndex = j;
							full = true;
						}
					}
				}
			}//outer

			str = str.substring(lastIndex-(7*8)+1, lastIndex+1);
			//			System.out.println(str.length());
			//			System.out.println(str);
			int unit = 7;
			String cryptogram = "";
			String tmp = "";
			for(int i = 0 ; i < str.length() ; i++)
			{
				if(i == str.length()-1)
					tmp += str.charAt(i);
				if(i % unit == 0 || i == str.length()-1)
				{
					for(int j = 0 ; j < crypt.length ; j++)
					{
						if(tmp.equals(crypt[j]))
							cryptogram += Integer.toString(j);
					}
					tmp = "";
				}
				tmp += str.charAt(i);
			}
			int sum = 0; int even = 0; int allSum = 0;
			for(int i = 0 ; i < cryptogram.length(); i++)
			{
				int tmpNum = cryptogram.charAt(i) - '0';
				if(i % 2 == 0)
					even += tmpNum;
				else
					sum += tmpNum;
				allSum += tmpNum;
			}
			sum += even * 3;

			if(sum % 10 == 0)
				bw.write("#"+tNum+" "+allSum+"\n");
			else
				bw.write("#"+tNum+" "+0+"\n");
		}//for tNum
		bw.flush();
		bw.close();

	}

}
