import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static int N,M,W;
	public static int[] dis;
	public static ArrayList<Node> edges;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static final int INF = Integer.MAX_VALUE;
	public static class Node
	{
		int a,b,w;
		Node(int a, int b, int w)
		{
			this.a=a;
			this.b=b;
			this.w=w;
		}
	}
	public static void main(String[] args) throws Exception  
	{
		int T = Integer.parseInt(br.readLine());
		for(int tNum = 1 ; tNum <= T ; tNum++)
		{
			st=new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			dis = new int[N+1];
			edges = new ArrayList<>();
			
			for(int i = 0 ; i < M ; i++)
			{
				st=new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				int c=Integer.parseInt(st.nextToken());
				edges.add(new Node(a,b,c));
				edges.add(new Node(b,a,c));
			}
			
			for(int i = 0 ; i < W ; i++)
			{
				st=new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				int c=Integer.parseInt(st.nextToken());
				edges.add(new Node(a,b,-c));
			}
			
			for(int i = 0 ; i <= N ; i++)
				dis[i] = INF;
			dis[1] = 0;
			
			for(int i = 1 ; i <= N-1 ; i++)
			{
				for(Node edge : edges)
				{
					if(dis[edge.a] != INF && dis[edge.b] > dis[edge.a] + edge.w)
					{
						dis[edge.b] = dis[edge.a] + edge.w;
					}
				}
			}
			
			int[] solv = dis.clone();
			
			for(Node edge : edges)
			{
				if(dis[edge.a] != INF && dis[edge.b] > dis[edge.a] + edge.w)
				{
					dis[edge.b] = dis[edge.a] + edge.w;
				}
			}
			
			boolean pass = true;
			for(int i = 2 ; i <= N ; i++)
			{
				if(solv[i] != dis[i])
				{
					pass = false;
					break;
				}
			}
			
			if(!pass) bw.write("YES");
			else bw.write("NO");
			bw.write("\n");
		}//for tNum
		bw.close();
	}

}
