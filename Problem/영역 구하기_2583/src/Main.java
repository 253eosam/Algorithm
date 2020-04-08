import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static boolean DEBUG = false;
	public static int M,N,K;
	public static boolean[][] arr;
	public static ArrayList<Integer> list;
	public static int stoi(String str) { return Integer.parseInt(str); }
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//init
		M = stoi(st.nextToken());
		N = stoi(st.nextToken());
		K = stoi(st.nextToken());
		arr = new boolean[M][N];
		list = new ArrayList<>();
		
		//input
		for(int i = 0 ; i < K ; i++)
		{
			st = new StringTokenizer(br.readLine());
			int x = stoi(st.nextToken());
			int y = stoi(st.nextToken());
			int tx = stoi(st.nextToken());
			int ty = stoi(st.nextToken());
			
			for(int j = y ; j < ty ; j++)
			{
				for(int k = x ; k < tx ; k++)
				{
					arr[j][k] = true;
				}
			}
		}
		
		if(DEBUG)
		{
			for(int i = 0 ; i < M ; i++)
			{
				for(int j = 0 ; j < N ; j++)
				{
					System.out.print(arr[i][j] + " ");
				}	
				System.out.println();
			}
		}
		
		int dfsCnt = 0;
		
		for(int i = 0 ; i < M ; i++)
		{
			for(int j = 0 ; j < N ; j++)
			{
				if(!arr[i][j])
				{
					list.add(dfs(i,j));
					dfsCnt++;
				}
			}	
		}
		
		Collections.sort(list);
		
		bw.write(String.valueOf(dfsCnt + "\n"));
		for(int solv : list)
			bw.write(String.valueOf(solv) + " ");
		bw.write("\n");
		bw.flush();
		bw.close();
	}
	public static int[] dy = { -1, 0 , 1 ,  0 };
	public static int[] dx = {  0, 1 , 0 , -1 };
	public static int dfs(int y, int x)
	{
		int output = 1;
		arr[y][x] = true;
		for(int i = 0 ; i < 4 ; i++)
		{
			int ty = dy[i] + y;
			int tx = dx[i] + x;
			if(0 <= ty && ty < M && 0 <= tx && tx < N && !arr[ty][tx])
			{
				output += dfs(ty,tx);
			}
		}
		return output;
	}

}
