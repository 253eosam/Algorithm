import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static int[][] dis;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception 
	{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dis = new int[N+1][N+1];
		init();
		for(int i = 0 ; i < M ; i++)
		{
			st=new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			dis[a][b] = 1; 
		}

		ployd();
//		print();
		bw.append(String.valueOf(ischecked()));
		bw.close();
	}
	public static void print()
	{
		for(int i = 1 ; i <= N ; i++)
		{
			for(int j = 1 ; j <= N ; j++)
			{
				System.out.print((dis[i][j] == INF ? "f" : dis[i][j]) + " ");
			}
			System.out.println();
		}

	}
	public static int ischecked()	
	{
		int cnt = 0;
		for(int i = 1 ; i <= N ; i++)
		{
			boolean[] nopass = new boolean[N+1];
			for(int j = 1 ; j <= N ; j++)
			{
				if(dis[i][j] == INF && dis[j][i] == INF) nopass[j] = true;
			}
			
			for(int k = 1 ; k <= N ; k++)
			{
				if(nopass[k])
				{
					break;
				}
				if(k == N) cnt++;
			}
		}
		return cnt;
	}
	public static void ployd()
	{
		for(int m = 1 ; m <= N ; m++)
		{
			for(int a = 1 ; a <= N ; a++)
			{
				for(int b = 1 ; b <= N ; b++)
				{
					if(a == b) continue;
					if(dis[a][m] == INF || dis[m][b] == INF) continue;
					if(dis[a][b] > dis[a][m] + dis[m][b])
						dis[a][b] = dis[a][m] + dis[m][b];
				}
			}
		}
	}
	public static void init()
	{
		for(int i = 1 ; i <= N ; i ++)
		{
			for(int j = 1 ; j <= N ; j++)
			{
				dis[i][j] = INF;
				if(i == j) dis[i][j] = 0;
			}
		}
	}

}
