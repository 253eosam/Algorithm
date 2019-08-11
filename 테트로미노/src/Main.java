import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static final int MAX_SIZE = 500;
	public static int[][] arr = new int[MAX_SIZE][MAX_SIZE];
	public static int N, M;
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		boolean[][] visit = new boolean[MAX_SIZE][MAX_SIZE];
		for(int i = 0 ; i < N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int maximum = 0;
		for(int i = 0 ; i < N ; i++)
		{
			for(int j = 0 ; j < M ; j++)
			{
				int tmp = dfs(visit,i,j,1,0);
				if(maximum < tmp)
					maximum = tmp;
				int noShapeMaximum = noShape(i,j);
				maximum = maximum > noShapeMaximum ? maximum : noShapeMaximum; 
			}
		}
		bw.write(Integer.toString(maximum));
		bw.flush();
		bw.close();
	}//main
	
	public static int noShape(int y, int x )
	{
		int sum = 0;
		
		int top,left,right;
		
		//위
		top = y-1; left = x-1 ; right = x+1;
		int north = arr[y][x];
		if(0 <= top && 0 <= left && right < M)
		{
			north += arr[top][x];
			north += arr[y][left] + arr[y][right];
		}
		sum = Math.max(sum, north);
		
		//오른쪽
		top = x+1; left = y-1 ; right = y+1;
		int east = arr[y][x];
		if(0 <= left && right < N && top < M)
		{
			east += arr[y][top];
			east += arr[left][x] + arr[right][x];
		}
		sum = Math.max(sum, east);
		
		//아래
		top = y+1; left = x+1 ; right = x-1;
		int south = arr[y][x];
		if(top < N && left < M && 0 <= right)
		{
			south += arr[top][x];
			south += arr[y][right] + arr[y][left];
		}
		sum = Math.max(sum, south);
		
		//왼쪽
		top = x-1; left = y+1 ; right = y-1;
		int west = arr[y][x];
		if(0 <= top && left < N && 0 <= right)
		{
			west += arr[y][top];
			west += arr[left][x] + arr[right][x];
		}
		sum = Math.max(sum, west);
		
		return sum;
	}
	public static int[] dy = { 0, 1,  0,-1 };
	public static int[] dx = { 1, 0, -1, 0 };
	public static int dfs(boolean[][] visit , int y , int x , int cnt , int sum)
	{
		sum += arr[y][x];
		visit[y][x] = true;
		if(cnt == 4)
			return sum;
		int maximum = sum;
		for(int i = 0 ; i < 4 ; i++)
		{
			int ty = dy[i] + y;
			int tx = dx[i] + x;
			if(0 <=  ty && ty < N && 0 <= tx && tx < M && !visit[ty][tx])
			{
				int tmp = dfs(visit,ty,tx,cnt+1,sum);
				if(maximum < tmp)
					maximum = tmp;
				visit[ty][tx]=false;
			}
		}
		visit[y][x] = false;
		return maximum;
	}
	

}