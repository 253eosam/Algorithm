import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
	
	public static ArrayList<Integer> A = null;
	public static ArrayList<Integer> B = null;
	public static int cnt = 0;
	public static int allSum = 0;
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		A = new ArrayList<>();
		B = new ArrayList<>();
		int T = Integer.parseInt(br.readLine());
		for(int tNum = 1; tNum <= T ; tNum++)
		{
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0 ; i < 9 ; i++)
			{
				int tmp = Integer.parseInt(st.nextToken());
				A.add(tmp);
			}
			for(int i = 1 ; i <= 18 ; i++)
			{
				allSum += i;
				if(!A.contains(i))
				{
					B.add(i);
				}
			}
			
			Collections.sort(A);
			Collections.sort(B);
			
			permuation(0,0,0);
			
			bw.write("#"+tNum+" "+cnt+"\n");
		}//for tNum
		bw.flush();
		bw.close();
	}//main
	public static int caseWin = 0;
	public static void permuation(int a,int b, int sum)
	{
		for(int i = a ; i < 9 ; i++)
		{
			for(int j = b ; j < 9 ; j++)
			{
				if(A.get(i)>B.get(j))
				{
					permuation(i+1,j+1,sum+A.get(i)+B.get(j));
				}
			}
		}
		if(sum > allSum - sum)
			cnt++;
	}
	public static void swap(int[] arr , int i, int j)
	{
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}	
