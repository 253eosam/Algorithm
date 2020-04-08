import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	public static String output;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for(int tNum = 1 ; tNum <= T ; tNum++)
		{
			st = new StringTokenizer(br.readLine());
			bw.write("#"+tNum+" ");
			String str = st.nextToken();
			int change = Integer.parseInt(st.nextToken());
			output = "";
			boolean pick[][] = new boolean[1_000_000][change];
			permutation(str,pick,0,change);

			bw.write(output + "\n");
		}//for tNum
		bw.flush();
		bw.close();
	}

	public static void permutation(String newStr,boolean[][] pick, int curCnt, int targetCnt)
	{
//		System.out.println("newStr : " + newStr + ", start : " + start + ", curCnt" + curCnt);
		if(curCnt == targetCnt)
		{
			if(output.compareTo(newStr) < 0)
				output = newStr;
			return ;
		}
		if(pick[Integer.parseInt(newStr)][curCnt])
			return;
		pick[Integer.parseInt(newStr)][curCnt] = true;


		char[] charList = newStr.toCharArray();
		for(int i = 0 ; i < charList.length; i++)
		{
			for(int j = 0 ; j < charList.length ; j++)
			{
				if(i != j)
				{
					swap(charList,i,j);
					permutation(new String(charList), pick,curCnt+1,targetCnt);
					swap(charList,i,j);
				}
			}
		}//for i
	}
	public static void swap(char[] list, int a, int b)
	{
		char tmp = list[a];
		list[a] = list[b];
		list[b] = tmp;
	}
}