import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main 
{
	/*
	 * 원형 큐를 이용하여 양 방향의 극을 관리
	 * 1. 시계방향 반시계방향
	 * 2. 극 초기화
	 * 3. 화살표 점수 측정 .. 큐의 인덱스를 매개변수로 넘겨주고 
	 * 	큐의 포인트 지점이 S극을 가르키면 점수를 반납하는 방식
	 */
	public static class Node
	{
		boolean s;
		Node next;
		Node pre;
		public Node(boolean s) {
			this.s = s;
		}
		public Node() {}
	}
	public static class CircleQueue
	{
		Node left,right,point;
		Node target;	// 값을 주입하기위한 포인트
		int size;
		public CircleQueue() {
			left = new Node();
			right = new Node();
			point = new Node();
			right = new Node();
			size = 0;
		}
		public void add(Node n)
		{
			size++;
			if(size == 1)
			{
				target = point = n;
				point.next = point.pre = target;
				target.next = target.pre = point;
				return;
			}
			n.pre = target;
			target.next = n;
			n.next = point;
			point.pre = n;
			target = n;
			
			if(size == 3)
				right = n;
			else if(size == 7)
				left = n;
		}
		public void print()
		{
			System.out.println();
			Node tmp = point;
			System.out.println("left " + left.s + ", right : "+ right.s);
			while(tmp != target)
			{
				System.out.print((tmp.s?"1":"0") + " ");
				tmp = tmp.next;
			}
			System.out.print((tmp.s?"1":"0") + " ");
			System.out.println();
		}
		public void rotate()
		{
			point = point.next;
			left = left.next;
			right = right.next;
			target = target.next;
		}
		public void derotate()
		{
			point = point.pre;
			left = left.pre;
			right = right.pre;
			target = target.pre;
		}
		
	}
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int K;
	public static CircleQueue[] cq;
	public static int[] arr,brr;
	public static final int SIZE= 4;
	public static boolean[] visited;
	public static int solv;
	public static int stoi(String str) { return Integer.parseInt(str); }
	public static void main(String[] args) throws Exception
	{
			input();
			logic();
			print();
		
	}
	private static void print() throws IOException {
		for(int i = 0 ; i < SIZE ; i++)
			if(cq[i].point.s)
				solv += (1 << i);
		bw.write(String.valueOf(solv));
		bw.flush();
	}
	private static void logic() {
		for(int i = 0 ; i < K ; i++)
		{
			visited = new boolean[4];
			dfs(arr[i]-1, brr[i]);
			
		}
	}
	private static void dfs(int index, int t) {
		
		if(visited[index]) return;
		visited[index] = true;
		int tx;
		// 왼쪽
		tx = index -1;
		if(0 <= tx && tx < SIZE) {
			if(cq[tx].right.s != cq[index].left.s) dfs(tx,-t);
		}
		
		//오른쪽
		tx = index + 1;
		if(0 <= tx && tx < SIZE) {
			if(cq[tx].left.s != cq[index].right.s) dfs(tx,-t);
		}
		
		if(t == -1)
			cq[index].rotate();
		else
			cq[index].derotate();
		
	}
	private static void input() throws IOException {
		cq = new CircleQueue[SIZE];
		for(int i = 0 ; i < SIZE ; i++)
			cq[i] = new CircleQueue();
		
		solv = 0;
		
		for(int i = 0 ; i < SIZE ; i++)
		{
			String tmp = br.readLine();
			for(int j = 0 ; j < tmp.length() ; j++)
			{
				int val = tmp.charAt(j)-'0';
				boolean isS = (val == 1);
				cq[i].add(new Node(isS));
			}
		}
		
		K = stoi(br.readLine());
		arr=new int[K];
		brr=new int[K];
		
		for(int i = 0 ; i < K ; i++)
		{
			st = new StringTokenizer(br.readLine());
			arr[i] = stoi(st.nextToken());
			brr[i] = stoi(st.nextToken());
		}
		
	}
}
