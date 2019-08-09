import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static final boolean DEBUG = true;
	public static int com;
	public static int N;
	public static int[][] arr ;
	public static int[] visit;
	public static int comNum = 0;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		com = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		arr = new int[com+1][com+1];
		visit = new int[com+1];
		for(int i = 0 ; i < N; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = arr[b][a] = 1;
		}
		dfs(1);
		bw.write(Integer.toString(comNum));
		bw.flush();
		bw.close();
		
	}
	
	public static void dfs(int start)
	{
		visit[start] = 1;
		for(int i = 1 ; i <= com ; i++)
		{
			if(arr[start][i] == 1 && visit[i] == 0)
			{
				dfs(i);
				comNum++;
			}
		}
	}
}
