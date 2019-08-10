import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Data
{
	int y,x,cnt;
	boolean broken;
	Data(int y, int x, int cnt, boolean b)
	{
		this.y = y;
		this.x = x;
		this.cnt = cnt;
		this.broken = b;
	}
	@Override
	public String toString() {
		return "Data [y=" + y + ", x=" + x + ", cnt=" + cnt + ", broken=" + broken + "]";
	}
}
public class Main {
	public static int[][] arr;
	public static boolean[][] visit;
	public static Queue<Data> q;
	public static int N,M,cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		visit = new boolean[N][M];
		for(int i = 0 ; i < N ; i++)
		{
			String tmp = br.readLine();
			for(int j = 0 ; j < M ; j++)
			{
				arr[i][j] = tmp.charAt(j) - '0';
			}
		}
		
		q = new LinkedList<>();
		visit[0][0]=true;
		q.add(new Data(N-1,M-1,1,false));
		
		boolean solv = bfs();
		
		if(!solv)
			bw.write("-1");
		else
			bw.write(Integer.toString(cnt));
		
		bw.flush();
		bw.close();
		
	}
	public static boolean bfs()
	{
		int[] dy = { -1,0,1,0};
		int[] dx = { 0,1,0,-1};
		boolean solv = false;
		while(!q.isEmpty())
		{
			Data d = q.poll();
//			System.out.println(d);
			if(d.y == 0 && d.x == 0)
			{
				cnt = d.cnt;
				solv = true;
				break;
			}
			
			for(int i = 0 ; i < 4; i++)
			{
				int ty = d.y + dy[i];
				int tx = d.x + dx[i];
				
				if(0 <= ty && ty < N &&
						0 <= tx && tx < M)
				{
					if(d.broken && arr[ty][tx] == 0 && !visit[ty][tx])
					{
						visit[ty][tx] = true;
						q.add(new Data(ty,tx,d.cnt+1,d.broken));
					}
					else if(!d.broken && !visit[ty][tx] )
					{
						visit[ty][tx] = true;
						if(arr[ty][tx] == 1)
							q.add(new Data(ty,tx,d.cnt+1,true));
						else
							q.add(new Data(ty,tx,d.cnt+1,false));
					}
				}
			}//for direction
		}//while !isEmpty
		return solv;
	}
}