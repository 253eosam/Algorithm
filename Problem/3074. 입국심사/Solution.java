import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int N ;
	public static long M;
	public static long[] arr;
	public static int stoi(String str ) {	return Integer.parseInt(str); } 
	public static void main(String[] args) throws Exception 
	{
		int T = stoi(br.readLine());
		for(int tNum = 1 ; tNum <= T ; tNum++)
		{
			st = new StringTokenizer(br.readLine());
			N = stoi(st.nextToken());
			M = Long.parseLong(st.nextToken());
			arr = new long[N];
			for(int i = 0 ; i < N ; i++)
			{
				arr[i] = stoi(br.readLine());
			}
			
			Arrays.sort(arr);
			long left = 0;
			long solv = arr[N-1] * M;
			long right = solv;
			long mid = (left + right) /2 ;
			while(left <= right)
			{
				long val = 0;
				for(int i = 0 ; i < N ; i++)
				{
					val += mid / arr[i];
				}
				if(val < M) 
				{
					left = mid + 1;
				}
				else
				{
					right = mid - 1;
					solv = mid;
				}
				mid = (left + right) / 2;
			}
			bw.write("#"+tNum+" "+solv+"\n");
		}//for tNum
		bw.flush();
		bw.close();

	}

}
