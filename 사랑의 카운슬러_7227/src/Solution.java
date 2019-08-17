import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	public static long minimum;
	public static int T,N;
	public static boolean [] visit;
	public static int[][] pos;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		for(int tNum = 1 ; tNum <= T ; tNum++)
		{
			N = Integer.parseInt(br.readLine());
			visit = new boolean [N];
			pos = new int[N][2];
			minimum = Long.MAX_VALUE;
			for(int i = 0 ; i < N ; i++)
			{
				st = new StringTokenizer(br.readLine());
				pos[i][0] = Integer.parseInt(st.nextToken());
				pos[i][1] = Integer.parseInt(st.nextToken());
			}
			dfs(0,0,0,0);
			bw.write("#"+tNum+" "+minimum+"\n");
		}//for tNum
		bw.flush();
		bw.close();
	}//main

	public static void dfs(int depth, int index, long ty , long tx)
	{
		if(depth == N/2) 
		{
			long vector = (ty*ty) + (tx*tx);
			if(minimum > vector)
				minimum = vector;
			return ;
		}
		for(int i = index ; i < N ; i++)
		{
			long vy = pos[depth][1] - pos[i][1];
			long vx = pos[depth][0] - pos[i][0];
			visit[i] = true;
			dfs(depth+1,index+1,ty+vy,tx+vx);
			visit[i] = false;
		}
	}

}
