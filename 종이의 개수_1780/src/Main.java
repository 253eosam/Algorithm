import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static int[][] arr;
	public static int[] counting;
	public static int[] solvCnt;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		//init
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		counting = new int[3];
		solvCnt = new int[3];
		
		//input
		for(int i = 0 ; i < N ; i ++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j ++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//logic
		divide(N,0,0);
		
		//print
		for(int i = 0 ; i < 3 ; i++)
		{
			bw.write(solvCnt[i] + "\n");
		}
		bw.flush();
		bw.close();
	}
	public static void divide(int N , int y, int x)
	{
		counting = new int[3];
		for(int i = 0 ; i < N ; i++)
		{
			for(int j = 0 ; j < N ; j++)
			{
				counting[arr[i+y][j+x]+1]++;
			}
		}
		
		for(int i = 0 ; i < 3 ; i++)
		{
			if(counting[i] == N*N)
			{
				solvCnt[i]++;
				return;
			}
		}
		
		for(int i = 0 ; i < 3 ; i++ )
		{
			for(int j = 0 ; j < 3; j++ )
			{
				divide(N/3,y+(i*N/3),x+(j*N/3));
			}
		}
	}
}
