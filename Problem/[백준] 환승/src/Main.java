import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	
	public static int N,M,K,answer;
	public static ArrayList<Integer>[] nList;
	public static int[][] hList;
	public static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		input();
		logic();
		print();
	}

	private static void print() throws IOException {
		bw.append(String.valueOf(answer));
		bw.flush();
	}

	private static void logic() {
		if(nList[N].size() == 0) return;
		
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visited[1] = true;
		int level = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			++level;
			for(int i = 0 ; i < size ; i++) {
				int idx = q.poll();
				
				if(idx == N) {
					answer = level;
					return;
				}
				
				for(int ready : nList[idx]) {
					for(int next : hList[ready]) {
						if(visited[next]) continue;
						q.add(next);
						visited[next] = true;
					}
				}
			}
		}
	}

	private static void input() throws IOException {
		st=new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = -1;
		visited = new boolean[N+1];
		
		nList = new ArrayList[N+1];
		for (int i = 0; i < nList.length; i++) {
			nList[i] = new ArrayList<>();
		}
		hList = new int[M][K];
		
		for(int i = 0 ; i < M ; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j = 0 ;  j < K ; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				nList[tmp].add(i);
				hList[i][j] = tmp;
			}
		}
	}

}
