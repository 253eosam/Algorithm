import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int N;
	public static int[][] arr;
	public static boolean[][] visited;
	public static int MINIMUM = Integer.MAX_VALUE;
	public static boolean DEBUG = true;
	public static void main(String[] args) throws Exception 
	{
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0 ; i < N ; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt=1;
		for(int i = 0 ; i < N ; i++)
		{
			for(int j = 0 ; j < N ; j++)
			{
				if(arr[i][j] > 0 && !visited[i][j])
					bfs(new Data(i,j),cnt++);
			}
		}// 섬 나누고
		
		
		// 다리 연결
		for(int i = 0 ; i < N ; i++)
		{
			for(int j = 0 ; j < N ; j++)
			{
				if(arr[i][j] > 0)
				{
					visited = new boolean[N][N];
					connection(new Data(i,j,0),arr[i][j]);
				}
			}
		}
		if(DEBUG)
		{
			System.out.println();
			for(int i = 0 ; i < N ; i++)
			{
				for(int j = 0 ; j < N ; j++)
				{
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
		bw.write(String.valueOf(MINIMUM-1));
		bw.flush();
		bw.close();
	}
	public static void connection(Data start, int num)
	{
		Queue<Data> q = new LinkedList<>();
		q.add(start);
		visited[start.y][start.x] = true;
		Data pos;
		while(!q.isEmpty())
		{
			pos = q.poll();
			
			if(arr[pos.y][pos.x] != 0 && arr[pos.y][pos.x] != num)
			{
				MINIMUM = Math.min(MINIMUM, pos.cnt);
				break;
			}
			
			for(int i = 0 ; i < 4 ; i++)
			{
				int ty = dy[i] + pos.y;
				int tx = dx[i] + pos.x;
				if(0 <= ty && ty < N && 0 <= tx && tx <N && !visited[ty][tx] && arr[ty][tx] != num)
				{
					visited[ty][tx] = true;
					q.add(new Data(ty,tx,pos.cnt+1));
				}
			}
		}
	}
	public static void bfs(Data start,int num)
	{
		Queue<Data> q = new LinkedList<>();
		q.add(start);
		visited[start.y][start.x] = true;
		arr[start.y][start.x] = num;
		Data pos;
		while(!q.isEmpty())
		{
			pos = q.poll();
			
			for(int i = 0 ; i < 4 ; i++)
			{
				int ty = dy[i] + pos.y;
				int tx = dx[i] + pos.x;
				if(0 <= ty && ty < N && 0 <= tx && tx <N && !visited[ty][tx] && arr[ty][tx] == 1)
				{
					visited[ty][tx] = true;
					arr[ty][tx] = num;
					q.add(new Data(ty,tx));
				}
			}
		}
	}
	public static int[] dy = { -1, 0 , 1 , 0};
	public static int[] dx = { 0, 1 , 0 , -1};
	public static class Data
	{
		int y,x,cnt;
		Data(int y, int x)
		{
			this.y=y;
			this.x=x;
		}
		Data(int y, int x, int cnt)
		{
			this.y=y;
			this.x=x;
			this.cnt=cnt;
		}
	}
}
