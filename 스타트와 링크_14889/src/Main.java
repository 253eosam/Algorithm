import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static Scanner sc = new Scanner(System.in);
	public static int N;
	public static int[][] arr;
	public static int min = Integer.MAX_VALUE;
	public static ArrayList<Integer> pick;
	public static void main(String[] args) {
		N = sc.nextInt();
		pick = new ArrayList<>();
		for(int i = 0 ; i < N/2 ; i++)
			pick.add(0);
		
		arr = new int[N][N];
		
		for(int i = 0 ; i < N ; i++)
		{
			for(int j = 0 ; j < N ; j++)
			{
				arr[i][j] = sc.nextInt();
			}
		}
		
		com(N/2,0,0);
		
		System.out.println(min);
	}//main
	
	public static void com(int target , int deep, int cur)
	{
		if(deep == target)
		{
			int sTeam , lTeam;
			sTeam = lTeam = 0;
			ArrayList<Integer> noPick = new ArrayList<>();
			for(int i = 0 ; i < N ; i++)
				if(!pick.contains(i))
					noPick.add(i);
			
			for(int i : pick)
			{
				for(int j : pick)
				{
					if(i == j) continue;
					sTeam += arr[i][j];
				}
			}
			
			for(int i : noPick)
			{
				for(int j : noPick)
				{
					if(i == j) continue;
					lTeam += arr[i][j];
				}
			}
			
			min = Math.min(min, Math.abs(sTeam-lTeam));
			
			return;
		}// if return
		
		for(int i = cur ; i < N ; i++)
		{
			pick.set(deep, i);
			com(target,deep+1,i+1);
		}
		
	}//combination

}
