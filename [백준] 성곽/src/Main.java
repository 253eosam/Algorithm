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
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	
	public static int N,M,roomNum, sumRoomWeight, maxRoomWeight;
	public static int[][] arr,brr;
	public static boolean[][] visited;
	public static ArrayList<Integer> roomWeight;
	public static class Pos{
		int y,x;

		public Pos(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			return "Pos [y=" + y + ", x=" + x + "]";
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		input();
		logic();
		print();
	}

	private static void print() throws IOException {
		bw.append(roomNum + "\n");
		bw.append(maxRoomWeight + "\n");
		bw.append(sumRoomWeight + "\n");
		bw.flush();
	}

	private static void logic() {
		for(int i = 0 ; i < N ; i ++) {
			for(int j = 0 ; j < M ; j++) {
				if(visited[i][j]) continue;
				BFS(i,j,++roomNum);
			}
		}
		
		for(int y = 0 ; y < N ; y++) {
			for(int x = 0 ; x < M ; x++) {
				for(int i = 0 ; i < 4 ; i++) {
					int ty = dy[i] + y;
					int tx = dx[i] + x;
					if(0 <= ty && ty < N && 0 <= tx && tx < M
							&& brr[y][x] != brr[ty][tx]) {
						int w = roomWeight.get(brr[y][x] -1) + roomWeight.get(brr[ty][tx] -1);
						sumRoomWeight = Math.max(sumRoomWeight, w);
					}
				}
			}
		}
	}
	public static int[] dy = {0,-1,0,1};
	public static int[] dx = {-1,0,1,0};
	private static void BFS(int y, int x, int cnt) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(y,x));
		visited[y][x] = true;
		int weight = 0;
		while(!q.isEmpty()) {
			Pos p = q.poll();
			weight++;
			brr[p.y][p.x] = cnt;
			int val = arr[p.y][p.x];
			
			
			for(int i = 0 ; i < 4 ; i++) {
				int idx = 1 << i;
				if((idx&val) != idx) {
					int ty = dy[i] + p.y;
					int tx = dx[i] + p.x;
					if(0 <= ty && ty < N && 0 <= tx && tx < M && !visited[ty][tx]) {
						q.add(new Pos(ty,tx));
						visited[ty][tx] = true;
					}
				}
			}
		}// while : q is not empty
		roomWeight.add(weight);
		maxRoomWeight = Math.max(weight, maxRoomWeight);
	}

	private static void input() throws IOException {
		st=new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		brr = new int[N][M];
		visited = new boolean[N][M];
		roomNum = sumRoomWeight = maxRoomWeight = 0;
		roomWeight = new ArrayList<>();
		
		for(int i = 0 ; i < N ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}