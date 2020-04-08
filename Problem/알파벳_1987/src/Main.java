import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static int R,C;
	public static char[][] arr;
	public static boolean[] visited;
	public static int maximum = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//parsing
		String[] input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		
		//init
		arr = new char[R][C];
		visited = new boolean['Z'-'A' + 1];
		
		//input
		for(int i = 0 ; i < R ; i++)
		{
			String tmp = br.readLine();
			for(int j = 0 ; j < C ; j++)
			{
				arr[i][j] = tmp.charAt(j);
			}
		}
		
		//logic
		dfs(0,0,1);
		
		//print
		bw.write(String.valueOf(maximum));
		bw.flush();
		bw.close();
	}
	public static int dy[] = { -1 , 0 , 1 , 0 };
	public static int dx[] = {  0,  1 , 0 ,-1 };
	public static void dfs(int y, int x ,int cnt)
	{
		if(cnt > maximum) maximum = cnt;
		visited[arr[y][x] - 'A'] = true;
		for(int i = 0 ; i < 4 ; i++)
		{
			int ty = dy[i] + y;
			int tx = dx[i] + x;
			if(0 <= ty && ty < R && 0 <= tx && tx < C && !visited[arr[ty][tx] - 'A'])
			{
				dfs(ty,tx,cnt+1);
				visited[arr[ty][tx] - 'A'] = false;
			}
		}
		
	}
}
