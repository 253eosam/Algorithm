
import java.util.Arrays;

public class TSP_DPTest {
	static int N;
	static int[][] W;

	static final int INF = 100000000;
	static final int START = 0;
	static int[][] dp ;

	public static void main(String[] args) {
		N = 4;
		W = new int[N][N];
		dp = new int[N][1 << N];
		for(int[] a : W) {
			Arrays.fill(a, INF);
		}
		W[0][1] = 2;
		W[0][2] = 9;
		W[1][0] = 1;
		W[1][2] = 6;
		W[1][3] = 4;
		W[2][1] = 7;
		W[2][3] = 8;
		W[3][0] = 6;
		W[3][1] = 3;
		for(int i = 0 ; i < N; i++) {
			W[i][i] = 0;
		}
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1);
		}
		System.out.println(solve(START,  1<<START));
	}
	static int solve(int cur, int B) {
		System.out.println("cur : " + cur + ", B : " + B );
		// memoization
		if (dp[cur][B] != -1) return dp[cur][B];

		// 기저 조건, 모든 마을을 방문하고 시작점(0)으로 되돌아가야 하는 경우
		if (B == (1 << N) - 1) {
			System.out.println("=====================");
			return dp[cur][B] = W[cur][START] != INF ? W[cur][START] : INF;
		}

		// 하위 문제
		dp[cur][B] = INF;
		for (int i = 0; i < N; i++) {

			// 갈 수 없거나, 방문했던 마을이라면
			if (W[cur][i] == INF || (B & (1 << i)) > 0) continue;
			
			System.out.println( B | (1 << i));
			dp[cur][B] = Math.min(dp[cur][B], solve(i, B | (1 << i)) + W[cur][i]);
		}

		return dp[cur][B];
	}
}
