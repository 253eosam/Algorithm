import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static int N, K;
	public static boolean[][] visited;
	public static int[][] arr;
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		K = Integer.parseInt(str[1]);
		arr = new int[2][N];
		visited = new boolean[2][N];
		
		for(int i = 0 ; i < 2 ; i++)
		{
			String tmp = br.readLine();
			for(int j  = 0 ; j < N ; j++)
			{
				arr[i][j] = tmp.charAt(j) - '0';
			}
		}
		
		bw.write(bfs() == null ? "0" : "1");
		bw.flush();
		bw.close();
	}
	
	public static Data bfs()
	{
		Queue<Data> q = new LinkedList<>();
		Data output = null;

		// 스타트 포인트
		q.offer(new Data(0,0,0));
		visited[0][0] = true;
		
		while(!q.isEmpty())
		{
			Data pos = q.poll();
			if(pos.x < pos.cnt) continue;
			if(pos.x + K >= N ) // target
			{
				output = pos;
				break;
			}
			// 좌우 이동
			for(int dir : new int[] { pos.x -1 , pos.x +1 })
			{
				if(0 > dir) continue;
				if(!visited[pos.y][dir] && arr[pos.y][dir] == 1)
				{
					visited[pos.y][dir] = true;
					q.offer(new Data(pos.y,dir,pos.cnt + 1));
				}
			}
			// 점프
			int sw = pos.y == 0 ? 1 : 0 ;
			if(!visited[sw][pos.x + K] && arr[sw][pos.x + K] == 1)
			{
				visited[sw][pos.x + K] = true;
				q.offer(new Data(sw,pos.x + K,pos.cnt + 1));
			}
		}
		
		return output;
	}
	static class Data
	{
		int y,x,cnt; 
		Data(int y, int x, int cnt) { this.y = y; this.x = x; this.cnt = cnt; }
	}
}
