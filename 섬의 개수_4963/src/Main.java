import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int h,w;
	public static boolean[][] visited, arr;
	public static void main(String[] args) throws Exception
	{
		
		while(true)
		{
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w == 0 && h == 0) break;
			arr=new boolean[h][w];
			visited=new boolean[h][w];
			
			for(int i = 0 ; i < h ; i++)
			{
				st= new StringTokenizer(br.readLine());
				for(int j = 0 ; j < w ; j++)
				{
					arr[i][j] = (Integer.parseInt(st.nextToken()) == 1);
				}
			}

			int solv = 0;
			for(int i = 0 ; i < h ; i++)
			{
				for(int j = 0 ; j < w ; j++)
				{
					if(!visited[i][j] && arr[i][j])
					{
						dfs(i,j);
						solv++;
					}
				}
			}
			
			bw.write(String.valueOf(solv) + "\n");
		}
		bw.close();
		
	}
	public static int[]	dy = { -1 , -1, -1, 0 , 0, 1, 1, 1};
	public static int[]	dx = { -1, 0 , 1, -1, 1, -1, 0, 1 };
	public static void dfs(int y, int x)
	{
		if(visited[y][x]) return;
		visited[y][x] = true;
		
		for(int i = 0 ; i < dy.length ; i++)
		{
			int ty = dy[i] + y;
			int tx = dx[i] + x;
			if(0 <= ty && ty < h && 0 <= tx && tx < w && arr[ty][tx])
				dfs(ty,tx);
		}
	}

}
