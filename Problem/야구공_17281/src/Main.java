import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main 
{
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int stoi(String str) { return Integer.parseInt(str); }
	public static int[][] arr;
	public static int[] brr,crr;
	public static boolean[] ground;
	public static final int N = 9;
	public static int T;
	public static int maximum, point;
	public static void main(String[] args) throws Exception 
	{
		init();
		logic();
		print();
	}
	private static void print() throws IOException {
		bw.write(String.valueOf(maximum));
		bw.flush();
	}
	public static void copy()
	{
		for(int i = 0 ; i < N ; i++)
			crr[i] = brr[i];
		int tmp = crr[3];
		crr[3] = 0;
		crr[0] = tmp;
	}
	public static void game()
	{
		int index = 0;
		point = 0;
		
		copy();
		for(int t  = 0 ; t < T ; t++)
		{
			int cnt = 3;
			ground = new boolean[5];
			while(true)
			{
				index %= N;
				if(arr[t][crr[index]] == 0)
				{
					if(--cnt == 0) 
					{
						index++;
						break;
					}
				}
				else if(arr[t][crr[index]] == 4)
				{
					for(int i = 1 ; i <= 3 ; i++)
						if(ground[i])
							point++;
					ground = new boolean[5];
					point++;
				}
				else 
				{
					moving(arr[t][crr[index]]);
				}
				index++;
			}
		}
		if(maximum < point)
		{
			for(int i = 0 ; i < N ; i++)
				System.out.print(crr[i]+" ");
			System.out.println("max : " + point);
		}
		maximum = Math.max(maximum, point);
	}
	public static void moving(int val)
	{
		for(int i = 1 ; i <= val ; i++)
		{
			int tmp = i + val;
			while(ground[tmp])
			{
				ground[tmp++] = false;
			}
			if(tmp >= 4)
				point++;
			else
				ground[tmp] = true;
		}
	}
	private static void logic() 
	{
		permutation(1,N);
	}
	public static void test()
	{
		System.out.println();
		for(int i = 0 ; i < N ; i++)
			System.out.print(crr[i] + " ");
		System.out.println();
	}
	private static void permutation(int idx, int target)
	{
		if(idx == target)
		{
			game();
			return;
		}
		
		for(int i = idx ; i < target ; i++)
		{
			swap(i,idx);
			permutation(idx + 1, target);
			swap(i,idx);
		}
	}
	public static void swap( int a,int b)
	{
		int tmp = brr[a];
		brr[a] = brr[b];
		brr[b] = tmp;
	}
	public static void init() throws Exception
	{
		T = stoi(br.readLine());
		maximum = Integer.MIN_VALUE;
		arr = new int[N][N];
		brr = new int[N];
		crr = new int[N];
		
		for(int i = 0 ; i < N ; i++)
			brr[i] = i;
		for(int i = 0 ; i < T ; i++)
		{
			st=new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ;j++)
			{
				arr[i][j] = stoi(st.nextToken());
			}
		}
		
	}

}
