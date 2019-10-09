import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static class Edge implements Comparable<Edge>	//간선의 대한 정보
	{
		int next,cost;
		Edge(int next, int cost)
		{
			this.next=next;
			this.cost=cost;
		}
		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
		@Override
		public String toString() {
			return "Edge [next=" + next + ", cost=" + cost + "]";
		}
	}
	public static PriorityQueue<Edge> pq;
	public static boolean visited[];
	public static ArrayList<Edge>[] arr;
	public static int V,E;
	public static int solv;
	public static void main(String[] args) {
		
		//init
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		
		pq = new PriorityQueue<>();
		visited = new boolean[V+1];
		arr = new ArrayList[V+1];
		for(int i = 0 ; i <= V ; i++)
			arr[i] = new ArrayList<>();

		for(int i = 0 ; i < E ; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int cost = sc.nextInt();
			arr[a].add(new Edge(b,cost));
			arr[b].add(new Edge(a,cost));
		}
		
		prim(1);
		
		System.out.println(solv);
		
	}
	
	public static void prim(int start)
	{
		visited[start] = true;	// 초기노드의 방문 처리

		// 초기 노드의 간선 정보를 모두 PriorityQueue에 넣어준다.
		for(int i = 0 ; i < arr[start].size() ; i++)
		{
			Edge next = arr[start].get(i);
			pq.add(next);
		}
		
		// 후 간선들의 비교
		while(!pq.isEmpty())
		{
			Edge e = pq.poll();
			if(visited[e.next]) continue;
			
			visited[e.next] = true;
			solv += e.cost;
			
			for(Edge tmp : arr[e.next])
			{
				if(visited[tmp.next]) // 방문된 노드에 대한 간선은 넣어주지 않는다. 
					continue;	
				
				pq.add(tmp);
			}
		}
	}

}
