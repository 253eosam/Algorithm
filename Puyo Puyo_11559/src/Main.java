import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static boolean DEBUG = false;
	public static int N,M;
	public static char[][] arr;
	public static boolean[][] remove;
	public static boolean[][] visited;
	public static int cnt = 0;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = 12 ;
		M = 6 ;
		arr = new char[N][M];
		remove = new boolean[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0 ; i < N ; i++)
		{
			String tmp = sc.nextLine();
			arr[i] = tmp.toCharArray();
		}
		
		//연쇄삭제
		while(true)
		{
			boolean pass = false; boolean reGame = false;
			
			// 뿌요찾기
			for(int i = 0 ; i < N ; i++)
			{
				for(int j = 0 ; j < M ; j++)
				{
					if(remove[i][j] || arr[i][j] == '.') continue;
					visited = new boolean[N][M];
					if(checkDfs(i,j, arr[i][j]) >= 4)
					{
						visited = new boolean[N][M];
						dfs(i,j,arr[i][j],1);
						reGame = true;
					}
				}
			}
			
			if(!reGame)
				break;
			
			// 제거
			for(int i = 0 ; i < M ; i++)
			{
				Queue<Character> q = new LinkedList<>();
				for(int j = N-1 ; j >= 0 ; j--)
				{
					if(!remove[j][i] && arr[j][i] != '.')
						q.add(arr[j][i]);
				}
				
				int cnt = N-1;
				while(!q.isEmpty())
				{
					arr[cnt--][i] = q.poll();
				}
				while(cnt >= 0)
				{
					arr[cnt--][i] = '.';
				}
			}
			remove = new boolean[N+1][M+1];
			cnt++;
			
			if(DEBUG)
			{
				System.out.println();
				for(int i = 0 ; i < N ; i++)
				{
					for(int j = 0 ; j < M ; j++) 
					{
						System.out.print(arr[i][j] + " ");
					}
					System.out.println();
				}
				System.out.println();
			}
		}//while
		System.out.println(cnt);
	}
	
	public static int[] dy = { -1 , 0 , 1 , 0 };
	public static int[] dx = { 0, 1 ,0 ,-1 };
	public static void dfs(int y, int x,char alpha , int depth)
	{
//		System.out.println("y : " + y + " x : " + x + " depth : " + depth + " arr :" + arr[y][x]);
		remove[y][x] = true;
		visited[y][x] = true;
		for(int i = 0 ; i < 4 ; i++)
		{
			int ty = dy[i] + y;
			int tx = dx[i] + x;
			
			if(0 <= ty && ty < N && 0 <= tx && tx < M
					&& arr[ty][tx] == alpha && !visited[ty][tx])
			{
				dfs(ty,tx,alpha,depth+1);
			}
		}
	}
	public static int checkDfs(int y, int x, char alpha)
	{
		int val = 1;
		visited[y][x] = true;
		for(int i = 0 ; i < 4 ; i++)
		{
			int ty = dy[i] + y;
			int tx = dx[i] + x;
			
			
			if(0 <= ty && ty < N && 0 <= tx && tx < M
					&& arr[ty][tx] == alpha && !visited[ty][tx])
			{
				val += checkDfs(ty,tx,alpha);
			}
		}
		return val;
	}
	
	

}
