import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int N,M,vertex;
	public static int[][] arr;
	public static boolean[][] visited;
	public static ArrayList<Node> edges;
	public static int stoi(String str) { return Integer.parseInt(str); }
	public static boolean DEBUG = false;
	public static int[] p;
	public static int solv;
	public static void main(String[] args) throws Exception
	{
		//init
		st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		vertex = 1;	// 섬 갯수
		edges = new ArrayList<Node>();
		for(int i = 0 ; i < N ; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++)
			{
				arr[i][j] = stoi(st.nextToken());
			}
		}
		
		for(int i = 0 ; i < N ; i++)
		{
			for(int j = 0 ; j < M ; j++)
			{
				if(!visited[i][j] && arr[i][j] == 1)
				{
					dfs(i,j);
					vertex++;
				}
			}
		}
		
		if(DEBUG)
		{
			System.out.println();
			System.out.println("섬 지도");
			for(int i = 0 ; i < N ; i++)
			{
				for(int j = 0 ; j < M ; j++)
				{
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
		
		for(int i = 0 ; i < N ; i++)
		{
			for(int j = 0 ; j < M ; j++)
			{
				if(arr[i][j] > 0)
					addEdge(i,j,arr[i][j]);
			}
		}
		Collections.sort(edges);
		
		if(DEBUG)
			System.out.println(edges);
		
		p = new int[vertex];
		makeSet(); 
		Node node = null;
		for(int i = 0 ; i < edges.size() ; i++)
		{
			node = edges.get(i);
			unionSet(node.a,node.b,node.w);
		}
		
		int error = 0;
		for(int i = 1 ; i < p.length ; i++)
		{
			if(p[i] == i) error++;
			if(error >= 2) break;
		}
		
		if(error >= 2) bw.write("-1");
		else bw.write(String.valueOf(solv));
		bw.flush();
		bw.close();
	}
	public static void makeSet()
	{
		for(int i = 1 ; i < p.length ; i++)
			p[i] = i;
	}
	public static int findSet(int x)
	{
		if(p[x] == x) return x;
		return p[x] = findSet(p[x]);
	}
	public static void unionSet(int a,int b,int w)
	{
		int pa = findSet(a);
		int pb = findSet(b);
		if(pa != pb)
		{
			p[pb] = pa;
			solv += w;
		}
	}
	public static void addEdge(int y, int x, int num)
	{
		int tmpY = y;
		int tmpX = x;
		
		//left
		while(--tmpX >= 0)
		{
			if(arr[y][tmpX] == 0) continue;
			if(arr[y][tmpX] == num) break;
			else if(arr[y][tmpX] != num) 
			{
				if(x-tmpX -1 >= 2)
				{
					edges.add(new Node(num,arr[y][tmpX],x-tmpX -1));
					break;
				}
				else
					break;
			}
		}
		
		tmpY = y;
		tmpX = x;
		//right
		while(++tmpX < M)
		{
			if(arr[y][tmpX] == 0) continue;
			if(arr[y][tmpX] == num) break;
			else if(arr[y][tmpX] != num ) 
			{
				if(tmpX-x -1 >= 2)
				{
					edges.add(new Node(num,arr[y][tmpX],tmpX-x -1));
					break;
				}
				else break;
			}
		}
		
		tmpY = y;
		tmpX = x;
		//top
		while(--tmpY >= 0)
		{
			if(arr[tmpY][x] == 0) continue;
			if(arr[tmpY][x] == num) break;
			else if(arr[tmpY][x] != num )  
			{
				if(y-tmpY -1 >= 2)
				{
					edges.add(new Node(num,arr[tmpY][x],y-tmpY -1));
					break;
				}
				else break;
			}
			
		}
		
		tmpY = y;
		tmpX = x;
		//bottom
		while(++tmpY < N)
		{
			if(arr[tmpY][x] == 0) continue;
			if(arr[tmpY][x] == num) break;
			else if(arr[tmpY][x] != num)
			{
				if(tmpY-y -1 >= 2)
				{
					edges.add(new Node(num,arr[tmpY][x],tmpY-y -1));
					break;
				}
				else break;
			}
		}
	}
	public static int[] dy = { -1, 0 , 1 , 0 };
	public static int[] dx = {  0, 1 , 0 ,-1};
	public static void dfs(int y, int x)
	{
		visited[y][x] = true;
		arr[y][x] = vertex;
		for(int i = 0 ; i < 4 ; i++)
		{
			int ty = dy[i] + y;
			int tx = dx[i] + x;
			if(0 <= ty && ty < N && 0 <= tx && tx < M &&
					!visited[ty][tx] && arr[ty][tx] == 1)
			{
				dfs(ty,tx);
			}
		}
	}
	public static class Node implements Comparable<Node>
	{
		int a,b,w;
		Node(int a, int b, int w)
		{
			this.a = a;
			this.b = b;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
		@Override
		public String toString() {
			return "Node [a=" + a + ", b=" + b + ", w=" + w + "]\n";
		}
	}

}
