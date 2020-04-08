import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main 
{
	public static int N,M;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int[][] dis;
	public static final int INF = Integer.MAX_VALUE;
	public static int[] solv;
	public static int stoi(String str) { return Integer.parseInt(str); }
	public static void main(String[] args) throws Exception
	{
		init();
		makeINF();
		input();
		
		ployd();
		print();
		bw.close();
	}
	public static void print() throws Exception
	{
		for(int i = 1 ; i <= N ; i++)
		{
			for(int j = 1 ; j <= N ; j++)
			{
				if(i == j) continue;
				if(dis[i][j] != INF || dis[j][i] != INF) continue;
					solv[i]++;
			}
		}
		
		for(int i = 1 ; i <= N ; i++)
			bw.write(solv[i] + "\n");
	}
	public static void ployd()
	{
		for(int m = 1 ; m <= N ; m++)
		{
			for(int a = 1 ; a <= N ; a++)
			{
				for(int b = 1 ; b <= N ; b++)
				{
					if(dis[a][m] == INF || dis[m][b] == INF) continue;
					if(dis[a][b] > dis[a][m] + dis[m][b])
					{
						dis[a][b] = dis[a][m] + dis[m][b];
					}
				}
			}
		}
	}
	public static void input() throws Exception
	{
		for(int i = 0 ; i < M ; i++)
		{
			st = new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken());
			int b = stoi(st.nextToken());
			dis[a][b] = 1;
		}
	}
	public static void init() throws Exception
	{
		N = stoi(br.readLine());
		M = stoi(br.readLine());
		
		dis = new int[N+1][N+1];
		solv = new int[N+1];
	}
	public static void makeINF()
	{
		for(int i = 1 ; i <= N ; i ++)
		{
			for(int j = 1 ; j <= N ; j++)
			{
				if(i == j) continue;
				dis[i][j] = INF;
			}
		}
	}
}
