import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	
	static int[] A1, A2;
	static int[] B1, B2;
	
	static int[][] visit;
	
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()) + 1;
		N = Integer.parseInt(st.nextToken()) + 1;
		
		visit = new int[N][M];
		
		int a, b;
		for (int i=0; i<4; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			if (i==0)
				A1 = new int[] {b,a};
			else if (i==1)
				A2 = new int[] {b,a};
			else if (i==2)
				B1 = new int[] {b,a};
			else
				B2 = new int[] {b,a};
		}
		
		ans = Integer.MAX_VALUE;
		
		BFS(0);
		resetVisit();
		BFS(1);	
		
		if (ans == Integer.MAX_VALUE) {
			System.out.println("IMPOSSIBLE");
		} else {
			System.out.println(ans);
		}
	}
	
	static int[] da = {-1, 1, 0, 0};
	static int[] db = {0, 0, -1, 1};
	
	static class Move {
		int a, b;
		Move pre;
		
		public Move(int a, int b, Move pre) {
			this.a = a;
			this.b = b;
			this.pre = pre;
		}
	}
	
	static void BFS(int type) {		
		Queue<Move> q = new LinkedList<>();
		
		int[] w, x, y, z;
		if (type == 0) {
			w = A1;
			x = A2;
			y = B1;
			z = B2;
		} else {
			w = B1;
			x = B2;
			y = A1;
			z = A2;
		}
		
		int result = 0;
				
		q.add(new Move(w[0], w[1], null));
		visit[w[0]][w[1]] = 1;
		
		int a, b;
		while (!q.isEmpty()) {
			Move m = q.poll();
			a = m.a;
			b = m.b;
			
			if (a == x[0] && b == x[1]) {
				result = visit[a][b] - 1;
//				printVisit();
				resetVisit();
				while (m != null) {
					visit[m.a][m.b] = 1;
					m = m.pre;
				}
				q.clear();
				break;
			}
			
			int na, nb;
			for(int k=0; k<4; k++) {
				na = a + da[k];
				nb = b + db[k];
				
				if (na<0||na>=N||nb<0||nb>=M||visit[na][nb]!=0)
					continue;
				if (na==y[0] && nb==y[1])
					continue;
				if (na==z[0] && nb==z[1])
					continue;
				
				q.add(new Move(na, nb, m));
				visit[na][nb] = visit[a][b] + 1;
			}
		}
		
		q.add(new Move(y[0], y[1], null));
		visit[y[0]][y[1]] = 1;
		
		while (!q.isEmpty()) {
			Move m = q.poll();
			a = m.a;
			b = m.b;
			
			if (a==z[0] && b==z[1]) {
				q.clear();
				ans = Math.min(ans, result + visit[a][b] - 1);
				return;
			}
			
			int na, nb;
			for (int k=0; k<4; k++) {
				na = a + da[k];
				nb = b + db[k];
				
				if (na<0||na>=N||nb<0||nb>=M||visit[na][nb]!=0)
					continue;
				
				q.add(new Move(na, nb, m));
				visit[na][nb] = visit[a][b] + 1;
			}
		}
	}
	
	static void printVisit() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				System.out.printf("%2d ", visit[i][j]);
			}
			System.out.println();
		}System.out.println();
	}
	
	static void resetVisit() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				visit[i][j] = 0;
			}
		}
	}
}
