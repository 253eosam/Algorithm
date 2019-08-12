import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N, M, R , C ,S ,K;
	public static boolean visit[][];
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visit = new boolean[N+1][M+1];
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		visit[R][C] = true;
		Data d = bfs(R,C);
		if(d == null)
			bw.write("-1");
		else
			bw.write(Integer.toString(d.cnt));
		bw.flush();
		bw.close();
	}
	public static Queue<Data> q = new LinkedList<Data>();
	public static Data bfs(int y, int x)
	{
		Data d = new Data(y,x,0);
		q.offer(d);
		int[] dy = { -2 , -1, 1, 2, 2, 1, -1, -2};
		int[] dx = {  1 ,  2, 2, 1,-1,-2, -2, -1};
		boolean pass = false;
		while(!q.isEmpty())
		{
			d = q.poll();
//			System.out.println(d);
			if(d.y == S && d.x == K)
			{
				pass = true;
				break;
			}
			
			for(int i = 0 ; i < dy.length; i++)
			{
				int ty = d.y + dy[i];
				int tx = d.x + dx[i];
				if(0 < ty && ty <= N && 0 < tx && tx <= M && !visit[ty][tx])
				{
					visit[ty][tx] = true;
					q.offer(new Data(ty,tx,d.cnt+1));
				}
			}
		}//while !isEmpty
		if(!pass)
			d = null;
		return d;
	}//bfs

}
class Data
{
	int y, x, cnt;
	Data(int y, int x, int cnt)
	{
		this.y = y;
		this.x = x;
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "Data [y=" + y + ", x=" + x + ", cnt=" + cnt + "]";
	}
}
