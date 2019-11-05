import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main 
{
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int N,M,R;
	public static int[][] arr,brr;
	public static int stoi(String str) { return Integer.parseInt(str); }
	public static void main(String[] args) throws Exception 
	{
		init();
		logic(R);
		print();
	}
	private static void logic(int c) {
		copy(brr,arr);
		while(c-- > 0)
		{
			for(int i = 0 ; i < Math.min(N, M)/2 ; i++)
				turn(i);
			copy(arr,brr);
		}
	}
	public static void copy(int[][]arr , int[][] brr)	
	{
		for(int i = 0 ; i < N ; i++)
		{
			for(int j = 0  ; j < M ; j++)
			{
				arr[i][j] = brr[i][j];
			}
		}
	}
	public static void print()
	{
		for(int i = 0 ; i < N ; i++)
		{
			for(int j = 0  ; j < M ; j++)
			{
				System.out.print(brr[i][j] + "\t");
			}
			System.out.println();
		}
	}
	public static void turn(int n)
	{
		top(n);
		left(n);
		right(n);
		bottom(n);
	}
	public static void init() throws Exception
	{
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		R = stoi(st.nextToken());
		
		arr = new int[N][M];
		brr = new int[N][M];
		
		for(int i = 0 ; i < N ; i++)
		{
			st=new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++)
				arr[i][j] = stoi(st.nextToken());
		}
	}
	public static void top(int y)
	{
		for(int i = 1+y ; i < M-y ; i++)
			brr[y][i-1] = arr[y][i]; 
	}
	public static void bottom(int y)
	{
		for(int i = 1+y ; i < M-y ; i++)
			brr[N-1-y][i] = arr[N-1-y][i-1];
	}
	public static void left(int x)
	{
		for(int i = 1+x ; i < N-x ; i++)
			brr[i][x] = arr[i-1][x];
	}
	public static void right(int x)
	{
		for(int i = 0+x ; i < N-1-x ; i++)
			brr[i][M-1-x] = arr[i+1][M-1-x];
	}
}
