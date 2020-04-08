import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static int N;
	public static int[][] arr;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int tNum = 1 ; tNum <= T ; tNum++)
		{
			//init
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			
			//input
			for(int i = 0 ; i < N ; i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < N ; j++)
				{
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//logic
			boolean counting[] = new boolean[N*N+1];
			int maxDis = 0; int index = Integer.MAX_VALUE;
			for(int i = 0 ; i < N ; i++)
			{
				for(int j = 0 ; j < N ; j++)
				{
					
					//branch 
					int tmp = 0;
					if(!counting[arr[i][j]])
						tmp = bfs(new Data(i,j,1));
					for(int k = arr[i][j] ; k < arr[i][j]+tmp ; k++)
						counting[k] = true;
					if(maxDis < tmp)
					{
						maxDis = tmp;
						index = arr[i][j];
					}
					if(maxDis == tmp)
					{
						maxDis = tmp;
						index = Math.min(arr[i][j],index);
					}
				}
			}
			
			//print
			bw.write("#"+tNum+" "+index+" "+maxDis+"\n");
		}//for tNum
		bw.flush();
		bw.close();
	}
	public static int[] dy = { -1 , 0 , 1 , 0 };
	public static int[] dx = { 0 , 1 , 0 , -1 };
	public static int bfs(Data starting)
	{
		Queue<Data> q = new LinkedList<>();
		q.offer(starting);
		Data pos = null;
		while(!q.isEmpty())
		{
			pos = q.poll();
			
			for(int i = 0 ; i < 4 ; i++)
			{
				int ty = dy[i] + pos.y;
				int tx = dx[i] + pos.x;
				if(0 <= ty && ty < N && 0 <= tx && tx < N && arr[pos.y][pos.x]+1 == arr[ty][tx])
				{
					q.offer(new Data(ty,tx,pos.cnt+1));
				}
			}
		}
		
		return pos.cnt;
	}
}
class Data
{
	int y,x,cnt;
	Data(int y, int x , int c)
	{
		this.y =y;
		this.x =x;
		this.cnt = c;
	}
}