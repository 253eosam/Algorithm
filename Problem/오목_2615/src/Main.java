
import java.util.Scanner;

public class Main 
{
	public static final int N = 19;
	public static int[][] arr;
	public static Scanner sc= new Scanner(System.in); 
	public static int targetY, targetX,solv;
	public static boolean[][] visited;
	public static boolean pass = false;
	public static void main(String[] args)
	{
		init();
		logic();
//		test();
		print();
	}
	private static void print() {
		if(solv == 0)
		{
			System.out.println(solv);
			return;
		}
		System.out.println(solv);
		
		for(int i = 0 ; i < N ; i++)
		{
			for(int j = 0 ; j < N ; j++)
			{
				if(arr[j][i] == 3)
				{
					System.out.println((j+1) + " " + (i+1));
					return;
				}
			}
		}
		
	}
	public static void test()
	{
		for(int i = 0 ; i < N ; i++)
		{
			for(int j = 0 ; j < N ; j++)
			{
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static int[] dy = {0, -1,1, -1,1,  -1, 1,  0,0 };
	public static int[] dx = {0, -1,1,  0,0,   1,-1,  1,-1 };
	private static void logic() {
		for(int i = 0 ; i < N ; i++)
		{
			for(int j = 0 ; j < N ; j++)
			{
				if(arr[i][j] == 0) continue;
				for(int dir = 1 ; dir < dy.length ; dir = dir+2)
				{
					int sum = 0;
					for(int d = dir ; d <= dir+1 ; d++)
					{
						sum += dfs(i,j,d,arr[i][j]);
					}
					
					if(sum == 6)
					{
						solv = arr[i][j];
						for(int d = dir ; d <= dir+1 ; d++)
						{
							dfs2(i,j,d,solv);
						}
						return;
					}
				}
			}
		}
	}
	private static void dfs2(int y, int x, int dir, int val) 
	{
		int ty = dy[dir] + y;
		int tx = dx[dir] + x;
		arr[y][x]= 3;
		if(0 <= ty && ty < N && 0 <= tx && tx < N && val == arr[ty][tx])
		{
			dfs2(ty,tx,dir,val);
		}
	}
	private static int dfs(int y, int x, int dir , int val)
	{
		int sum = 1;
		int ty = dy[dir] + y;
		int tx = dx[dir] + x;
		
		if(0 <= ty && ty < N && 0 <= tx && tx < N && val == arr[ty][tx])
		{
			sum += dfs(ty,tx,dir,val);
		}
		return sum;
	}
	public static void init()
	{
		arr=new int[N][N];
		visited=new boolean[N][N];
		solv = 0;
		for(int i = 0 ; i < N ; i++)
		{
			for(int j = 0 ; j < N ; j++)
			{
				arr[i][j] = sc.nextInt();
			}
		}
	}
}
