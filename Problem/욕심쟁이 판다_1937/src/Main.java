import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int N;
	public static int[][] arr, dp;
	public static int stoi(String str) { return Integer.parseInt(str); }
	public static boolean DEBUG = false;
	public static int solv = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception
	{
		N = stoi(br.readLine());
		arr = new int[N][N];
		dp = new int[N][N];
		
		for(int i = 0 ; i < N ; i ++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++)
			{
				arr[i][j] = stoi(st.nextToken());
			}
		}
		
		for(int i = 0 ; i < N ; i++)
		{
			for(int j  = 0 ; j < N ; j++)
			{
				if(dp[i][j] == 0)
				{
					solv = Math.max(solv, dp[i][j] = dfs(i,j));
					if(DEBUG)
					{
						System.out.println("-------------------------------------------");
						for(int a = 0 ; a < N ; a++)
						{
							for(int b  = 0 ; b < N ; b++)
							{
								System.out.print(dp[a][b] + " ");
							}
							System.out.println();
						}
						
					}
				}
			}
		}
		bw.write(String.valueOf(solv));
		bw.flush();
		bw.close();
	}
	public static int[] dy = { -1, 0, 1, 0 };
	public static int[] dx = {  0, 1, 0,-1 };
	public static int dfs(int y , int x)
	{
		int val = 1;
		
		for(int i = 0 ; i < dy.length ; i++)
		{
			int ty = dy[i] + y;
			int tx = dx[i] + x;
			if(0 <= ty && ty < N && 0 <= tx && tx < N && arr[y][x] < arr[ty][tx])
			{
				if(dp[ty][tx] > 0)
					val = dp[ty][tx] + 1;
				else
					val = dfs(ty,tx) +1;
				dp[y][x] = Math.max(dp[y][x], val);
			}
		}
		if(val == 1)
			dp[y][x] = val;
		return dp[y][x];
	}

}
