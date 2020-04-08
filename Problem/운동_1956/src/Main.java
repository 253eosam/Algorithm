	import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.io.OutputStreamWriter;
	import java.util.ArrayList;
	import java.util.StringTokenizer;
	
	public class Main {
		public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		public static StringTokenizer st;
		public static int V,E;	// 일반 통행
		// 두 마을을 왕복하는 경우도 사이클에 포함
		public static int[][] dis;
		public static final int INF = Integer.MAX_VALUE;
		public static void main(String[] args) throws Exception 
		{
			st=new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			dis = new int[V+1][V+1];
			for(int i = 1 ; i <= V ; i++)
				for(int j = 1 ; j <= V ; j++)
					dis[i][j] = (i==j) ? 0 : INF;
			
			for(int i = 0 ; i < E ; i++)
			{
				st=new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				dis[a][b] = c;
			}
			fold();
			print();
		}
		public static void test()
		{
			System.out.println();
			for(int i = 1 ; i <= V ; i++)
			{
				for(int j = 1 ; j <= V ; j++)
				{
					if(dis[i][j] == INF)
						System.out.print("INF"+ " ");
					else
						System.out.print(dis[i][j] + " ");
				}
				System.out.println();
			}
		}
		public static void fold()
		{
			for(int m = 1 ; m <= V ; m++)
			{
				for(int a = 1 ; a <= V ; a++)
				{
					for(int b = 1 ; b <= V ; b++)
					{
						if(dis[a][m] == INF || dis[m][b] == INF) continue;
						if(dis[a][b] > dis[a][m] + dis[m][b])
							dis[a][b] = dis[a][m] + dis[m][b];
					}
				}
			}
		}
		public static void print() throws IOException
		{
			int minDis = INF;
			for(int i = 1; i <= V ; i++)
			{
				for(int j = 1; j <= V; j++)
				{
					if(i == j ) continue;
					if(dis[i][j] != INF && dis[j][i] != INF)
					{
						minDis = Math.min(minDis, dis[i][j] + dis[j][i]);
					}
				}
			}
			if(minDis == INF) minDis = -1;
			bw.write(String.valueOf(minDis));
			bw.close();
		}
		public static class Edge
		{
			int a,b,w;
			Edge(int a, int b, int w)
			{
				this.a=a;
				this.b=b;
				this.w=w;
			}
		}
	}
