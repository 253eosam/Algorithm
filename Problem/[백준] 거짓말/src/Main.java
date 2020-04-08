import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;

	public static int N, M, answer;
	public static HashSet<Integer> set;
	public static boolean[] party,visited;
	public static ArrayList<Integer>[] list;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		party = new boolean[M]; // 제외될 파티는 true
		visited = new boolean[N+1];
		set = new HashSet<Integer>();
		st = new StringTokenizer(br.readLine());
		int real = Integer.parseInt(st.nextToken());
		for (int i = 0; i < real; i++) {
			int tmp = Integer.parseInt(st.nextToken()); 
			set.add(tmp);
			visited[tmp] = true;
		}
		list = new ArrayList[M];
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = new ArrayList<>();
			int peopleNum = Integer.parseInt(st.nextToken());
			boolean flag = false; // 제외될 파티
			for (int j = 0; j < peopleNum; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				list[i].add(tmp);
				if (set.contains(tmp))
					flag = true;
			}
			if (flag) {
				q.addAll(list[i]);
				party[i] = true;
			}
		}
		
		while(!q.isEmpty()) {
			int person = q.poll();
			if(visited[person]) continue;
			visited[person] = true;
			for(int i = 0 ; i < M ; i++) {
				if(party[i]) continue;
				if(list[i].contains(person)) {
					party[i] = true;
					q.addAll(list[i]);
				}
			}
		}
		
		for(int i = 0 ; i < M ; i++)
			if(!party[i]) answer++;

		bw.append(String.valueOf(answer));
		bw.close();

	}

}
