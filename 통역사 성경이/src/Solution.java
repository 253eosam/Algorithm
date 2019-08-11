import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	public static char[] lastChar = { '.','!','?'};
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int tNum = 1; tNum <= T ; tNum++)
		{
			bw.write("#"+tNum+" ");
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int nameNum = 0;
			while(st.hasMoreTokens())
			{
				String str = st.nextToken();
				if('A' <= str.charAt(0) && str.charAt(0) < 'Z')
				{
					boolean pass = true;
					for(int j = 1 ; j < str.length()-1; j++)
					{
						if('a' <= str.charAt(j) && str.charAt(j) <= 'z')
							pass = true;
						else
						{
							pass = false;
							break;
						}
					}
					char last = str.charAt(str.length()-1);
					if(pass)
					{
						if('A' <= last && last <= 'Z'
								|| 'a' <= last && last <= 'z')
						{
							nameNum++;
						}
						else
						{
							for(int j = 0 ; j < lastChar.length ; j++)
							{
								if(last == lastChar[j])
								{
									nameNum++;
									break;
								}
							}
						}
					}//if pass true
				}//if str[0]
				for(int i = 0 ; i < lastChar.length ; i++)
				{
					if(str.charAt(str.length()-1) == lastChar[i])
					{
						bw.write(nameNum + " ");
						nameNum = 0;
					}
				}
			}//for hasNextToken
			bw.newLine();
		}//for tNum
		bw.flush();
		bw.close();
		
	}

}
