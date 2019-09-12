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
	public static int N,M,wallCnt;
	public static int[][] arr;
	public static Data[] pick;
	public static int maxZeroCnt;
	public static boolean[][] virusVisted;
	public static ArrayList<Data> list = new ArrayList<>();
	public static ArrayList<Data> virus = new ArrayList<>();
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		//init
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		maxZeroCnt = Integer.MIN_VALUE;
		pick = new Data[3];
		
		//input
		for(int i = 0 ; i < N ; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 0)
					list.add(new Data(i,j));
				else if(arr[i][j] == 2)
					virus.add(new Data(i,j));
				else if(arr[i][j] == 3)
				{
					wallCnt++;
				}
			}
		}
		
		//logic
		com(0,0);
		
		//print
		bw.write(String.valueOf(maxZeroCnt));
		bw.flush();
		bw.close();
	}

	public static void com(int pCnt, int index)
	{
		if(pCnt == 3)
		{
			for(int i = 0 ; i < pCnt ; i++)
				arr[pick[i].y][pick[i].x] = 1;
			virusVisted = new boolean[N][M];
			if(DEBUG)
			{
				System.out.println();
				for(int i =0  ; i < N ; i++)
				{
					for(int j = 0 ; j < M ; j++)
					{
						System.out.print(arr[i][j] + " ");
					}
					System.out.println();
				}
				System.out.println();
			}
			maxZeroCnt = Math.max(maxZeroCnt, bfs());
			for(int i = 0 ; i < pCnt ; i++)
				arr[pick[i].y][pick[i].x] = 0;
			return ;
		}
		for(int i = index ; i < list.size() ; i++)
		{
			pick[pCnt] = list.get(i);
			com(pCnt+1, i+1);
		}
	}
	
	public static int[] dy = { -1 , 0 , 1 , 0 };
	public static int[] dx = {  0 , 1 , 0 ,-1 };
	public static int bfs()
	{
		Queue<Data> q = new LinkedList<>();
		//input virus
		for(Data v : virus)
		{
			q.offer(v);
			virusVisted[v.y][v.x] = true;
		}
		
		int zeroCnt = 0 ;
		while(!q.isEmpty())
		{
			Data v = q.poll();
			for(int i = 0 ; i < 4 ; i++)
			{
				int ty = v.y + dy[i];
				int tx = v.x + dx[i];
				if(0 <= ty && ty < N && 0 <= tx && tx < M && 
						!virusVisted[ty][tx] && arr[ty][tx]==0)
				{
					q.offer(new Data(ty,tx));
					virusVisted[ty][tx] = true;
				}
			}
		}
		
		//counting zero
		for(int i = 0 ; i < N ; i++)
			for(int j = 0 ; j < M ; j++)
				if(!virusVisted[i][j] && arr[i][j] == 0) 
					zeroCnt++;
		
		return zeroCnt; 
	}
}

class Data
{
	public int y,x;
	Data(int y , int x)
	{
		this.y = y;
		this.x = x;
	}
}