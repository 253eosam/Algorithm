import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;

	public static int N, answer;

	public static class Pos {
		int s, w;

		public Pos(int s, int w) {
			super();
			this.s = s;
			this.w = w;
		}

		@Override
		public String toString() {
			return "Pos [s=" + s + ", w=" + w + "]";
		}

	}

	public static Pos[] posList;

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
		dfs(0);
	}

	private static void dfs(int idx) {
		if (idx == N) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (posList[i].s <= 0)
					cnt++;
			}
			if (answer < cnt)
				answer = cnt;
			return;
		}

		if (posList[idx].s <= 0)
			dfs(idx + 1);
		else {
			for (int i = 0; i < N; i++) {
				if (i == idx || posList[i].s <= 0)
					continue;
				posList[idx].s -= posList[i].w;
				posList[i].s -= posList[idx].w;
				dfs(idx + 1);
				posList[idx].s += posList[i].w;
				posList[i].s += posList[idx].w;
			}
			dfs(N);	// 강제로 계산하기
		}

	}

	private static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		posList = new Pos[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			posList[i] = new Pos(a, b);
		}
	}

}

/*
 * 
 * 계란을 왼쪽부터든다. 남아있는 계란? 혹은 다른 계란을 친다.
 */
