

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution 
{
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int N,cnt;
	public static String[] arr, brr;
	public static void main(String[] args) throws Exception
	{
		int T = Integer.parseInt(br.readLine());
		for(int tNum = 1 ; tNum <= T ; tNum++)
		{
			init();
			
			logic();
			
			print(tNum);
			
		}//for tNum
		bw.close();
	}//main
	private static void print(int tNum) throws IOException {
		bw.write("#"+tNum + " ");
		for(int i = 0 ; i < N ; i++)
			bw.write(brr[i]);
		bw.write("\n");
	}
	public static int where(int s, int e)
	{
		if(s >= e) return 0;
		if(arr[s].equals(arr[e]))
			return where(s+1,e-1);
		return arr[s].compareTo(arr[e]);
	}
	private static void logic() {
		int left , right;
		left = 0 ; right = N-1;
		
		while(left != right)
		{
			int find = where(left,right);
			if(find < 0)
				brr[cnt++] = arr[left++];
			else if(find > 0)
				brr[cnt++] = arr[right--];
			else if(find == 0)
				while(left < right)
					brr[cnt++] = arr[left++];
		}
		brr[cnt++]  = arr[left];
	}
	public static void init() throws NumberFormatException, IOException
	{
		N = Integer.parseInt(br.readLine());
		arr = new String[N];
		brr = new String[N];
		cnt = 0;
		for(int i = 0 ; i < N ; i++)
			arr[i] = br.readLine();
	}
}
