import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int K;
	public static int fastCase;
	public static final int MAX_SIZE = 100_001;
	public static boolean[] visit = new boolean[MAX_SIZE];
	public static int[] movingCnt = new int[MAX_SIZE*10];	// 10만일때 20만에서 접근 가능..
	public static int[] moving = new int[MAX_SIZE*10];	// 10만일때 20만에서 접근 가능..
	public static Stack<Integer> stack = new Stack<>();
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		fastCase = Integer.MAX_VALUE;
		bfs(N);
		
		bw.write(fastCase + "\n");

		for(int i = K ; i != N ; )
		{
			stack.push(i);
			i = moving[i];
		}
		stack.push(N);
		
		while(!stack.isEmpty())
			bw.write(stack.pop() + " ");
		
		bw.flush();
		bw.close();
		
	}

	public static void bfs(int index)
	{
		Queue<Integer> q = new LinkedList<>();
		
		visit[index] = true;
		q.offer(index);
		
		while(!q.isEmpty())
		{
			int point = q.poll();
			if(point == K)
			{
				fastCase = movingCnt[point];
				return;
			}
			
			for(int dis : new int[] { point-1 , point+1 , point*2 })
			{
				if( 0 <= dis && dis < MAX_SIZE && !visit[dis] )
				{
					visit[dis] = true;
					movingCnt[dis] = movingCnt[point] + 1;
					moving[dis] = point;
					q.add(dis);
				}
			}
		}//while !q.isEmpty
	}//bfs
}

