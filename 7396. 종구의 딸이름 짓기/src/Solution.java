import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tNum = 1 ; tNum <= T ; tNum++)
		{
			int N,M;
			N = sc.nextInt();
			M = sc.nextInt();
			
			String[][] arr = new String[N][M];
			
			for(int i = 0 ; i < N ; i++)
			{
				String str = sc.next();
				for(int j = 0 ; j < M ; j++)
				{
					arr[i][j] = str.charAt(j)+"";
				}
			}
			
			System.out.println("#"+tNum+" "+bfs(arr,new Pos(0,0,arr[0][0]),N,M));
		}
	}
	public static int[] dy = { 0, 1 };
	public static int[] dx = { 1, 0 };
	public static String bfs(String[][] arr,Pos p, int N, int M)
	{
		Queue<Pos> q = new LinkedList<>();
		ArrayList<Pos> list2 = new ArrayList<>(); 
		q.add(p);
		Pos pos = null;
		while(!q.isEmpty())
		{
			pos = q.poll();
//			System.out.println(pos);
			if(pos.y == N-1 && pos.x == M-1)
			{
				list2.add(pos);
				continue;
			}
			StringBuilder tmpStr = new StringBuilder();
			int cnt = 1;
			
			ArrayList<Pos> list = new ArrayList<>(); 
			for(int i = 0 ; i < 2 ; i++)
			{
				int ty = dy[i] + pos.y;
				int tx = dx[i] + pos.x;
				if(ty < N && tx < M)
				{
					if(tmpStr.equals(""))
						tmpStr.append(pos.sb).append(arr[ty][tx]);
					else if(tmpStr.equals(pos.sb.toString() + arr[ty][tx]))
						cnt++;
					list.add(new Pos(ty,tx,pos.sb.toString() + arr[ty][tx]));
				}
			}
			Collections.sort(list);
			
			for(int i = 0 ; i < cnt ; i++)
				q.add(list.get(i));
		}
		Collections.sort(list2);
		
		return list2.get(0).sb.toString();
	}
	public static class Pos implements Comparable<Pos>
	{
		int y,x;
		StringBuilder sb;
		Pos(int y,int x, String str)
		{
			this.y=y;
			this.x=x;
			this.sb=new StringBuilder(str);
		}
		@Override
		public int compareTo(Pos o) {
			return this.sb.toString().compareTo(o.sb.toString());
		}
		@Override
		public String toString() {
			return "Pos [y=" + y + ", x=" + x + ", str=" + sb + "]";
		}
	}

}
