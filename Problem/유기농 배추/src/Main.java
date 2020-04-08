import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static final boolean DEBUG = false;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tNum = 1; tNum <= T; tNum++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[N][M];
			int[][] visit = new int[N][M];
			for(int i = 0 ; i < K ; i++)
			{
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr[y][x] = 1;
			}
			
			int cnt = 0;
			for(int i = 0 ; i < N ; i++)
			{
				for(int j = 0 ; j < M ; j++)
				{
					if(arr[i][j] == 1 && visit[i][j] == 0)
					{
						dfs(arr,visit,i,j);
						cnt++;
					}
				}
			}
			
			bw.write(cnt + "\n");
			
			if(DEBUG)
			{
				for(int i = 0 ; i < N ; i++)
				{
					for(int j = 0 ; j < M; j++)
						System.out.print(arr[i][j] + " ");
					System.out.println();
				}
			}
			
			
		}//for tNum
		bw.flush();
		bw.close();
	}
	public static void dfs(int[][]arr, int[][] visit, int y, int x)
	{
		visit[y][x] = 1;
		
		// > V < ^
		int[] dy = { 0, 1, 0, -1 };
		int[] dx = { 1, 0,-1,  0 };
		
		for(int i = 0 ; i < 4 ; i++)
		{
			int ty = dy[i] + y;
			int tx = dx[i] + x;
			if(0 <= ty && ty < arr.length &&
					0 <= tx && tx < arr[0].length &&
					arr[ty][tx] == 1 && visit[ty][tx] == 0)
			{
				dfs(arr,visit,ty,tx);
			}
		}
	}

}
