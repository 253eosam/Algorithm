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
	public static int N,M;
	public static int[][] dis;
	public static int target;
	public static int[] nodes;
	public static final int INF = Integer.MAX_VALUE;
	public static int stoi(String str) { return Integer.parseInt(str); }
	public static void main(String[] args) throws Exception 
	{
		init();
		ployd();
		solv();
	}
	public static void print()
	{
		for(int i = 1 ; i <= N ; i++)
		{
			for(int j = 1 ; j <= N ; j++)
			{
				if(dis[i][j] == INF)
					System.out.print("X ");
				else
					System.out.print(dis[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void solv() throws IOException	
	{
		for(int i = 1 ; i <= N ; i++)
		{
			if(i == target) continue;
			nodes[i] += dis[i][target] + dis[target][i];
		}
		Arrays.sort(nodes);
		bw.write(String.valueOf(nodes[N]));
		bw.close();
	}
	public static void makeINF()	
	{
		for(int i = 1 ; i <= N ; i++)
		{
			for(int j = 1 ; j <= N ; j++)
			{
				if(i == j)continue;
				dis[i][j] = INF;
			}
		}
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
	public static void init() throws Exception
	{
		st=new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		target = stoi(st.nextToken());
		
		dis=new int[N+1][N+1];
		nodes=new int[N+1];
		
		makeINF();
		
		for(int i = 0 ; i < M ; i++)
		{
			st=new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken());
			int b = stoi(st.nextToken());
			int t = stoi(st.nextToken());
			dis[a][b] = t;
		}
	}
}
