import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	public static int vertex, edge, start;
	public static int[] dist, sumDist;
	public static int[][] arr;
	public static boolean[] visited;
	public static int stoi(String str) { return Integer.parseInt(str) ; }
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int T = stoi(br.readLine());
		
		for(int tNum = 1; tNum <= T ; tNum++)
		{
			//input
			st = new StringTokenizer(br.readLine());
			vertex = stoi(st.nextToken());
			arr = new int[vertex][vertex];
			sumDist = new int[vertex];
			visited = new boolean[vertex];
			dist = new int[vertex];
			visited = new boolean[vertex];
			for(int i = 0 ; i < vertex ; i++)
			{
				for(int j = 0 ; j < vertex ; j++)
				{
					arr[i][j] = stoi(st.nextToken());
				}
			}
			for(int i = 0 ; i < vertex ; i++)
				dist[i] = Integer.MAX_VALUE;
			
			for(int start = 0 ; start < vertex ; start++)
			{
				PriorityQueue<Data> pq = new PriorityQueue<>();
				for(int i = 0 ; i < vertex ; i++)
				{
					if(arr[start][i] > 0)
						pq.add(new Data(start,i,1));
				}
				dist[start] = 0; visited[start] = true;
				
				Data pos = null;
				while(!pq.isEmpty())
				{
					pos = pq.poll();
					visited[pos.b] = true;
					
					for(int i = 0 ; i < vertex ; i++)
					{
						if(!visited[i] && arr[pos.b][i] > 0)
						{
							int tmp = dist[pos.a] + pos.w;
							dist[i] = dist[i] > tmp ? tmp : dist[i];
							pq.add(new Data(pos.b,i,pos.w+1));
						}
					}
				}
				for(int i = 0 ; i < vertex ; i++)
					sumDist[start] += dist[i];
			}
			
			int solv = Integer.MAX_VALUE;
			for(int i = 0 ; i < vertex ; i++)
				solv = Math.min(solv, sumDist[i]);
			bw.write("#"+tNum+" "+solv+"\n");
			
			
		}//for tNum
		bw.flush();
		bw.close();
		
	}

}
class Data implements Comparable<Data>
{
	public int a,b,w;
	Data(int a, int b, int w)
	{
		this.a = a;
		this.b = b;
		this.w = w;
	}
	@Override
	public int compareTo(Data o) {
		return this.w - o.w;
	}
	
}
