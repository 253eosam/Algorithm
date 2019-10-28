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
	public static int stoi(String str) { return Integer.parseInt(str); }
	public static void main(String[] args) throws Exception
	{
		init();
		makeINF();
		
		
	}
	public static void init() throws Exception
	{
		N = stoi(br.readLine());
		M = stoi(br.readLine());
		
		dis = new int[N+1][N+1];
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
