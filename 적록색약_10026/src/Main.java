import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static boolean[][] visitedA;
	public static boolean[][] visitedB;
	public static char[][] arr;
	public static int N;
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//init
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		visitedA = new boolean[N][N];
		visitedB = new boolean[N][N];
		int cntA = 0 ; int cntB = 0;
		for(int i = 0 ; i < N ; i++)
		{
			String tmp = br.readLine();
			arr[i] = tmp.toCharArray();
		}
		
		for(int i = 0 ; i < N ; i++)
		{
			for(int j = 0 ; j < N ; j++)
			{
				if(!visitedA[i][j])
				{
					bfsA(new Data(i,j));
					cntA++;
				}
				if(!visitedB[i][j])
				{
					bfsB(new Data(i,j));
					cntB++;
				}
			}
		}
		
		bw.write(cntA + " " + cntB);
		bw.flush();
		bw.close();
		
		
	}//main
	public static int[] dy = { -1, 0 , 1 , 0};
	public static int[] dx = {  0, 1 , 0 ,-1};
	public static void bfsA(Data starting)
	{
		Queue<Data> q = new LinkedList<>();
		visitedA[starting.y][starting.x] = true;
		q.offer(starting);
		while(!q.isEmpty())
		{
			Data pos = q.poll();
			int y = pos.y;
			int x = pos.x;
			for(int i = 0 ; i < 4 ; i++)
			{
				int ty = y + dy[i];
				int tx = x + dx[i];
				if(0 <= ty && ty < N && 0 <= tx && tx < N && !visitedA[ty][tx] && arr[y][x] == arr[ty][tx])
				{
					visitedA[ty][tx] = true;
					q.offer(new Data(ty,tx));
				}
			}
		}
	}
	public static void bfsB(Data starting)
	{
		Queue<Data> q = new LinkedList<>();
		q.offer(starting);
		while(!q.isEmpty())
		{
			Data pos = q.poll();
			int y = pos.y;
			int x = pos.x;
			for(int i = 0 ; i < 4 ; i++)
			{
				int ty = y + dy[i];
				int tx = x + dx[i];
				if(0 <= ty && ty < N && 0 <= tx && tx < N && !visitedB[ty][tx])
				{
					if(arr[y][x] == 'B' && arr[ty][tx] == arr[y][x])
					{
						visitedB[ty][tx] = true;
						q.offer(new Data(ty,tx));
					}
					else if((arr[y][x] == 'G' || arr[y][x] == 'R' ) && (arr[ty][tx] == 'G' || arr[ty][tx] == 'R'))
					{
						visitedB[ty][tx] = true;
						q.offer(new Data(ty,tx));
					}
				}
			}
		}
	}
}
class Data
{
	public int y,x;
	public Data(int y, int x)
	{
		this.y = y; this.x = x;
	}
}