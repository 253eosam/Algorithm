import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int R,C;
	public static char[][] arr;
	public static int [][] visit;
	public static Queue<Data> q = new LinkedList<>();
	public static Data target;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[R][C];
		visit = new int[R][C];	// 비버는 1, 물과 돌은 2
		
		// 비버 먼저 움직여야한다. 물이 먼저 움직이면 비버가 움직일 수 있는 행동 범위가 좁아짐
		ArrayList<Data> list = new ArrayList<>();
		for(int i = 0 ; i < R ; i++)
		{
			String tmp = br.readLine();
			for(int j = 0 ; j < C ; j++)
			{
				arr[i][j] = tmp.charAt(j);
				if(arr[i][j] == 'X')
					visit[i][j] = 2;
				else if(arr[i][j] == 'D')
				{
					target = new Data(i,j,0);
					visit[i][j] = 3;	// 물이 안차게
				}
				else if(arr[i][j] == 'S')
				{
					q.offer(new Data(i,j,0,true));
					visit[i][j] = 1;
				}
				else if(arr[i][j] == '*')
				{
					list.add(new Data(i,j,0));
					visit[i][j] = 2;
				}
			}
		}//for i
		for(Data tmp : list)
			q.offer(tmp);
		
		Data data = bfs();
		if(data == null)
			bw.write("KAKTUS");
		else
			bw.write(String.valueOf(data.cnt));
		bw.flush();
		bw.close();
	}//main
	
	public static int dy[] = {-1,0,1, 0};
	public static int dx[] = { 0,1,0,-1};
	public static Data bfs()
	{
		Data output = null;
		
		while(!q.isEmpty())
		{
			Data d = q.poll();
			
			if(d.isBiver)
			{
				if(d.y == target.y && d.x == target.x)
				{
					output = d;
					break;
				}
				if(visit[d.y][d.x] == 2)
					continue;
			}
			
			for(int i = 0 ; i < 4; i++)
			{
				int ty = d.y + dy[i];
				int tx = d.x + dx[i];
				if(0 <= ty && ty < R && 0 <= tx && tx < C)
				{
					if(d.isBiver && (visit[ty][tx] == 0 || visit[ty][tx] == 3))
					{
						q.offer(new Data(ty,tx,d.cnt+1,true));
						visit[ty][tx] = 1;
					}
					if(!d.isBiver && visit[ty][tx] < 2)
					{
						q.offer(new Data(ty,tx,d.cnt+1));
						visit[ty][tx] = 2;
					}
				}
			}
		}//while
		
		return output;
	}//bfs
}
class Data
{
	int y,x,cnt; boolean isBiver;
	Data(int y, int x, int cnt)
	{
		this.y = y;
		this.x = x;
		this.cnt = cnt;
		this.isBiver = false;
	}
	Data(int y, int x, int cnt, boolean b)
	{
		this.y = y;
		this.x = x;
		this.cnt = cnt;
		this.isBiver = b;
	}
}
