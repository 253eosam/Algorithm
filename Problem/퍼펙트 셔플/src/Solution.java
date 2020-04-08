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
		for(int tNum = 1; tNum <= T; tNum++)
		{
			int N = Integer.parseInt(br.readLine());
			String arr[] = new String[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 0 ; i < N ; i++)
				arr[i] = st.nextToken();
			
			int mid = N%2==0 ? N/2 : N/2+1;
			int cnt = 0;
			String output[] = new String[N];
			
			for(int i = 0 ; i < mid ; i++)
			{
				output[cnt++] = arr[i];
				if(i+mid < N)
					output[cnt++] = arr[mid+i];
			}
			
						
			
			bw.write("#"+tNum+" ");
			for(int i = 0 ; i < cnt ; i++)
				bw.write(output[i]+" ");
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		
	}

}
