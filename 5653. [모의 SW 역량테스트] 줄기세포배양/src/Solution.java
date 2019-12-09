import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution 
{
	/*
	 * 1. 퍼지기
	 * 2. 동시 퍼질경우 가장 큰 세포
	 * 3. 비활성 상태의 세포
	 */
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static boolean[][] visited;
	public static int[][] arr,brr;
	public static PriorityQueue<Node> pq;
	public static class Node implements Comparable<Node>
	{
		int y,x,cnt,realCnt;

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", cnt=" + cnt + ", realCnt=" + realCnt + "]";
		}


		public Node(int y, int x, int cnt, int realCnt) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.realCnt = realCnt;
		}


		@Override
		public int compareTo(Node o) {
			return this.cnt - o.cnt;
		}
		
	}
	public static int stoi(String str) { return Integer.parseInt(str); }
	public static int N,M,K,solv,NN,MM,count;
	public static void main(String[] args) throws IOException
	{
		int T = stoi(br.readLine());
		for(int tNum = 1 ; tNum <= 1 ; tNum++)
		{
			input();
			logic();
			print(tNum);
		}
	}
	private static void input() throws IOException {
		st=new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		K = stoi(st.nextToken());
		NN = N + (2*K) ; MM = M + (2*K);
		pq = new PriorityQueue<Node>();
		visited = new boolean[NN][MM];
		solv = 0; count=0;
		arr = new int[NN][MM];
		brr = new int[NN][MM];
		for(int i = K ; i < N+K ; i++)
		{
			st=new StringTokenizer(br.readLine());
			for(int j = K ; j < M+K ; j++)
			{
				int tmp = stoi(st.nextToken());
				brr[i][j] = arr[i][j] = tmp;
				if(tmp == 0)
					visited[i][j] = false;
				else {
					visited[i][j] = true;
					pq.add(new Node(i,j,tmp+1,tmp));
				}
			}
		}
		
	}
	public static void print(int tNum) throws IOException
	{
		for(int i = 0 ; i < NN ; i++)
			for(int j = 0 ; j < MM ; j++)
					if(visited[i][j])
						solv++;
		
		bw.write("#"+tNum+" "+solv+"\n");
		bw.flush();
	}
	private static void logic() {
	}
	public static int[] dy = { -1 , 0 , 1 , 0 };
	public static int[] dx = {  0 , 1 , 0 ,-1 };
	
}
