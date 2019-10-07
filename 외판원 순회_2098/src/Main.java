import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int N;
	public static int[][] w;
	public static int[][] dp;
	public static int stoi(String str) { return Integer.parseInt(str); }
	public static final int INF = Integer.MAX_VALUE - 1_000_000_000;
	public static void main(String[] args) throws Exception 
	{
		N = stoi(br.readLine());
		
		//init
		w = new int[N][N];
		dp = new int[N][(1<<N)];
		for(int i = 0 ; i < N ; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < w[i].length ; j++)
				w[i][j] = stoi(st.nextToken());
		}
		for(int i = 0 ; i < N ; i++)
			for(int j = 0 ; j < dp[i].length ; j++)
				dp[i][j] = -1;
		
		int solv = TSP(0,0,1); 
		bw.write(String.valueOf(solv));
		bw.flush();
		bw.close();
	}
	public static int TSP(int cur, int size, int b)
	{
		if(dp[cur][b] != -1) return dp[cur][b];
		
		if(size == N-1 && b == (1 << N)-1)
			return dp[cur][b] = w[cur][0] != 0 ? w[cur][0] : INF;
		
		dp[cur][b] = INF;
		for(int i = 0 ; i < N ; i++)
		{
			if(w[cur][i] != INF && (b & (1<<i)) == 0 && w[cur][i] != 0)
				dp[cur][b] = Math.min(dp[cur][b],TSP(i,size+1,b | (1 << i)) + w[cur][i]) ;
		}
		
		return dp[cur][b];
	}

}
