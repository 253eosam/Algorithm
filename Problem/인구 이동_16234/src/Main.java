import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int N,L,R;
	public static int[][] arr,brr;
	public static boolean[][] visited;
	public static boolean[][][] open;
	public static int solv;
	public static int stoi(String str) { return Integer.parseInt(str); }
	public static void main(String[] args) throws Exception 
	{
		input();
		logic();
		print();
	}
	private static void print() throws IOException {
		bw.write(String.valueOf(solv));
		bw.flush();
	}
	public static class Node{
		int y,x;

		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + "]";
		}

	}
	public static boolean equalAB() 
	{
		for(int i = 0 ; i < N ; i++)
		{
			for(int j = 0 ; j < N ; j++)
			{
				if(arr[i][j] != brr[i][j])
					return false;
			}
		}
		return true;
	}
	private static void logic() {
		while(true)
		{
			visited = new boolean[N][N];
			open = new boolean[N][N][4];

			for(int i = 0 ; i < N ; i++)
			{
				for(int j = 0 ; j < N ; j++)
				{
					searchingTeam(i,j);
				}
			}

			for(int i = 0 ; i < N ; i++)
			{
				for(int j  = 0 ; j < N ; j++)
				{
					if(!visited[i][j]) 
					{
						bfs(i,j);
					}
				}
			}
			if(equalAB()) break;
			copyArr();
			solv++;
		}
	}
	public static void copyArr()
	{
		for(int i = 0 ; i < N ; i++)
			for(int j = 0 ; j < N ; j++)
				brr[i][j] = arr[i][j];
	}
	private static void searchingTeam(int y, int x) {
		for(int i = 0 ; i < 4; i++)
		{
			int ty = dy[i] + y;
			int tx = dx[i] + x;
			if(0 <= ty && ty < N && 0 <= tx && tx < N)
			{
				int tmp = Math.abs(arr[y][x]-arr[ty][tx]);
				if(L <= tmp && tmp <= R)
					open[y][x][i] = true;
			}
		}
	}
	private static void bfs(int y , int x ) {
		Queue<Node> q = new LinkedList<>();
		Queue<Node> qq = new LinkedList<>();
		q.add(new Node(y,x));
		visited[y][x] = true;
		int cnt = 1;
		int sum = arr[y][x];

		Node cur;
		while(!q.isEmpty())
		{
			cur = q.poll();
//			System.out.println(cur);

			for(int i = 0 ; i < 4 ; i++)
			{
				int ty = dy[i] + cur.y;
				int tx = dx[i] + cur.x;
				if(0 <= ty && ty < N && 0 <= tx && tx < N && !visited[ty][tx] && open[cur.y][cur.x][i])
				{
					visited[ty][tx] = true;
					q.add(new Node(ty,tx));
					sum += arr[ty][tx];
					cnt++;
				}
			}

			qq.add(cur);
		}// q not empty

		int val = (int)(sum/cnt);
		while(!qq.isEmpty())
		{
			cur = qq.poll();
			arr[cur.y][cur.x] = val;
		}

	}//bfs
	public static int[] dy = { -1,0,1,0};
	public static int[] dx = { 0,1,0,-1};
	private static void input() throws IOException {
		st=new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		L = stoi(st.nextToken());
		R = stoi(st.nextToken());
		solv = 0;
		arr = new int[N][N];
		brr = new int[N][N];
		visited = new boolean[N][N];
		open = new boolean[N][N][4];

		for(int i = 0 ; i < N ; i++)
		{
			st=new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++)
			{
				brr[i][j] = arr[i][j] = stoi(st.nextToken());
			}
		}
	}

}
