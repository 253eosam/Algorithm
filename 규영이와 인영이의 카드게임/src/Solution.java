import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static ArrayList<int[]> list = new ArrayList<>();
	public static int[] uCards = null;
	public static final int cardNum = 5;
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for(int tNum = 1; tNum <= T ; tNum++)
		{
			st = new StringTokenizer(br.readLine());
			int[] counting = new int[cardNum+cardNum+1];
			for(int i = 0; i < cardNum ; i++) {
				counting[Integer.parseInt(st.nextToken())]++;
			}
			
			int[] cards = new int[cardNum]; int cnt = 0;
			uCards = new int[cardNum]; int uCnt = 0;
			for(int i = 1 ; i <= cardNum+cardNum ; i++)
			{
				if(counting[i] == 0)
					cards[cnt++] = i;
				else
					uCards[uCnt++] = i;
			}
			permuation(cards, 0);
			bw.write("#"+tNum+" "+caseWin+" "+(int)(Math.pow(cardNum, cardNum)-caseWin)+"\n");
		}//for tNum
		bw.flush();
		bw.close();
	}//main
	public static int caseWin = 0;
	public static void permuation(int[] arr , int depth)
	{
		if(arr.length -1== depth)
		{
			System.out.println(Arrays.toString(arr));
			int win = 0;
			for(int i = 0 ; i < cardNum ; i++)
			{
				if(arr[i] > uCards[i])
					win++;
				if(win >= cardNum/2+1)
				{
					caseWin++;
					System.out.println(caseWin);
					break;
				}
			}
			return;
		}
		for(int i = depth; i < cardNum ; i++)
		{
			swap(arr,depth,i);
			permuation(arr, depth+1);
			swap(arr,depth,i);
		}
	}
	public static void swap(int[] arr , int i, int j)
	{
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}	
