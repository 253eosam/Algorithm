import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static int N;
	public static int[][] arr;
	public static boolean[][] visited;
	public static void main(String[] args) throws Exception 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for(int tNum = 1 ; tNum <= T ; tNum++)
		{
			//init
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			visited = new boolean[N][N];
			ArrayList<Data> list = new ArrayList<>();
			
			//input
			for(int i = 0 ; i < N ; i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < N ; j++)
				{
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j] == 0)
						visited[i][j] = true;
				}
			}
			
			//logic
			for(int i = 0 ; i < N ; i++)
			{
				for(int j = 0 ; j < N ; j++)
				{
					if(!visited[i][j])
						list.add(bfs(new Data(i,j,i,j)));
				}
			}
			Collections.sort(list,new Comparator<Data>() {

				@Override
				public int compare(Data o1, Data o2) {
					if(o1.val == o2.val)
						return (o1.y-o1.initY) - (o2.y-o2.initY); 
					return o1.val-o2.val;	
				}
			});
			
			//print
			bw.write("#"+tNum+" " + list.size()+ " ");
			for(Data tmp : list)
			{
				bw.write(((tmp.y-tmp.initY)+1) + " " + ((tmp.x-tmp.initX)+1) + " ");
			}
			bw.write("\n");

		}//for tNum
		bw.flush();
		bw.close();
	}
	// À§ ¾Æ·¡
	public static int[] dy = { 0 , 1 };
	public static int[] dx = { 1 , 0 };
	public static Data bfs(Data starting)
	{
		Queue<Data> q = new LinkedList<>();
		Data d = null;
		q.offer(starting);
		visited[starting.y][starting.x] = true;
		
		while(!q.isEmpty())
		{
			d = q.poll();
			for(int i = 0 ; i < 2 ; i++)
			{
				int ty = d.y + dy[i];
				int tx = d.x + dx[i];
				if(0 <= ty && ty < N && 0 <= tx && tx < N && !visited[ty][tx] && arr[ty][tx]!=0)
				{
					visited[ty][tx] = true;
					q.offer(new Data(d.initY,d.initX,ty,tx));
				}
			}
		}
		
		return d;
	}

}
class Data
{
	public int initY,initX,y,x,val;
	Data(int initY,int initX,int y, int x)
	{
		this.initY = initY;
		this.initX = initX;
		this.y = y;
		this.x = x;
		this.val = ((y-initY)+1)*((x-initX)+1);
	}
}