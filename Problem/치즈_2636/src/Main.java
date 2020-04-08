import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static boolean DEBUG = false;
	public static int N,M;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int[][] arr;
	public static int stoi(String str) { return Integer.parseInt(str); }
	public static ArrayList<Data> list;
	public static void main(String[] args) throws Exception 
	{
		
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		list = new ArrayList<>();
		arr = new int[N][M];
		for(int i = 0 ; i < N ; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++)
			{
				int tmp = stoi(st.nextToken());
				arr[i][j] = tmp == 1 ? -1 : 0;
				if(arr[i][j] == -1)
					list.add(new Data(i,j));
			}
		}
		if(DEBUG)
		{
			
			for(int i = 0 ; i < N ; i++)
			{
				for(int j = 0 ; j < M ; j++)
				{
					System.out.print((arr[i][j]==-1?"x":arr[i][j]) + "  ");
				}
				System.out.println();
			}
			System.out.println();
			System.out.println();
		}

		int count = 1;
		while(allChecked())
		{
			bfs(new Data(0,0),count++);
		}
		
		if(DEBUG)
		{
			
			for(int i = 0 ; i < N ; i++)
			{
				for(int j = 0 ; j < M ; j++)
				{
					System.out.print(arr[i][j]  + "  ");
				}
				System.out.println();
			}
			System.out.println();
			System.out.println("last Val : " + lastVal);
		}
		bw.write(arr[0][0] + "\n" + lastVal);
		bw.flush();
		bw.close();
	}
	public static int lastVal;
	public static boolean allChecked()
	{
		boolean pass = false;
		for(Data tmp : list)
		{
			if(arr[tmp.y][tmp.x] == -1)
			{
				pass = true;
				break;
			}
		}
		return pass;
	}
	public static int[] dy = { -1, 0 , 1 , 0};
	public static int[] dx = {  0, 1 , 0 ,-1};
	public static void bfs(Data start , int k)
	{
		Queue<Data> q = new LinkedList<>();
		q.offer(start);
		arr[start.y][start.x] = 1;
		Data pos;
		lastVal = 0;
		while(!q.isEmpty())
		{
			pos = q.poll();
			
			for(int i = 0 ; i < dy.length ; i++)
			{
				int ty = dy[i] + pos.y;
				int tx = dx[i] + pos.x;
				if(0 <= ty && ty < N && 0 <= tx && tx < M)
				{
					if(arr[ty][tx] != -1 && arr[ty][tx] != k)
					{
						q.offer(new Data(ty,tx));
					}
					if(arr[ty][tx] == -1)
						lastVal++;
					arr[ty][tx] = k;
				}
			}
		}
	}
	public static class Data
	{
		int y,x;
		int cnt;
		Data(int y , int x)
		{
			this.y = y;
			this.x = x;
		}
		
		Data(int y , int x , int cnt)
		{
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
		
	}

}
