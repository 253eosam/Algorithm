import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main2 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int N, M;
	public static int[] p;
	public static ArrayList<Integer> pick;
	public static int solv = Integer.MAX_VALUE;
	public static class Edge implements Comparable<Edge>
	{
		int a,b,cost;
		Edge(int a, int b, int cost)
		{
			this.a=a;
			this.b=b;
			this.cost=cost;
		}
		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
	public static ArrayList<Edge>[] edgeList;
	public static ArrayList<Integer> aList;
	public static ArrayList<Integer> bList;
	public static void main(String[] args) throws Exception
	{
		//init
		st=new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		edgeList = new ArrayList[N+1];
		for(int i = 0 ; i <= N ; i++)
			edgeList[i] = new ArrayList<>();
		p = new int[N+1];
		pick = new ArrayList<>();
		for(int i = 0 ; i <= N ; i++)
			pick.add(0);
		aList = new ArrayList<>();
		bList = new ArrayList<>();
		
		for(int i = 0 ; i < M ; i++)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			edgeList[a].add(new Edge(a,b,cost));
		}
		
		
		//powerSet
		for(int i = 1 ; i <= N-1 ; i++)
		{
			combination(i, 0, 1);
		}
		
		bw.write(String.valueOf(solv));
		bw.flush();
		bw.close();
	}
	public static boolean DEBUG = false;
	public static int KRUSKAL(ArrayList<Integer> list)
	{
		int output = -1;
		
		ArrayList<Edge> edges = new ArrayList<>();
		for(int i = 1 ; i <= N ; i++)
			for(Edge e : edgeList[i])
				if(list.contains(e.a) && list.contains(e.b))
					edges.add(e);
		
		Collections.sort(edges);
		makeSet();
		int sum = 0;
		
		for(int i = 0 ; i < edges.size() ; i++)
			sum += unionSet(edges.get(i));
		
		if(isConnection(list));
			output = sum;
		return output;
	}
	public static boolean isConnection(ArrayList<Integer> list)
	{
		boolean pass = true;
		int cnt = 0;
		for(int i : list)
		{
			if(p[i] == i)
				cnt++;
			if(cnt >= 2)
			{
				pass = false;
				break;
			}
		}
		return pass;
	}
	public static void makeSet()
	{
		for(int i = 0 ; i <= N ; i++)
			p[i] = i;
	}
	public static int findSet(int x)
	{
		if(p[x] == x) return x;
		return p[x]=findSet(p[x]);
	}
	public static int unionSet(Edge e)
	{
		int cost = 0;
		int alpha = findSet(e.a);
		int beta = findSet(e.b);
		if(alpha != beta)
		{
			p[beta] = alpha;
			cost = e.cost;
		}
		return cost;
	}
	public static void combination(int target, int deep, int cur)
	{
		if(deep == target)
		{
			if(DEBUG)
			{
				for(int i = 0 ; i < deep ; i++)
					System.out.print(pick.get(i) + " ");
				System.out.println();
			}
			
			// A team , B team 
			aList.clear(); bList.clear();
			for(int i = 0 ; i < deep ; i++)
				aList.add(pick.get(i));
			for(int i = 1 ; i <= N ; i++)
				for(int j = 0 ; j < deep ; j++)
					if(pick.get(j) != i)
						bList.add(i);
			
			int aTeam = KRUSKAL(aList);
			int bTeam = KRUSKAL(bList);
			
			if(aTeam >= 0 && bTeam >= 0)
				solv = Math.min(solv, aTeam+bTeam);
			return;
		}
		for(int i = cur ; i <= N ; i++)
		{
			pick.set(deep,i);
			combination(target,deep+1,i+1);
		}
	}

}
