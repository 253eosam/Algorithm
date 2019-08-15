import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int tNum = 1; tNum <= T ; tNum++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[3];
			arr[0] = arr[1] = arr[2] = 0;
			int cnt = 1;
			while(true)
			{
				if(arr[0] == A-1 && arr[1] == B-1 && arr[2] == C-1)
					break;
				cnt++;
				arr[0]++;
				arr[0] %= 365;
				arr[1]++;
				arr[1] %= 24;
				arr[2]++;
				arr[2] %= 29;
			}
			bw.write("#"+tNum+" "+cnt+"\n");
		}
		bw.flush();
		bw.close();
		
	}

}
