import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int[][] arr;
	public static ArrayList<Time> tList;
	public static int[] dy = { 1, 0,-1, 0}; 
	public static int[] dx = { 0, 1, 0,-1}; 
	public static boolean DEBUG = false;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//init
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		tList = new ArrayList<>();
		
		//input
		int appleNum = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < appleNum ; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			arr[y][x] = -1;
		}
		int movingNum = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < movingNum ; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int turn = -1;
			if(st.nextToken().equals("D"))	// left : -1 , right : 1 
				turn = 1;
			tList.add(new Time(t,turn));
		}
		
		//starting point
		Queue<Data[]> q = new LinkedList<>();
		Data[] data = new Data[2];	// > 0 , v 1 , < 2 , ^ 3
		data[0] = new Data(1,1,0,0);
		data[1] = new Data(1,1,0,-1);
		q.offer(data);
		Data output = null;
		//logic
		while(!q.isEmpty())
		{
			Data[] d = q.poll();
			if(DEBUG)
			{
				System.out.println();
				for(int i = 1; i <= N ; i++)
				{
					for(int j = 1 ; j <= N ;j++)
					{
						System.out.print(arr[i][j] + " ");
					}
					System.out.println();
				}
				System.out.println();
			}
			//방향 선택
			for(Time t : tList)
			{
				if(t.t == d[0].cnt)
				{
					d[0].dir = (d[0].dir + t.turn) % 4;
				}
			}
			
			//예상 경로 계산
			switch(d[0].dir)
			{
			case 0:
				d[0].x++;
				break;
			case 1:
				d[0].y++;
				break;
			case 2:
				d[0].x--;
				break;
			case 3:
				d[0].y--;
				break;
			}
			
			//경로가 배열 안인지 확인
			if(1 <= d[0].y && d[0].y <= N && 1 <= d[0].x && d[0].x <= N)
			{
				//꼬리를 밟지 않는지 확인
				if(arr[d[0].y][d[0].x] == 0)
				{
					//머리에 값 넣어주기
					arr[d[0].y][d[0].x] = ++d[0].cnt;
					//꼬리 따라오기
					for(int i = 0 ; i < 4 ; i++)
					{
						int ty = dy[i] + d[1].y;
						int tx = dx[i] + d[1].x;
						if(1 <= ty && ty <= N && 1 <= tx && tx <= N)
						{
							if(arr[ty][tx] == arr[d[1].y][d[1].x]+1)
							{
								arr[d[1].y][d[1].x] = 0;
								d[1].y = ty;
								d[1].x = tx;
							}
						}
					}
					//다음 경로 넣어주기
					q.offer(d);
				}
				//사과를 먹을때
				else if(arr[d[0].y][d[0].x] == -1)
				{
					//머리에 값 넣어주기
					arr[d[0].y][d[0].x] = ++d[0].cnt;
					//다음 경로 넣어주기
					q.offer(d);
				}
				else
				{
					output = d[0];
					break;
				}
			}
			else
			{
				output = d[0];
				break;
			}
			
			
		}
		
		//print
		bw.write(String.valueOf(output.cnt+1));
		bw.flush();
		bw.close();
	}

}
class Time
{
	public int t,turn;
	Time(int t, int turn)
	{
		this.t = t;
		this.turn = turn;
	}
}
class Data
{
	public int y,x,cnt,dir;
	Data(int y,int x,int c,int dir)
	{
		this.y =y;
		this.x =x;
		this.cnt = c;
		this.dir = dir;
	}
}