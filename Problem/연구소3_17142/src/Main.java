import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int[] picked;
	public static int N,M;
	public static int solv;
	public static int[][] arr;
	public static boolean[][] visited;
	public static ArrayList<Node> targets,notargets;
	public static Queue<Node> q;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int stoi(String str) { return Integer.parseInt(str); }
	public static class Node
	{
		int y,x,cnt;
		public Node(int y, int x, int cnt) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", cnt=" + cnt + "]";
		}
		
	}
	public static void main(String[] args) throws Exception
	{
		input();
		logic();
		print();
	}
	private static void print() throws IOException {
		if(solv == Integer.MAX_VALUE)
			bw.write("-1");
		else
			bw.write(String.valueOf(solv));
		bw.flush();
	}
	private static void input() throws IOException {
		st=new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		arr=new int[N][N];
		picked = new int[M];
		solv= Integer.MAX_VALUE;
		targets = new ArrayList<>();
		notargets = new ArrayList<>();
		for(int i = 0 ; i < N ; i++)
		{
			st=new StringTokenizer(br.readLine());
			for(int j = 0; j < N ; j++)
			{
				int tmp = stoi(st.nextToken());
				if(tmp == 2)
					targets.add(new Node(i,j,0));
				else if(tmp == 0)
					notargets.add(new Node(i,j,0));
				arr[i][j] = tmp;
			}
		}
	}
	private static void logic() {
		if(notargets.size() == 0)
			solv = 0;
		else
			com(0,0,M);
	}
	private static void com(int deep , int cur, int target) {
		if(deep == target)
		{
			visited=new boolean[N][N];
			q=new LinkedList<>();
			for(int i = 0 ; i < target ; i++)
			{
				Node tmp = targets.get(picked[i]);
				q.add(tmp);
				visited[tmp.y][tmp.x] = true;
			}
			bfs();
			
			return;
		}
		
		for(int i = cur ; i < targets.size() ; i++)
		{
			picked[deep] = i;
			com(deep+1,i+1,target);
		}
	}
	public static int[] dy = { -1,0,1,0};
	public static int[] dx = {  0,1,0,-1};
	private static void bfs() {
		Node cur = null;
		int  num = 0;
		int val = 0;
		while(!q.isEmpty())
		{
			cur = q.poll();
			
			
			for(int i = 0 ;i <4 ; i ++)
			{
				int ty = dy[i] + cur.y;
				int tx = dx[i] + cur.x;
				if(0 <= ty && ty <N && 0 <= tx && tx <N
						  && arr[ty][tx] != 1 && !visited[ty][tx])
				{
					visited[ty][tx] = true;
					q.add(new Node(ty,tx,cur.cnt+1));
					if(arr[ty][tx] == 0)
						num++;
				}
			}
			if(num == notargets.size())
			{
				val = cur.cnt+1;
				break;
			}
		}
		
		if(num == notargets.size() && solv > val)
		{
			solv = val;
		}
		
	}
	
}
