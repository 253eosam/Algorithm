import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Data{
	int h,y,x;
	int cnt;
	Data(int h, int y, int x, int cnt)
	{
		this.h = h;
		this.y = y;
		this.x = x;
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "Data [h=" + h + ", y=" + y + ", x=" + x + ", cnt=" + cnt + "]";
	}
}

public class Main {
	public static final boolean DEBUG = false;
	public static int H,N,M;
	public static int[][][] arr;
	public static int[][][] visit;
	public static int maximum = Integer.MIN_VALUE;
	public static Queue<Data> q;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		arr = new int[H][N][M];
		visit = new int[H][N][M];
		q = new LinkedList<>();
		
		for(int i = 0 ; i < H ; i++)
		{
			for(int j = 0 ; j < N ; j++)
			{
				st = new StringTokenizer(br.readLine());
				for(int k = 0 ; k < M ; k++)
				{
					arr[i][j][k] = Integer.parseInt(st.nextToken());
					if(arr[i][j][k] == 1)
					{
						visit[i][j][k] = 1;
						q.add(new Data(i,j,k,0));
					}
					else if(arr[i][j][k] == -1)
						visit[i][j][k] = 1;
				}//m
			}//n
		}//h
		
		bfs();
		
		boolean pass = true;
		outer : for(int i = 0 ; i < H ; i++)
		{
			for(int j = 0 ; j < N ; j++)
			{
				for(int k = 0 ; k < M ; k++)
				{
					if(visit[i][j][k] == 0)
					{
						pass = false;
						break outer;
					}
				}//m
			}//n
		}//h
		
		if(pass)
			bw.write(Integer.toString(maximum));
		else
			bw.write("-1");
		bw.flush();
		bw.close();
	}// main

	
	public static void bfs()
	{
		int[] dh = { 0 , 0 , 0 , 0 ,-1 , 1 };
		int[] dy = { -1, 0 , 1 , 0 , 0 , 0 }; 
		int[] dx = { 0 , 1 , 0 ,-1 , 0 , 0 }; 
		
		while(!q.isEmpty())
		{
			Data d = q.poll();
			if(DEBUG)
				System.out.println(d);
			if(maximum < d.cnt)
				maximum = d.cnt;
			for(int i = 0 ; i < dh.length ; i++)
			{
				int th = d.h + dh[i];
				int ty = d.y + dy[i];
				int tx = d.x + dx[i];
				if(0 <= th && th < H &&
						0 <= ty && ty < N && 
						0 <= tx && tx < M &&
						arr[th][ty][tx] == 0 && visit[th][ty][tx] == 0)
				{
					visit[th][ty][tx] = 1;
					q.add(new Data(th,ty,tx,d.cnt+1));
				}
			}//direction
		}//while queue
	}//bfs

}
