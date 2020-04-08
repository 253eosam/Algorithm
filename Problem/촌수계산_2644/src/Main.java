import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int stoi(String str) { return Integer.parseInt(str); }
	public static int N,parent,start,target,M;
	public static ArrayList<ArrayList<Integer> > arr;
	public static boolean[] visited;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		//init
		N = stoi(br.readLine());
		st= new StringTokenizer(br.readLine());
		start = stoi(st.nextToken());
		target = stoi(st.nextToken());
		arr = new ArrayList<>();
		M = stoi(br.readLine());
		for(int i = 0 ; i <= N ; i++)
			arr.add(new ArrayList<Integer>());
		visited = new boolean[N+1];
		
		for(int i = 0 ; i < M ; i++)
		{
			st = new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken());
			int b = stoi(st.nextToken());
			arr.get(a).add(b);
			arr.get(b).add(a);
		}
		
		Data solv = bfs();
		
		if(solv == null)
			bw.write("-1");
		else
			bw.write(String.valueOf(solv.cnt));
		bw.flush();
		bw.close();
	}
	public static Data bfs()
	{
		Queue<Data> q = new LinkedList<>();
		q.offer(new Data(start,0));
		visited[start] = true;
		Data pos = null;
		Data output = null;
		while(!q.isEmpty())
		{
			pos = q.poll();
			
			if(pos.index == target)
			{
				output = pos;
				break;
			}
			
			for(int i : arr.get(pos.index))
			{
				if(visited[i]) continue;
					q.offer(new Data(i,pos.cnt+1));
					visited[i] = true;
			}
		}
		return output;
	}
}
class Data
{
	public int index , cnt;
	Data(int i, int c)
	{
		this.index = i;
		this.cnt = c;
	}
}