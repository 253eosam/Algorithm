import java.util.Scanner;
import java.util.Stack;


public class Solution {
	public static class Index
	{
		int i;
		int j;
		public Index(int _i, int _j)
		{
			i = _i;
			j = _j;
		}
	}
	
	public static Index dfs(Index index)
	{
		visit[index.i][index.j] = 1;
		while(index.i != 0)
		{
			if(index.i == 0)
				break;
			if(arr[index.i][index.j+1] == 1 && visit[index.i][index.j+1] == 0)
			{
				visit[index.i][index.j+1] = 1;
				index.j++;
			}
			else if(arr[index.i][index.j-1] == 1 && visit[index.i][index.j-1] == 0)
			{
				visit[index.i][index.j-1] = 1;
				index.j--;
			}
			else
			{
				visit[index.i-1][index.j] = 1;
				index.i--;
			}
			
		
		}
		return new Index(index.i,index.j);
		

		
	}
	
	static int MAX_SIZE = 100;
	static int[][] arr = new int[MAX_SIZE][MAX_SIZE+2];
	static int[][] visit = new int[MAX_SIZE][MAX_SIZE+2];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for(int tNum = 1; tNum < T; tNum++)
		{
			sc.nextInt();
			for(int i = 0 ; i < MAX_SIZE; i++)
			{
				for(int j = 1 ; j <= MAX_SIZE; j++)
				{
					arr[i][j] = sc.nextInt();
				}
			}

			for(int i = 1 ; i <= MAX_SIZE; i++)
			{
				if(arr[MAX_SIZE][i] == 2) 
				{
					Index in = dfs(new Index(MAX_SIZE,i));
					System.out.println("fdsf : " + in.j);
				}
			}
			
			
			
			
			
		}
		
		
	}

}
