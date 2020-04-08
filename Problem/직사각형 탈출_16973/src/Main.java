import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N,M;
	public static int[][] arr;
	public static boolean[][] visited;
	public static int H, W;
	public static Data target;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//init
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
		
		//input
		for(int i = 1 ; i <= N ; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= M ; j++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		Data starting = new Data(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),0);
		target = new Data(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),0);
		
		//logic
		Data solv = bfs(starting);
		
		//print
		if(solv == null)
			bw.write("-1");
		else
			bw.write(String.valueOf(solv.cnt));
		bw.flush();
		bw.close();
	}
	public static int[] dy = { -1 , 0 , 1 , 0 };
	public static int[] dx = {  0 , 1 , 0 ,-1 };
	public static Data bfs(Data starting)
	{
		Queue<Data> q = new LinkedList<>();
		q.offer(starting);
		visited[starting.y][starting.x] = true;
		Data output = null;
		while(!q.isEmpty())
		{
			Data d = q.poll();
//			System.out.println(" dy : " + d.y + " dx : " + d.x +  " dCnt :" + d.cnt);
			if(d.x == target.x && d.y == target.y)
			{
				output = d;
				break;
			}
			
			for(int i = 0 ; i < 4 ;  i++)
			{
				int ty = d.y + dy[i];
				int tx = d.x + dx[i];
				if(0 < ty && ty <= N && 0 < tx && tx <= M && 
						!visited[ty][tx] && arr[ty][tx] == 0)
				{
					//직사각형이 모두 이동하여야하기 때문에 이동할때 또 다른 조건을 달아줘야한다.
					int rowPos = ty + H ;
					int colPos = tx + W ;
					if(0 <= rowPos && rowPos <= N+1 && 0 <= colPos && colPos <= M+1)
					{
						boolean pass = true;
						outer : for(int j = ty ; j < rowPos ; j++)
						{
							for(int k = tx ; k < colPos ; k++)
							{
								if(arr[j][k] == 1)
								{
									pass = false;
									break outer;
								}
							}
						}//for 직사각형에 공간에 벽이 있는가 체크
						if(pass)
						{
							q.offer(new Data(ty,tx,d.cnt+1));
							visited[ty][tx] = true;
							
						}
					}// 직사각형안에 범위안인지 체크
				}//범위 안
			}//방향
		}//while !q.isEmpty
		return output;
	}
}
class Data
{
	public int y,x,cnt;
	Data(int y, int x, int c)
	{
		this.y = y;
		this.x = x;
		this.cnt = c;
	}
}