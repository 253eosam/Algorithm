import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	public static final boolean DEBUG = false;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for(int tNum = 1; tNum <= T ; tNum++)
		{
			st = new StringTokenizer(br.readLine());
			int N ,K;
			N = Integer.parseInt(st.nextToken());	//인원수
			K = Integer.parseInt(st.nextToken());	//반
			
			int grade = 1; int sw = -1;int _k = -1;
			int[][] arr = new int[K][N];
			for(int i = 0 ; i < N ; i++)
			{
				sw *= -1;
				_k += sw;
				for(; 0 <= _k && _k < K ;_k+=sw)
				{
					arr[_k][i] = grade++;
				}
			}
			bw.write("#"+tNum+" ");
			for(int i = 0 ; i < K ; i++)
			{
				int sum = 0;
				for(int j = 0 ; j < N ; j++)
					sum += arr[i][j];
				bw.write(sum+" ");
			}
			bw.write("\n");
			if(DEBUG)
			{
				for(int i = 0 ; i < K ; i++)
				{
					for(int j = 0 ; j < N ; j++)
						System.out.print(arr[i][j] + " ");
					System.out.println();
				}
			}
			
		}//for tNum
		bw.flush();
		bw.close();
	}

}
