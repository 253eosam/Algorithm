import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	public static int stoi(String str) { return Integer.parseInt(str); }
	public static int[] p;
	public static int N,M;
	public static boolean[] gather;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int T = stoi(br.readLine());
		for(int tNum = 1; tNum <= T ; tNum++)
		{
			st = new StringTokenizer(br.readLine());
			N = stoi(st.nextToken());
			M = stoi(st.nextToken());
			p = new int[N+1];
			//input edge
			long time = System.currentTimeMillis();
			makeSet();
			for(int i = 0 ; i < M ; i++)
			{
				st = new StringTokenizer(br.readLine());
				int a = stoi(st.nextToken());
				int b = stoi(st.nextToken());
				if(p[a] != p[b])
					unionSet(a,b);
			}
			gather = new boolean[N+1];
			int gatherCnt = 0;
			for(int i = 1 ; i <= N ; i++)
			{
				if(gather[findSet(i)]) continue;
				gather[p[i]] = true;
				gatherCnt++;
			}
			bw.write("#"+tNum+" "+gatherCnt+"\n");
			System.out.println(System.currentTimeMillis()-time);
		}//for tNum
		bw.flush();
		bw.close();
	}
	public static void makeSet()
	{
		for(int i = 1 ; i <= N; i++)
			p[i] = i;
	}
	public static int findSet(int x)
	{
		if(p[x] == x ) return x;
		return p[x] = findSet(p[x]);
	}
	public static void unionSet(int a, int b)
	{
		int pa = findSet(a);
		int pb = findSet(b);
		if(pa != pb)
			p[pb] = pa;
	}

}
