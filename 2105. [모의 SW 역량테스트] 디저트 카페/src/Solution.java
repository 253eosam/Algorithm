import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution 
{
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int N;
	public static int[][] arr;
	public static int MAX;
	public static void main(String[] args) throws Exception
	{
		int T = Integer.parseInt(br.readLine());

		for(int tNum = 1 ; tNum <= T ; tNum++)
		{
			init();

			bruteForce();

			bw.write("#"+tNum+" ");
			if(MAX == Integer.MIN_VALUE)
				bw.append("-1\n");
			else
				bw.append(MAX+"\n");
		}//for tNum
		bw.close();
	}//main
	public static void bruteForce()
	{
		for(int i = 0 ; i < N ; i++)
		{
			for(int j = 0 ; j < N ; j++)
			{
//				System.out.print("\n\nstarting !!");
				visited = new boolean[N][N];
				HashSet<Integer> set = new HashSet<>();
				set.add(arr[i][j]);
				visited[i][j] = true;
				dfs(set, i,j,i,j,0);
				visited[i][j] = false;
			}
//			System.out.println();
		}
	}
	public static int[] dy = { 1,1,-1,-1 };
	public static int[] dx = { -1,1,1,-1 };
	public static boolean[][] visited;
	public static void dfs(HashSet<Integer> set, int sy, int sx, int y, int x, int dir)
	{
//		System.out.println();
//		for(int i = 0 ; i < N ; i++)
//		{
//			for(int j = 0 ; j < N ; j++)
//			{
//				if(i == y && j == x)
//					System.out.print("X" + " ");
//				else System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println(set);
		if(sy == y && sx == x && set.size() >= 4)
		{
			MAX = Math.max(MAX,set.size());
//			System.out.println("here ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~``");
			return;
		}
		
		for(int i = dir ; i < 4 ; i++)
		{
			int ty = dy[i] + y;
			int tx = dx[i] + x;
			if(ty == sy && tx == sx )
				dfs(set,sy,sx,ty,tx,i);
			if(0 <= ty && ty < N && 0 <= tx && tx < N && !visited[ty][tx] && !set.contains(arr[ty][tx]))
			{
				int val = arr[ty][tx];
				visited[ty][tx] = true;
				set.add(val);
				dfs(set,sy,sx,ty,tx,i);
				visited[ty][tx] = false;
				set.remove(val);
			}
		}
	}
	public static void init() throws IOException
	{
		MAX = Integer.MIN_VALUE;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i = 0 ; i < N ; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}//init
}
