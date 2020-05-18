import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int[][] arr;
	public static Queue<Pos> q;
	public static int R, C, T;
	public static Pos[] airs;

	public static class Pos {
		int y, x, v;

		public Pos(int y, int x, int v) {
			super();
			this.y = y;
			this.x = x;
			this.v = v;
		}

		@Override
		public String toString() {
			return "Pos [y=" + y + ", x=" + x + ", v=" + v + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		input();
		logic();
	}

	private static void logic() throws IOException {
		for (int tc = 0; tc < T; tc++) {

			q = inspecDust();
			arr = spread();

//			for (int i = 0; i < R; i++)
//				System.out.println(Arrays.toString(arr[i]));
			arr = move(arr);
//			System.out.println();
//			for (int i = 0; i < R; i++)
//				System.out.println(Arrays.toString(arr[i]));
//			System.out.println();
		}
		bw.append(String.valueOf(sumDust()));
		bw.close();
	}

	public static int sumDust() {
		int sum = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] == -1)
					continue;
				sum += arr[i][j];
			}
		}
		return sum;
	}

	private static int[][] move(int[][] arr) {
		int[][] tmpArr = arr.clone();
		int row = airs[0].y;
		for (int i = row; i > 0; i--)
			tmpArr[i][0] = tmpArr[i - 1][0];
		for (int i = 0; i < C - 1; i++)
			tmpArr[0][i] = tmpArr[0][i + 1];
		for (int i = 0; i < row; i++)
			tmpArr[i][C - 1] = tmpArr[i + 1][C - 1];
		for (int i = C - 1; i > 0; i--)
			tmpArr[row][i] = tmpArr[row][i - 1];
		tmpArr[row][1] = 0;
		
		row = airs[1].y;
		for (int i = row; i < R - 1; i++)
			tmpArr[i][0] = tmpArr[i + 1][0];
		for (int i = 0; i < C - 1; i++)
			tmpArr[R - 1][i] = tmpArr[R - 1][i + 1];
		for (int i = R - 1; i > row; i--)
			tmpArr[i][C - 1] = tmpArr[i - 1][C - 1];
		for (int i = C - 1; i > 0; i--)
			tmpArr[row][i] = tmpArr[row][i - 1];
		tmpArr[row][1] = 0;
		
		for (Pos p : airs)
			tmpArr[p.y][p.x] = p.v;
		return tmpArr;
	}

	public static int[] dy = { -1, 0, 1, 0 };
	public static int[] dx = { 0, 1, 0, -1 };

	public static int[][] spread() {
		int[][] tmpArr = new int[R][C];
		while (!q.isEmpty()) {
			Pos p = q.poll();
			int dir = 0;
			int val = arr[p.y][p.x] / 5;
			for (int i = 0; i < dy.length; i++) {
				int ty = dy[i] + p.y;
				int tx = dx[i] + p.x;
				if (0 <= ty && ty < R && 0 <= tx && tx < C && arr[ty][tx] != -1) {
					dir++;
					tmpArr[ty][tx] += val;
				}
			}
			tmpArr[p.y][p.x] += arr[p.y][p.x] - (val * dir);
		}
		for (Pos p : airs)
			tmpArr[p.y][p.x] = p.v;
		return tmpArr;
	}

	private static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		arr = new int[R][C];
		q = new LinkedList<>();
		airs = new Pos[2];

		int idx = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == -1)
					airs[idx++] = new Pos(i, j, -1);
			}
		}
	}

	public static Queue<Pos> inspecDust() {
		Queue<Pos> q = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				int tmp = arr[i][j];
				if (tmp <= 0)
					continue;
				q.add(new Pos(i, j, tmp));
			}
		}
		return q;
	}
}
