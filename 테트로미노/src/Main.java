import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static final int MAX_SIZE = 500;
	public static int[][] arr = new int[MAX_SIZE][MAX_SIZE];
	public static boolean[][] visit = new boolean[MAX_SIZE][MAX_SIZE];
	public static int N, M;
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 0 ; i < N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;
		for(int i = 0 ; i < N ; i++)
		{
			for(int j = 0 ; j < M ; j++)
			{
				visit[i][j] = true;
				ans = Math.max(ans, dfs(j,i,1));
				ans = Math.max(ans, dfs(ty,tx,cnt+1)+arr[y][x]);
			}
		}
		
	}//main
	
	public static int[] dy = { 0, 1,  0,-1 };
	public static int[] dx = { 1, 0, -1, 0 };
	
	public static int dfs(int y , int x , int cnt)
	{
		int ans = 0;
		if(cnt == 5)
			return ans;
		for(int i = 0 ; i < 4 ; i++)
		{
			int ty = y + dy[i];
			int tx = x + dx[i];
			if(
					0 <= ty && ty <= N && 
					0 <= tx && tx <= M && 
					!visit[ty][tx])
			{
				visit[ty][tx] = true;
				ans = Math.max(ans, dfs(ty,tx,cnt+1)+arr[y][x]);
				visit[ty][tx] = false;
			}//if arr
		}
		return ans;
	}//dfs

}
