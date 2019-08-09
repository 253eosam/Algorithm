import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Data
{
	int index;
	int cnt;
	Data(int index, int cnt)
	{
		this.index = index;
		this.cnt = cnt;
	}
}
public class Main {
	public static int N;
	public static int K;
	public static int fastCase;
	public static int caseNum;
	public static final int MAX_SIZE = 100_001;
	public static int[] arr = new int[MAX_SIZE];
	public static boolean[] visit = new boolean[MAX_SIZE];
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		fastCase = Integer.MAX_VALUE;
		dfs(N);
		
		bw.write(fastCase + "\n" + caseNum);
		bw.flush();
		bw.close();
		
	}

	public static void dfs(int index)
	{
		Queue<Data> q = new LinkedList<>();
		visit[index] = true;
		q.add(new Data(index,0));
		while(!q.isEmpty())
		{
			Data d = q.poll();
			visit[d.index] = true;
			if(d.index == K)
			{
				fastCase = d.cnt;
				caseNum++;
			}
			else if(d.cnt > fastCase)
				break;
			
			int dis = 0;
			//*2
			dis = d.index * 2;
			if( 0 <= dis && dis < MAX_SIZE && !visit[dis] )
			{
				q.add(new Data(dis,d.cnt+1));
			}
			//+1
			dis = d.index + 1;
			if( 0 <= dis && dis < MAX_SIZE && !visit[dis] )
			{
				q.add(new Data(dis,d.cnt+1));
			}
			//-1
			dis = d.index - 1;
			if( 0 <= dis && dis < MAX_SIZE && !visit[dis] )
			{
				q.add(new Data(dis,d.cnt+1));
			}
		}
	}

}

