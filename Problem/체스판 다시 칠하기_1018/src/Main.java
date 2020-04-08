import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static int[][] arr;
	public static int N,M;
	public static int minimum = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		//init
		arr = new int[N][M];	// B : 1 , W : -1
		//input
		for(int i = 0 ; i < N ; i++)
		{
			String str = br.readLine();
			for(int j = 0 ; j < M ; j ++)
			{
				char tmp = str.charAt(j);
				if(tmp == 'B')
					arr[i][j] = 1;
				else
					arr[i][j] = -1;
			}
		}
		
		//logic
		for(int i = 0 ; i <= N-8 ; i++)
		{
			for(int j = 0 ; j <= M-8 ; j++)
			{
				int sw = -1;
				for(int k = 0 ; k < 2 ; k++)
				{
					minimum = Math.min(minimum, pattern(i,j,sw));
					sw *= -1;
				}
			}
		}
		//print
		bw.write(String.valueOf(minimum));
		bw.flush();
		bw.close();
	}
	public static int pattern(int y, int x, int sw)
	{
		int solv = 0;
		for(int i = y ; i < y+8 ; i++)
		{
			sw *= -1;
			for(int j = x ; j < x+8 ; j++)
			{
				if(arr[i][j] != sw)
				{
					solv++;
				}
				sw *= -1;
			}
		}
		return solv;
	}
}
