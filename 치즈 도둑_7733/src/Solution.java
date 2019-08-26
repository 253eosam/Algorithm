import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static int[][] arr;
	public static boolean[][] visited;
	public static int N;
	public static int maxCnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int tNum = 1 ; tNum <= T ; tNum++)
		{
			//init
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			visited = new boolean[N][N];
			maxCnt = 0;
			//input
			for(int i = 0 ; i < N ; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < N ; j ++)
				{
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//logic
			for(int day = 0 ; day <= 100 ; day++)
			{
				int cnt = 0;
				visited = new boolean[N][N];
				for(int i = 0 ; i < N ; i++)
				{
					for(int j = 0 ; j < N ; j++)
					{
						if(visited[i][j] || arr[i][j] <= day) continue;
						bfs(new Data(i,j),day);
						cnt++;
					}
				}
				maxCnt = Math.max(maxCnt, cnt);
			}
			
			bw.write("#"+tNum+" "+maxCnt+"\n");
			
		}//for tNum
		bw.flush();
		bw.close();
	}
	public static int dy[] = { -1, 0 , 1 , 0 };
	public static int dx[] = { 0 , 1 , 0 , -1 };
	public static void bfs(Data starting, int day)
	{
		Queue<Data> q = new LinkedList<>();
		q.offer(starting);
		visited[starting.y][starting.x] = true;
		while(!q.isEmpty())
		{
			Data pos = q.poll();
			int y = pos.y;
			int x = pos.x;
			for(int i = 0 ; i < 4 ; i ++)
			{
				int ty = y + dy[i];
				int tx = x + dx[i];
				if(0 <= ty && ty < N && 
						0 <= tx && tx < N && 
						arr[ty][tx] > day && !visited[ty][tx])
				{
					visited[ty][tx] = true;
					q.offer(new Data(ty,tx));
				}
			}//direction
		}//while
	}//bfs
}
class Data
{
	public int y,x;
	Data(int y, int x)
	{
		this.y = y; this.x = x;
	}
}
