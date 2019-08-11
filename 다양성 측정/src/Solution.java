import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Solution {
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int tNum = 1; tNum <= T ; tNum++)
		{
			String str = br.readLine();
			Set<Character> set = new HashSet<>();
			for(int i = 0 ; i < str.length(); i++)
			{
				set.add(str.charAt(i));
			}
			bw.write("#"+tNum+" "+set.size()+"\n");
		}
		bw.flush();
		bw.close();
	}
}
