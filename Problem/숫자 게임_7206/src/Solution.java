import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static int turn;
	public static String startNumber;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int[] d=new int[99999+1]; // Math.max(d[123*4], d[12*34],d[1*234]....)
	public static ArrayList<String> list[] = new ArrayList[99999+1]; //조합에 대한 모든 것
	public static int stoi(String str) { return Integer.parseInt(str); }
	public static void main(String[] args) throws Exception 
	{
		int T = stoi(br.readLine());
		for(int tNum = 1 ; tNum <= T ; tNum++)
		{
			init();
			//powerSet(startNumber);
			dfs();
			
			bw.write("#"+tNum+" "+String.valueOf(turn) + "\n");
		}//for tNum
		bw.close();
	}
	public static class Node
	{
		String str, cut;
		int cnt;
		Node(String str, String cut, int cnt)
		{
			this.str = str;
			this.cut = cut;
			this.cnt = cnt;
		}
	}
	public static void dfs(String str , int cnt)
	{
		
		
		for(String s : list)
		{
			int len = s.length();
			int preNum = s.charAt(0) - '0';
			int num = stoi(str.substring(0, preNum));
			for(int i = 1 ; i < len ; i++)
			{
				int curNum = s.charAt(i) - '0';
				num *= stoi(str.substring(preNum,curNum));
				preNum = curNum;
			}
			num *= stoi(str.substring(preNum));
			
			if(d[num] > 0)
			{
				turn = Math.max(turn, d[num]);
				continue;
			}
			else if(d[num] == 0 && num >= 10)
			{
				turn = Math.max(turn, s.cnt+1);
				d[num] = s.cnt + 1;
				powerSet(String.valueOf(num),s.cnt+1);
			}
		}
			
	}
	public static void test(ArrayList<String> list)
	{
		for(String s : list)
			System.out.println(s);
	}
	public static void init() throws Exception
	{
		startNumber = br.readLine();
		d = new int[1_000_000];
	}
	public static void powerSet(String val)
	{	
		for(int i = 1; i < val.length() ; i++)
			com(val,i,1,0,new int[val.length()]);	
	}
	public static void com(String str,final int target, int idx, int deep, int[] pick )
	{
		if(deep == target)
		{
			String tmp = "";
			for(int i = 0 ; i < deep ; i++)
			{
				tmp += String.valueOf(pick[i]);
			}
			list[Integer.parseInt(str)].add(tmp);
			return ;
		}
		
		for(int i = idx ; i < str.length(); i++)
		{
			pick[deep] = i;
			com(str,target,i+1,deep+1,pick);
		}
	}
}
