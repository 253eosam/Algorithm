import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	public static int[] p;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tNum = 1; tNum <= T ; tNum++)
		{
			bw.write("#"+tNum+" ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			p = new int[N+1];
			for(int i = 0 ; i < p.length ; i++)
			{
				p[i] = i;
			}
			for(int i = 0 ; i < M ; i++)
			{
				st = new StringTokenizer(br.readLine());
				int command = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				switch(command)
				{
				case 0:
					unionSet(a,b);
					break;
				case 1:
					if(findSet(a) == findSet(b))
						bw.write("1");
					else
						bw.write("0");
					break;
				}
			}
			bw.write("\n");
		}//for tNum
		bw.flush();
		bw.close();
	}
	
	public static int findSet(int x)
	{
		if(p[x] == x) return x;
		return p[x] = findSet(p[x]);
	}
	public static void unionSet(int x, int y)//부모 합치기
	{
		x = findSet(x);
		y = findSet(y);
		if(x == y)	return ;
		p[y] = x;
	}
}
