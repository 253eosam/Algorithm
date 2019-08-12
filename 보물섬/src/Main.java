import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static char[][] arr;
	public static boolean[][] visit;
	public static Stack<Data> s = new Stack<>();
	public static Queue<Data> q = new LinkedList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		visit = new boolean[N][M];
		
		
		for(int i = 0 ; i < N ; i++)
		{
			String tmp = br.readLine();
			for(int j = 0 ; j < M ; j++)
			{
				arr[i][j] = tmp.charAt(j);
				if(arr[i][j] == 'L')
					s.push(new Data(i,j,0));
				else if(arr[i][j] == 'W')
					visit[i][j] = true;
			}
		}

		int maximum = 0 ;
		while(!s.isEmpty())
		{
			Data data = bfs(s.pop());
			if(maximum < data.cnt)
				maximum = data.cnt;
		}
		
		bw.write(Integer.toString(maximum));
		bw.flush();
		bw.close();
	}//main
	
	public static int[] dy = { -1, 0, 1 , 0};
	public static int[] dx = { 0,  1, 0, -1};
	public static Data bfs(Data data)
	{
		visit = new boolean[N][M];
		q.offer(data);
		visit[data.y][data.x] = true;
		Data d = null;
		while(!q.isEmpty())
		{
			d = q.poll();
			for(int i = 0 ; i < 4 ; i++)
			{
				int ty = d.y + dy[i];
				int tx = d.x + dx[i];
				if( 0 <= ty && ty < N && 0 <= tx && tx < M && !visit[ty][tx] && arr[ty][tx] == 'L')
				{
					visit[ty][tx] = true;
					q.offer(new Data(ty,tx,d.cnt+1));
				}
			}
		}
		visit[data.y][data.x] = false;
		return d;
	}

}
class Data
{
	int y,x,cnt;
	Data(int y, int x, int cnt)
	{
		this.y = y;
		this.x = x;
		this.cnt = cnt;
	}
}