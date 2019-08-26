import java.util.Scanner;

public class Main {
	public static int N,M;
	public static int[][] arr;
	public static int[] parent;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//init
		N = sc.nextInt();	//도시 수
		M = sc.nextInt();	//도시 계획 수
		parent = new int[N+1];
		arr = new int[N+1][N+1];
		makeSet();
		
		//input
		for(int i = 1 ; i <= N ; i++)
		{
			for(int j = 1; j <= N ; j++)
			{
				arr[i][j] = sc.nextInt();
				if(arr[i][j] == 1)
					unionSet(i,j);
			}
		}
		
		int p = sc.nextInt();
		boolean pass = true;
		for(int i = 1 ; i < M ; i++)
		{
			int tmp = sc.nextInt();
			if(findSet(p) != findSet(tmp))
			{
				pass = false;
			}
		}
		if(pass)
			System.out.println("YES");
		else
			System.out.println("NO");
		
		
	}
	public static void makeSet()
	{
		for(int i = 1 ; i < N ; i++)
			parent[i] = i;
	}
	public static int findSet(int x)
	{
		if(parent[x] == x) return x;
		return parent[x] = findSet(parent[x]);
	}
	public static void unionSet(int x, int y)
	{
		int tx = findSet(x);
		int ty = findSet(y);
		if(tx != ty)
			parent[ty] = tx;
	}
}
