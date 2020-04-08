import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int N,M;
	public static int[][] dis;
	public static final int INF = 987654321;
	public static void main(String[] args) throws Exception
	{
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		dis= new int[N+1][N+1];
		for(int i = 1 ; i <= N ; i++)
			for(int j = 1 ; j <= N ; j++)
				dis[i][j] = (i == j) ? 0 : INF; 
				
		for(int i = 0 ; i < M ; i++)
		{
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			dis[a][b] = Math.min(dis[a][b], c);
		}
		
		folyd();
		
		for(int i = 1 ; i <= N ; i++)
		{
			for(int j = 1 ; j <= N ; j++)
			{
				if(dis[i][j] == INF)
					bw.write("0" + " ");
				else
					bw.write(dis[i][j] + " ");
			}
			bw.write("\n");
		}
		bw.close();
	}
	public static void folyd()
	{
		for(int m = 1 ; m <= N ; m++)
		{
			for(int a = 1; a <= N ; a++)
			{
				for(int b = 1; b <= N ; b++)
				{
					if(dis[a][b] > dis[a][m] + dis[m][b])
						dis[a][b] = dis[a][m] + dis[m][b];
				}
			}
		}
	}
}
