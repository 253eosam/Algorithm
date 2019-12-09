import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main 
{
	/*
	 * 바닥에서 모든 미네랄을 bfs를 통해서 방문처리를 한다.
	 * 모든 미네랄이 방문처리가 되지 않으면 되지 않은 미네랄을 떨어뜨리낟
	 * 
	 * 떨어질 미네랄의 가장 아래 블럭을 한칸씩 밑으로 이동시켜보고 방분된 미네랄을 건들거나 바닥 인덱스를 초과하면 그 이전까지 이동시킨다.
	 */
	public static class Node
	{
		int y,x;
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	public static int R,C;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static boolean[][] visited;
	public static char[][] arr;
	public static int N, nums;
	public static ArrayList<Node> list;
	private static int[] draws;
	public static void main(String[] args) {
		logic();
	}
	private static void logic() {
		for(int i = 0 ; i < N ; i++)
		{
			if(i % 2 == 0)
				play(0,1,draws[i]);
			else
				play(N-1,-1,draws[i]);

			//바닥에서 bfs
			list = new ArrayList<>();
			visited = new boolean[R][C];
			for(int j = 0 ; j < R  ; j++)
				if(!visited[R][j] && arr[R][j] == 'x')
					bfs(R,j);

			list = new ArrayList<>();
			// 방문되지 않은 미네랄 떨어짐.
			if(list.size() != nums)
			{
				for(int y = 0 ; y < R ; y++)
					for(int x = 0 ; x < C ; x++)
						if(!visited[y][x] && arr[y][x]=='x')
							bfs(y,x);
			}

			if(list.size() != 0)
			{

			}


		}
	}
	private static void moving() {
		int[] bottom = new int[C];
		for(int i = 0 ; i < C ; i++)
			bottom[i] = R;
		for(Node idx : list)
		{
			if(bottom[idx.x] > idx.y)
				bottom[idx.x] = idx.y;
		}

		int go = 0 ;
		outer : while(true)
		{
			for(int idx = 0 ; idx < C ; idx++)
			{
				if(bottom[idx] != R)
				{
					int val = bottom[idx] - go;
					if(0 == val || visited[val][idx] || arr[val][idx] == 'x')
						break outer;
				}
			}
			go++;
		}
		
		for(Node n : list)
		{
			
		}
	}
	public static int[] dy = { -1 ,0 ,1 ,0};
	public static int[] dx = { 0,1,0,-1};
	private static void bfs(int y, int x) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(y,x));
		visited[y][x] = true;

		Node cur;
		while(!q.isEmpty())
		{
			cur = q.poll();

			for(int i = 0 ; i < 4 ; i++)
			{
				int ty = dy[i] + cur.y;
				int tx = dx[i] + cur.x;
				if(0 <= ty && ty < R && 0 <= tx && tx < C
						&& arr[ty][tx] == 'x' && !visited[ty][tx])
				{
					q.add(new Node(ty,tx));
					visited[ty][tx] = true;
				}
			}

			list.add(cur);
		}
	}
	private static void play(int loc, int dir, int idx) {
		int rloc = loc;
		while(0 <= rloc && rloc < N)
		{
			if(arr[idx][rloc] == 'x') {
				arr[idx][rloc] = '.';
				break;
			}
			rloc += dir;
		}
	}
}
