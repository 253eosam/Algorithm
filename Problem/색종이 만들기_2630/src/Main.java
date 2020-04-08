import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static int isColor,isNotColor;
	public static int[][] arr;
	public static void main(String[] args) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		//init
		arr = new int[N][N];
		
		//input
		for(int i = 0 ; i < N ; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		//logic
		divide(0,0,N);
		
		//print
		bw.write(String.valueOf(isNotColor)+" "+String.valueOf(isColor));
		bw.flush();
		bw.close();
	}
	public static void divide(int y, int x, int N)
	{

		
		int sum = allSum(y,x,N);
		if(sum == Math.pow(N, 2)) 
		{
			isColor++;
			return;
		}
		else if(sum == 0)
		{
			isNotColor++;
			return;
		}
		if(N/2 == 0) return;
		
		//»óÁÂ
		divide(y,x,N/2);
		//»ó¿ì
		divide(y,x+N/2,N/2);
		//ÇÏÁÂ
		divide(y+N/2,x,N/2);
		//ÇÏ¿ì
		divide(y+N/2,x+N/2,N/2);
	}
	public static int allSum(int y, int x ,int N)
	{
		int sum = 0;
		for(int i = y; i < y+N ; i++)
		{
			for(int j = x; j < x+N ; j++)
			{
				sum += arr[i][j];
			}
		}
		return sum;
	}

}
