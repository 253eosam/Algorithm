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

	public static int N, answer;
	public static int[][] arr;
	public static boolean[][][] visited;
	public static Pos S, T;

	public static class Pos {
		int y, x, c;
		boolean row;

		public Pos(int y, int x, int c, boolean row) {
			super();
			this.y = y;
			this.x = x;
			this.c = c;
			this.row = row;
		}

		@Override
		public String toString() {
			return "Pos [y=" + y + ", x=" + x + ", c=" + c + ", row=" + row + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		input();
		logic();
		print();
	}

	private static void print() throws IOException {
		bw.append(String.valueOf(answer));
		bw.flush();
	}

	private static void logic() {
		BFS();
	}

	public static int[] dy = { -1, 0, 1, 0, -1, -1, 1, 1 };
	public static int[] dx = { 0, 1, 0, -1, -1, 1, 1, -1 };

	private static void BFS() {
		Queue<Pos> q = new LinkedList<>();
		q.add(S);
		visited[S.y][S.x][S.row ? 0 : 1] = true;

		while (!q.isEmpty()) {
			Pos p = q.poll();
//			System.out.println(p);
			if (p.y == T.y && p.x == T.x && p.row == T.row) {
				answer = p.c;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int ty = dy[i] + p.y;
				int tx = dx[i] + p.x;
				if (p.row) {
					if (0 <= ty && ty < N && 0 <= tx - 1 && tx + 1 < N && !visited[ty][tx][p.row ? 0 : 1]
							&& arr[ty][tx - 1] != 1 && arr[ty][tx] != 1 && arr[ty][tx + 1] != 1) {
						q.add(new Pos(ty, tx, p.c + 1, p.row));
						visited[ty][tx][p.row ? 0 : 1] = true;
					}
				} else {
					if (0 <= ty - 1 && ty + 1 < N && 0 <= tx && tx < N && !visited[ty][tx][p.row ? 0 : 1]
							&& arr[ty - 1][tx] != 1 && arr[ty][tx] != 1 && arr[ty + 1][tx] != 1) {
						q.add(new Pos(ty, tx, p.c + 1, p.row));
						visited[ty][tx][p.row ? 0 : 1] = true;
					}
				} // col
			} // 동서남북 이동

			if (!visited[p.y][p.x][(!p.row) ? 0 : 1]) {
				for (int i = 0; i < 8; i++) {
					int ty = dy[i] + p.y;
					int tx = dx[i] + p.x;
					boolean flag = false;
					if (0 <= ty && ty < N && 0 <= tx && tx < N && arr[ty][tx] != 1) {
						flag = true;
					}
					if (!flag)
						break;
					if (i == 7 && flag) {
						q.add(new Pos(p.y, p.x, p.c + 1, !p.row));
						visited[p.y][p.x][(!p.row) ? 0 : 1] = true;
					}
				} // turn
			}
		}
	}

	private static void input() throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N][N][2];
		arr = new int[N][N];
		answer = 0;
		int flagB = 0, flagE = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				char c = str.charAt(j);
				if (c == 'B') {
					arr[i][j] = 2;
					if (++flagB == 2) {
						if (0 <= i - 1 && arr[i - 1][j] == 2)
							S = new Pos(i, j, 0, false);
						else
							S = new Pos(i, j, 0, true);
					}
				} else if (c == 'E') {
					arr[i][j] = 3;
					if (++flagE == 2) {
						if (0 <= i - 1 && arr[i - 1][j] == 3)
							T = new Pos(i, j, 0, false);
						else
							T = new Pos(i, j, 0, true);
					}
				} else
					arr[i][j] = c - '0';
			}
		}
	}

}
