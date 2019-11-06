//import java.util.Arrays;
//import java.util.StringTokenizer;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//class Main {
//	public static void main(String args[]) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int n = Integer.parseInt(br.readLine().trim());
//		int[][] dp = new int[n][n];
//		dp[0][0] = Integer.parseInt(br.readLine().trim());
//		for(int i=1; i<n; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine().trim());
//			for(int j=0; j<=i; j++) {
//				dp[i][j] = Integer.parseInt(st.nextToken());
//				
//				if(j==0) {
//					dp[i][j] += dp[i-1][j];
//				}else if(j==i) {
//					dp[i][j] += dp[i-1][j-1];
//				}else {
//					dp[i][j] += Math.max(dp[i-1][j], dp[i-1][j-1]);
//				}
//				
//			}
//			
//		}
//		int max = -1;
//		for(int i=0; i<n; i++) if(max<dp[n-1][i]) max = dp[n-1][i];
//		System.out.println(max);
//	}
//}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
	static int N;
	static int K;
	static int[] dy = {0, 0, -1, 1};
	static int[] dx = {1, -1, 0, 0};
	static int[][] map;
	static int[][] mapdepth;
	static ArrayList<Node> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		mapdepth = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}//맵 입력완료
		list = new ArrayList<Node>();

		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			int d = Integer.parseInt(st.nextToken())-1;

			list.add(new Node(y, x, d, 1));
			mapdepth[y][x]++;
		}
		dfs(1);
	}
	private static void dfs(int time) {
		System.out.println(time+"=======================");
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(mapdepth[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("=======================");
		System.out.println("번쨰,y좌표,x좌표,방향,높이");
		for(int i=0; i<list.size(); i++) {
			System.out.println(i+"   "+list.get(i).y+"   "+list.get(i).x+"   "+list.get(i).d+"   "+list.get(i).depth);
		}
		System.out.println("=======================");

		if(time>1000) {
			System.out.println(-1);
			return;
		}
		for(int i=0; i<list.size(); i++) {
			Node n  = list.get(i);
			if(n.depth==1) {
				if(!isRange(n.y+dy[n.d], n.x+dx[n.d]) || map[n.y+dy[n.d]] [n.x+dx[n.d]]==2) {
					if(n.d%2==0) n.d++;
					else n.d--;
				}

				if(!isRange(n.y+dy[n.d], n.x+dx[n.d]) || map[n.y+dy[n.d]][n.x+dx[n.d]]==2) {
					continue;
				}else {
					//				System.out.println(n.depth);
					if(n.depth==1) {
						Queue<Node> tempque = new LinkedList<Node>();

						for(int j=0; j<list.size(); j++) {
							if(n.y==list.get(j).y && n.x==list.get(j).x) {
								tempque.add(list.get(j));
							}
						}
						int size = tempque.size();

						if(mapdepth[n.y+dy[n.d]][n.x+dx[n.d]] + tempque.size()>=4) {
							System.out.println(time);

							return;
						}
						if(map[n.y+dy[n.d]][n.x+dx[n.d]]==0) {
							while(!tempque.isEmpty()) {
								Node tempn = tempque.poll();
								tempn.y += dy[n.d];
								tempn.x += dx[n.d];
								tempn.depth += mapdepth[tempn.y][tempn.x];

							}
						}else {
							while(!tempque.isEmpty()) {
								Node tempn = tempque.poll();
								tempn.y += dy[n.d];
								tempn.x += dx[n.d];
								tempn.depth = mapdepth[tempn.y][tempn.x] + size +1 - tempn.depth;
								//							System.out.println(tempn.depth+"hi");
							}
						}
						mapdepth[n.y-dy[n.d]][n.x-dx[n.d]] -= size;
						mapdepth[n.y][n.x] += size;

					}
				}
			}

		}
		dfs(time+1);

	}
	private static boolean isRange(int i, int j) {
		if(i>=0 && j>=0 && i<N && j<N) return true;
		return false;
	}
}
class Node{
	int y;
	int x;
	int d;
	int depth;

	public Node() {	}
	public Node(int y, int x, int d, int depth) {
		super();
		this.y = y;
		this.x = x;
		this.d = d;
		this.depth = depth;
	}

}