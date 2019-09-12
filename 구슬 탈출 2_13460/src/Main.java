import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N,M;
	public static boolean[][][] visited;
	public static char[][] arr;
	public static Data target;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//init
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[11][N][M];
		arr = new char[N][M];
		
		//input
		for(int i = 0 ; i < N ; i++)
		{
			String tmp = br.readLine();
			for(int j = 0 ; j < N ; j++)
			{
				arr[i][j] = tmp.charAt(j);
				if(arr[i][j] == 'B')
					visited[0][i][j] = true;
				else if(arr[i][j] == 'R')
					visited[0][i][j] = true;
				else if(arr[i][j] == 'O')
				{
					target = new Data(i,j);
				}
			}
		}
		
		//logic
		ArrayData solv = bfs();
		
		//print
		if(solv == null)
			bw.write("-1");
		else
			bw.write(String.valueOf(solv.cnt));
		bw.flush();
		bw.close();
	}
	
	
	public static ArrayData bfs()
	{
		Queue<ArrayData> q = new LinkedList<>();
		ArrayData output = null;
		q.offer(new ArrayData(arr,0));
		while(!q.isEmpty())
		{
			ArrayData tmp = q.poll();
			arr = tmp.data;
			int cnt = tmp.cnt;

		
		}
		
		return output;
	}
	
	public static void moveRow(int start, int sw)
	{
		
	}
	
	public static Data findRed(int cnt)
	{
		for(int i = 1 ; i < N-1 ; i++)
		{
			for(int j = 1 ; j < M-1 ; j++)
			{
				if(arr[i][j] == 'R')
					return new Data(i,j);
			}
		}
		return null;
	}
	public static Data findBlue(int cnt)
	{
		for(int i = 1 ; i < N-1 ; i++)
		{
			for(int j = 1 ; j < M-1 ; j++)
			{
				if(arr[i][j] == 'B')
					return new Data(i,j);
			}
		}
		return null;
	}
}
class Data
{
	int y,x;
	Data(int y,int x)
	{
		this.y = y;
		this.x = x;
	}
}
class ArrayData
{
	char[][] data;
	int cnt;
	ArrayData(char[][] d, int c)
	{
		data = d;
		this.cnt = c;
	}
}