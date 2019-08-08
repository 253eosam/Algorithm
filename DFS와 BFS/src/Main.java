
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[][] graph;
	static boolean visitDFS[];
	static boolean visitBFS[];
	static int N; //정점 개수
	static int M; //간선 개수
	static int V; //startPoint
	

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		
		graph = new int[N+1][N+1];
		visitDFS = new boolean[N+1];
		visitBFS = new boolean[N+1];
		
		int a, b;
		for(int i=0; i<M; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			
			graph[a][b] = graph[b][a] = 1;
		}
		
		dfs(V);
		
		// 메모리를 더 사용해서 속도 올리는 방법
		// 같은 배열을 그냥 하나 더 사용.
		
		System.out.println();
		
		bfs(V);
		
	}


	static void bfs(int i) {
		// bfs는 처음 자신의 값을 방문처리해주고 , queue에 들어가는 값도 방문처리 해주어야 할 때가 많다.
		Queue<Integer> q = new LinkedList<>();
		q.offer(i);
		visitBFS[i] = true;
		
		int temp;
		while(!q.isEmpty()) {
			temp = q.poll();
			System.out.print(temp+" ");	//처음 넣은 값을 바로 빼주니까 출력은 한번으로 쌉가능
			
			for(int j=1; j<=N; j++) {
				if( graph[temp][j] == 1 && !visitBFS[j]) {
					q.offer(j);
					visitBFS[j] = true;
				}
			}
		}
	}


	static void dfs(int i) {
		visitDFS[i] = true;
		System.out.print(i + " ");
		
		for(int j=1; j<=N; j++) {
			if(graph[i][j] == 1 && !visitDFS[j] ) {
				dfs(j);
			}
		}
		
	}

}