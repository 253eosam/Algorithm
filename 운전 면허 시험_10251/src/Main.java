import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



// dp 문제


public class Main
{
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int stoi(String str) { return Integer.parseInt(str); }
	public static int M,N,L,G,T;
	public static int[][] right,bottom;
	public static ArrayList<Car> list;
	public static int MIN;
	public static int[][] visited_g , visited_c;
	public static class Car
	{
		int y, x, dir, cnt, g;
		Car(int y, int x, int dir ,int cnt ,int g)
		{
			this.y=y;
			this.x=x;
			this.dir=dir;
			this.cnt=cnt;
			this.g=g;
		}
		@Override
		public String toString() {
			return "Car [y=" + y + ", x=" + x + ", dir=" + dir + ", cnt=" + cnt + ", g=" + g + "]";
		}
		
	}
	public static void main(String[] args) throws Exception 
	{
		T = stoi(br.readLine());
		for(int tNum = 1 ; tNum <= T ; tNum++)
		{
			init();
			DFS(0,0,3,-1,G);
			print();
		}
		
	}
	private static void print() throws IOException {
		
		for(Car c : list)
		{
			MIN = Math.min(MIN, c.cnt);
		}
		
		if(list.size() == 0)
			bw.write("-1\n");
		else
			bw.write(String.valueOf(MIN) + "\n");
		
		bw.flush();
	}
	//오른쪽 , 아래
	public static int[] dy = { 0 , 1 };
	public static int[] dx = { 1 , 0 };
	public static int[][] dp;
	public static int DFS(int y, int x, int dir , int cnt, int g)
	{
		if(y == N-1 && x == M-1)
		{
			list.add(new Car(y,x,dir,cnt,g));
			return visited_g[y][x] = Math.min(visited_g[y][x],g);
		}
		
//		System.out.println("Car [y=" + y + ", x=" + x + ", dir=" + dir + ", cnt=" + cnt + ", g=" + g + "]");
		int val=Integer.MAX_VALUE;
		for(int i = 0  ; i < 2 ; i++)
		{
			int ty = dy[i] + y;
			int tx = dx[i] + x;
			int tg = g;
			int tcnt = cnt;
			int mtg = 0;
			if(0 <= ty && ty < N && 0 <= tx && tx < M)
			{
				if(i == 0) // 오른쪽
					 mtg = right[ty][tx];
				else if(i == 1)	//아래
					 mtg = bottom[ty][tx];
				
				tg -= mtg;
				tcnt += L;
				if(dir != i)
					tcnt++;
					
				if(tg < 0)continue;
				if(tg <	visited_g[ty][tx])continue;
				val = Math.min(val, DFS(ty,tx,i,tcnt,tg) + mtg);
			}
		}
		
		return visited_g[y][x] = Math.min(visited_g[y][x],val);
	}
	
	
	private static void BFS() {

		Queue<Car> q = new LinkedList<>();
		q.add(new Car(0,0,0,0,G));
		q.add(new Car(0,0,1,0,G));
		Car c;
		while(!q.isEmpty())
		{
			 c = q.poll();

//			System.out.println(c);
			
			if(c.g < 0) continue;
			if(c.y == N-1 && c.x == M-1)
			{
				list.add(c);
				continue;
			}
			
			for(int i = 0 ; i < 2 ; i++)
			{
				int ty = dy[i] + c.y;
				int tx = dx[i] + c.x;
				if(0 <= ty && ty < N && 0 <= tx && tx < M)
				{
					int g = 0; int cnt= 0;
					
					if(i == 0) // 오른쪽
						 g = c.g - right[ty][tx];
					else if(i == 1)	//아래
						 g = c.g - bottom[ty][tx];
					
					
					cnt = c.cnt + L;
					if(c.dir != i)
						cnt++;
					
					if(visited_g[ty][tx] < g || g < 0) continue;
						
					visited_c[ty][tx] = Math.max(visited_c[ty][tx], cnt);
					visited_g[ty][tx] = Math.max(visited_g[ty][tx], g);
					q.add(new Car(ty,tx,i,cnt,g));
				}
			}
		}
	}
	public static void init() throws Exception
	{
		st=new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		L = stoi(st.nextToken());
		G = stoi(st.nextToken());
		
		MIN = Integer.MAX_VALUE;
		bottom = new int[N][M];
		right = new int[N][M];
		list = new ArrayList<>();
		visited_g = new int[N][M];
		visited_c = new int[N][M];
		
		for(int i = 0 ; i < N ; i++)
		{
			for(int j  = 0 ; j < M ; j++)
			{
				visited_g[i][j] = 0;
				visited_c[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for(int i = 0 ; i < N ; i++)
		{
			st=new StringTokenizer(br.readLine());
			for(int j = 1 ; j < M ; j++)
			{
				right[i][j] = stoi(st.nextToken());
			}
		}
		
		for(int i = 1 ; i < N ; i++)
		{
			st=new StringTokenizer(br.readLine());
			for(int j = 0  ; j < M ; j++)
			{
				bottom[i][j] = stoi(st.nextToken());
			}
		}
	}

}
