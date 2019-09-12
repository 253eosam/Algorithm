import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[] arr;
	public static int[] p;
	public static int N,M;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		p = new int[N+1];
		
		makeSet();
		for(int i = 0 ; i < M ; i++)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			unionSet(a,b);
		}
		
		int cnt = 0;
		for(int i = 1 ; i <= N ; i++)
		{
			if(p[i] == i)
				cnt++;
		}
		
		System.out.println(cnt);
		
	}
	public static void makeSet()
	{
		for(int i = 1 ; i <= N ; i++)
		{
			p[i] = i;
		}
	}
	public static int findSet(int x)
	{
		if(p[x] == x) return x;
		return p[x] = findSet(p[x]);
	}
	public static void unionSet(int a, int b)
	{
		int pa = findSet(a);
		int pb = findSet(b);
		if(pa != pb)
		{
			p[pb] = pa;
		}
	}
}
