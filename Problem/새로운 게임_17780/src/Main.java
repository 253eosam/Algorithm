import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static int N,K;
	public static int[][] arr;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int stoi(String str) { return Integer.parseInt(str); }
	public static ArrayList<Node>[][] visited;
	public static int solv;
	public static boolean trigger;
	public static ArrayList<Node> list;
	public static final int MAX_TEST = 1_000;
	public static class Node
	{
		public int y, x, dir, num;
		Node(int y, int x, int dir , int num)
		{
			this.y=y;
			this.x=x;
			this.dir=dir;
			this.num = num;
		}
		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", dir=" + (dir+1) + ", num=" + (num+1) + "]";
		}
	}
	public static void main(String[] args) throws Exception
	{
		init();
		logic();
		print();
	}
	private static void print() throws Exception
	{
		bw.write(String.valueOf(solv));
		bw.flush();
	}
	// 1 > , 2 < , 3 ^ , 4 v  
	// 0 white , 1 red , 2 blue
	
	public static int[] dy = {0,0,-1,1};
	public static int[] dx = {1,-1,0,0};
	private static void logic() 
	{
		
		outer:for(int t = 1 ; t <= MAX_TEST ; t++)
		{
//			test();
			for(int i = 0 ; i < list.size() ; i++)
			{
				Node node = list.get(i);
				int ty = dy[node.dir] + node.y;
				int tx = dx[node.dir] + node.x;
				
				String color = isCheckColor(ty, tx);
				play(node,color,ty,tx);
				if(trigger)
				{
					solv = t;
					break outer;
				}
			}
		}
	}
	public static void test()
	{
		for(int i = 0  ; i < N ; i++)
		{
			for(int j = 0 ; j < N ; j++)
			{
				if(visited[i][j].size()!=0)
					System.out.print((visited[i][j].get(0).num+1) +  "\t");
				else
					System.out.print(0 + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void play(Node node, String color , int ty , int tx)
	{
		int y = node.y;
		int x = node.x;
		if(visited[y][x].get(0).num != node.num) return;

		if(color.equals("white"))
		{
			for(Node n : visited[y][x])
			{
				n.y = ty;
				n.x = tx;
				list.set(n.num, n);
				visited[ty][tx].add(n);
			}
			visited[y][x].clear();
			
			if(visited[ty][tx].size() >= 4)
				trigger = true;
			
//			System.out.println("visited : " + Arrays.toString(visited[ty][tx].toArray()));
		}
		else if(color.equals("red"))
		{
			Stack<Node> stack = new Stack<>();
			for(Node n : visited[y][x])
			{
				n.y = ty;
				n.x = tx;
				list.set(n.num, n);
				stack.add(n);
			}
			while(!stack.isEmpty())
			{
				visited[ty][tx].add(stack.pop());
			}
			if(visited[ty][tx].size() >= 4)
				trigger = true;
			visited[y][x].clear();
			
			
//			System.out.println("visited : " + Arrays.toString(visited[ty][tx].toArray()));
		}
		else if(color.equals("blue"))
		{
			// 방향 반대로 변경
			if(node.dir <=1)
				node.dir = node.dir == 0 ? 1 : 0;
			else if(node.dir >= 2)
				node.dir = node.dir == 2 ? 3 : 2;
			
			int ry = dy[node.dir] + node.y;
			int rx = dx[node.dir] + node.x;
			list.set(node.num, node);
			String tmpColor = isCheckColor(ry,rx);
			if(tmpColor.equals("blue"))
				return;
			
			if(tmpColor.equals("red"))
			{
				
				Stack<Node> stack = new Stack<>();
				for(Node n : visited[y][x])
				{
					n.y = ry;
					n.x = rx;
					if(node.num == n.num) n.dir = node.dir;
					list.set(n.num, n);
					stack.add(n);
				}
				while(!stack.isEmpty())
				{
					visited[ry][rx].add(stack.pop());
				}
				visited[y][x].clear();
				if(visited[ry][rx].size() >= 4)
					trigger = true;
			}
			else if(tmpColor.equals("white"))
			{
				for(Node n : visited[y][x])
				{
					n.y = ry;
					n.x = rx;
					if(node.num == n.num) n.dir = node.dir;
					list.set(n.num, n);
					visited[ry][rx].add(n);
				}
				visited[y][x].clear();
				
				if(visited[ry][rx].size() >= 4)
					trigger = true;
			}
			
			
//			System.out.println("visited : " + Arrays.toString(visited[ry][rx].toArray()));
		}
		
	}
	public static String isCheckColor(int y ,int x)
	{
		if(0 <= y && y < N && 0 <= x && x < N)
		{
			if(arr[y][x] == 0) return "white";
			if(arr[y][x] == 1) return "red";
			if(arr[y][x] == 2) return "blue";
		}
		// 범위 밖은 파랑색
		return "blue";
	}
	public static void white()
	{
		
	}
	public static void blue()
	{
		
	}
	public static void red()
	{
		
	}
	public static void init() throws Exception
	{
		st=new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		K = stoi(st.nextToken());
		
		arr= new int[N][N];
		for(int i = 0 ; i < N ; i++)
		{
			st=new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++)
			{
				arr[i][j] = stoi(st.nextToken());
			}
		}
		visited = new ArrayList[N][N];
		for(int i = 0 ; i < N ; i++)
			for(int j = 0  ; j < N ; j++)
				visited[i][j] = new ArrayList<>();
		solv = -1;
		list = new ArrayList<>();
		trigger = false;
		
		//말들의 정보
		for(int i = 0 ; i < K ; i++)
		{
			st=new StringTokenizer(br.readLine());
			int y = stoi(st.nextToken())-1;
			int x = stoi(st.nextToken())-1;
			int dir = stoi(st.nextToken())-1;
			
			list.add(new Node(y,x,dir,i));
			visited[y][x].add(new Node(y,x,dir,i));
		}
	}
}
