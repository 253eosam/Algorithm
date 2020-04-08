import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int N,M,K;
	public static int[][] arr,brr,crr;
	public static int[] r,c,s,prr;
	public static int min;
	public static int stoi(String str) { return Integer.parseInt(str); }
	public static void copyArr(int[][] c, int[][] in)
	{
		for(int i = 0 ; i < N ; i++)
		{
			for(int j = 0 ; j < M ; j++)
			{
				c[i][j] = in[i][j];
			}
		}
	}
	public static void init() throws Exception
	{
		 st=new StringTokenizer(br.readLine());
		 N = stoi(st.nextToken());
		 M = stoi(st.nextToken());
		 K = stoi(st.nextToken());
		 
		 min = Integer.MAX_VALUE;
		 arr = new int[N][M];
		 brr = new int[N][M];
		 crr = new int[N][M];
		 
		 for(int i = 0 ; i < N ; i ++)
		 {
			 st=new StringTokenizer(br.readLine());
			 for(int j = 0 ; j < M ; j++)
			 {
				 arr[i][j] = stoi(st.nextToken());
				 crr[i][j] = brr[i][j] = arr[i][j];
			 }
		 }
		 
		 r = new int[K];
		 c = new int[K];
		 s = new int[K];
		 prr= new int[K];
		 for(int i = 0 ; i < K ; i++)
		 {
			 st=new StringTokenizer(br.readLine());
			r[i] = stoi(st.nextToken()); 
			c[i] = stoi(st.nextToken()); 
			s[i] = stoi(st.nextToken());
			prr[i] = i;
		 }
	}
	public static void main(String[] args) throws Exception 
	{
		init();
		logic();
		print();
	}
	private static void print() throws IOException {
		bw.write(String.valueOf(min));
		bw.flush();
	}
	private static void logic() {
		permutation(0, K);
	}
	public static void testB()
	{
		for(int i = 0 ; i < N ; i++)
		{
			for(int j = 0  ; j < M ; j++)
			{
				System.out.print(brr[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void testA()
	{
		for(int i = 0 ; i < N ; i++)
		{
			for(int j = 0  ; j < M ; j++)
			{
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void rowCalculation()
	{
		for(int i = 0 ; i < N ; i++)
		{
			int sum = 0;
			for(int j = 0  ; j < M ; j++)
			{
				sum+=brr[i][j];
			}
			min = Math.min(min, sum);
		}
	}
	private static void turnCnt(int sy,int sx, int ty, int tx, int c) {
		while(c-- > 0)
		{
			for(int i = 0 ; i < Math.min(ty-sy+1,tx-sx+1 )/2 ; i++)
				turn(sy,sx,ty,tx,i);
			
			copyArr(arr, brr);
		}
		
	}
	public static void turn(int sy,int sx, int ty, int tx, int n)
	{
		sy += n;
		sx += n;
		ty -= n;
		tx -= n;
		
		top(sy, sx, ty, tx);
		bottom(sy, sx, ty, tx);
		left(sy, sx, ty, tx);
		right(sy, sx, ty, tx);
		// 시계방향
	}
	public static void top(int sy,int sx, int ty, int tx)
	{
		for(int i = sx+1 ; i <= tx ; i++)
			brr[sy][i] = arr[sy][i-1];
	}
	public static void bottom(int sy,int sx, int ty, int tx)
	{
		for(int i = sx ; i <= tx-1 ; i++)
			brr[ty][i] = arr[ty][i+1];
	}
	public static void left(int sy,int sx, int ty, int tx) // ^
	{
		for(int i = sy ; i <= ty-1 ; i++)
			brr[i][sx] = arr[i+1][sx];
	}
	public static void right(int sy,int sx, int ty, int tx) // V
	{
		for(int i  = sy+1 ; i <= ty ; i++)
			brr[i][tx] = arr[i-1][tx];
	}
	public static void permutation(int idx , int n)
	{
		if(idx == n)
		{
			for(int i = 0 ; i < n ; i++)
			{
				int num = prr[i];
				int sy = r[num] - s[num]-1;
				int sx = c[num] - s[num]-1;
				int ty = r[num] + s[num]-1;
				int tx = c[num] + s[num]-1;
				
				turnCnt(sy, sx, ty, tx, 1);
				
			}
			rowCalculation();
			copyArr(brr,crr);
			copyArr(arr,crr);
			return;
		}
		
		for(int i = idx ; i < n ; i++)
		{
			swap(i,idx);
			permutation(idx+1, n);
			swap(i,idx);
		}
	}
	public static void swap(int a, int b)
	{
		int tmp = prr[a];
		prr[a]=prr[b];
		prr[b]=tmp;
	}

}
