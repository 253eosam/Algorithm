import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static Scanner sc = new Scanner(System.in);
	public static int N,M,T;
	public static int[][] arr;
	public static int[] x,d,k;
	public static int solv;
	public static void main(String[] args) {
		N = sc.nextInt();
		M = sc.nextInt();
		T = sc.nextInt();

		arr = new int[N+1][M+1];

		for(int i = 1 ; i <= N ; i++)
		{
			for(int j = 1 ; j <= M ; j++)
			{
				arr[i][j] =sc.nextInt();
			}
		}

		x = new int[T];
		d = new int[T];
		k = new int[T];


		for(int i = 0 ; i < T ; i++)
		{
			x[i] = sc.nextInt();
			d[i] = sc.nextInt();
			k[i] = sc.nextInt();
		}

		for(int k = 0 ; k < T ; k++)
		{
			
			turn(k);
			visited = new boolean[N+1][M+1];
			for(int a = 1 ; a <= N ; a++)
			{
				for(int b = 1; b <= M ; b++)
				{
					if(!visited[a][b])
						remove(a, b);
				}
			}
			boolean pass = false;
			for(int i = 1 ; i <= N ; i++)
			{
				for(int j = 1 ; j <= M ; j++)
				{
					if(visited[i][j])
					{
						pass = true;
						arr[i][j] = 0;
					}
				}
			}
			solv = 0;
			int cnt = 0;
			//print
//			System.out.println("pass : " + pass);
			for(int i = 1 ; i <= N ; i++)
			{
				for(int j = 1 ; j <= M ; j++)
				{
					if(arr[i][j] != 0)
					{
//						System.out.print(arr[i][j] + " ");
						solv += arr[i][j];
						cnt++;
					}
				}
//				System.out.println();
			}

//			System.out.println("solv : " + solv);
			if(!pass)
			{
				double avg = solv / cnt;

				for(int i = 1 ; i <= N ; i++)
				{
					for(int j = 1 ; j <= M ; j++)
					{
						if(arr[i][j] != 0)
						{
							if(avg < arr[i][j])
								 --arr[i][j];
							else if(avg > arr[i][j])
								 ++arr[i][j];
						}
					}
				}
			}
//			System.out.println();
//			System.out.println();
			print(pass);
		}

		System.out.println(solv);
	}
	public static void print(boolean pass)
	{
		System.out.println("pass : " + pass);
		for(int i = 1 ; i <= N ; i++)
		{
			for(int j = 1; j <= M ; j++)
			{
				if(arr[i][j] == 0)
					System.out.print("x ");
				else
					System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void turn(int cnt)
	{
		for(int i = 1; i <= N ; i++)
		{
			if(i % x[cnt] == 0)
			{
				if(d[cnt] == 0)	// 시계방향
				{
					for(int ti = 0 ; ti < k[cnt] ; ti++)
					{
						for(int j = M ; j > 0 ; j--)
						{
							if(j == M)
								arr[i][0] = arr[i][j];
							else
								arr[i][j+1] = arr[i][j];
						}
						arr[i][1] = arr[i][0];
						arr[i][0] = 0;
					}
				}
				else	//반시계 방향
				{
					for(int ti = 0 ; ti < k[cnt] ; ti++)
					{
						for(int j = 1 ; j <= M ; j++)
						{
							arr[i][j-1] = arr[i][j];
						}
						arr[i][M] = arr[i][0];
						arr[i][0] = 0;
					}
				}
			}
		}
	}
	public static int[] dy = { -1,0,1,0 };
	public static int[] dx = { 0,1,0,-1 };
	public static class Data
	{
		int y,x,val;
		Data(int y , int x , int val)
		{
			this.x=x;
			this.y=y;
			this.val=val;
		}
	}
	public static boolean visited[][];
	public static void remove(int y, int x)
	{
		if(arr[y][x] == 0) return;
		
		Queue<Data> q = new LinkedList<>();
		q.add(new Data(y,x,arr[y][x]));
		while(!q.isEmpty())
		{
			Data cur = q.poll();

			for(int i = 0 ; i < 4 ; i++)
			{
				int ty = dy[i] + cur.y;
				int tx = dx[i] + cur.x;
				if(1 <= ty && ty <= N)
				{
					if(tx == 0)
						tx = M;
					else if(tx == M+1)
						tx = 1;
					if(!visited[ty][tx] && arr[ty][tx] == cur.val)
					{
						visited[ty][tx] = true;
						q.add(new Data(ty,tx,cur.val));
					}
				}
			}
		}


	}

}
