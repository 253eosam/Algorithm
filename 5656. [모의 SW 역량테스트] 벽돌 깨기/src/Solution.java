import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution 
{
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int N,W,H;
	public static int[][] arr,brr;
	public static Stack<Node> delList, realDelList;
	public static boolean[][] del;
	public static int stoi(String str) {return Integer.parseInt(str); }
	public static void main(String[] args) throws IOException
	{
		int T = stoi(br.readLine());
		for(int tNum =1 ; tNum <= 1 ; tNum++)
		{
			input();
			logic();
			print(tNum);
		}//for tNum
	}//main
	private static void print(int t) throws IOException {
		bw.append("#" +t+ " " +solv + "\n");
		bw.flush();
	}
	private static void logic() {
			com(0,N);
	}
	public static int[] pick;
	public static int solv;
	public static void copyArr()
	{
		for(int i = 0 ; i < H ; i++)
			for(int j = 0 ; j < W ; j++)
				brr[i][j] = arr[i][j];
	}
	private static void com(int idx , int target) {	// W만큼 완탐
		if(idx == target)
		{
			copyArr();
			delList = new Stack<>();
			realDelList = new Stack<>();
			for(int i = 0 ; i < target ; i++)
			{
				play(pick[i]);
				toBottom();
			}
			if(solv < realDelList.size())
			{
				System.out.println();
				for(int i = 0 ; i < target ; i++)
				{
					System.out.print(pick[i] + " ");
				}
				System.out.println();
				test();
				solv = Math.max(solv, remainCnt());
				System.out.println("solv :" + solv);
			}
			return;
		}
	
		for(int i = 0 ; i < W ; i++)
		{
			pick[idx] = i;
			com(idx+1 , target);
		}
	}
	public static int remainCnt()
	{
		int cnt = 0;
		for(int i = 0 ; i < H ; i++)
		{
			for(int j = 0 ; j < W ; j++)
			{
				if(brr[i][j] > 0) cnt++;
			}
		}
		return cnt;
	}
	private static void play(int idx) { // 공 낙하
		
		for(int i = 0 ; i < H ; i++)
		{
			if(arr[i][idx] != 0)
			{
				delList.add(new Node(i,idx,arr[i][idx]));
				break;
			}
		}
		Node t=null;
		while(!delList.isEmpty())
		{
			t=delList.pop();
			realDelList.add(t);
			brr[t.y][t.x] = 0;
			range(t);
		}
	}
	public static void toBottom()
	{
		for(int i = 0 ; i < W ; i++)
		{
			Queue<Node> q = new LinkedList<>();
			for(int j = 0 ; i < H ; i++)
			{
				if(brr[i][j] != 0 )
				{
					q.add(new Node(i,j,brr[i][j]));
				}
			}
			
			for(int j = 0 ; i < H ; i++)
				brr[i][j] = 0;
			for(int j = 0 ; i < H ; i++)
			{
				brr[i][j] = q.poll().val;
				if(q.isEmpty()) break;
			}
			
		}
	}
	public static void test()
	{
		for(int i = 0 ; i < H ; i++)
		{
			for(int j = 0 ; j < W ; j++)
			{
				System.out.print(brr[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void range(Node n)
	{
		if(n.val == 1) return;
		int hh = n.y + n.val -1;
		int h = n.y - n.val -1;
		int w = n.x - n.val -1;
		int ww = n.x + n.val -1;
		// 아래 삭제
		for(int i = h ; i <= hh ; i++)
		{
			if(!(0 <= i && i < H )) continue; 
			Node tmp = new Node(i,n.x,arr[i][n.x]);
			if(brr[tmp.y][tmp.x] != 0)
				delList.add(tmp);
		}
		
		//가로 삭제
		for(int i = w ; i <= ww ; i++)
		{
			if(!( 0 <= i && i < W)) continue; 
			Node tmp = new Node(n.y,i,arr[n.y][i]);
			if(brr[tmp.y][tmp.x] != 0)
				delList.add(tmp);
		}
	}
	private static void input() throws IOException {
		st=new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		W = stoi(st.nextToken());
		H = stoi(st.nextToken());
		
		arr = new int[H][W];
		brr = new int[H][W];
		solv = 0;
		for(int i = 0 ; i < H ; i++)
		{
			st=new StringTokenizer(br.readLine());
			for(int j = 0 ; j < W ; j++)
			{
				arr[i][j] = stoi(st.nextToken());
			}
		}
		delList = new Stack<>();
		realDelList = new Stack<>();
		pick = new int[N];
		del = new boolean[H][W];
	}



	public static class Node 
	{
		int y,x,val;

		public Node(int y, int x, int val) {
			super();
			this.y = y;
			this.x = x;
			this.val = val;
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", val=" + val + "]";
		}

	}
}
