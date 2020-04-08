import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int stoi(String str ) {	return Integer.parseInt(str); }
	
	public static int N,answer;
	public static int[][] arr;
	public static final int MAXIMUM = 5;
	
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
		for(int dir = 0 ; dir < 4 ; dir++) {
			dfs(arr,dir,1);
		}
	}

	private static void dfs(int[][] arr, int dir, int level) {
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		if(level == 6) return;
		int[][] brr = new int[N][N];
		LinkedList<Integer>[] link = new LinkedList[N];
		for(int i = 0 ; i < N ; i++) link[i]=new LinkedList<>();
		
		if(dir == 0) {	// 위로
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					input(link[i],arr[j][i]);
				}
			}
			for(int i = 0 ; i < N ; i++) {
				int idx = 0;
				while(!link[i].isEmpty()) {
					int val = link[i].poll();
					brr[idx++][i] = val;
					answer = Math.max(answer, val);
				}
				for(;idx < N ; idx++) {
					brr[idx][i] = 0;
				}
			}
			for(int i = 0 ; i < 4 ; i++) {
				dfs(brr,i,level+1);
			}
		}else if(dir == 1) {	//아래
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					input(link[i],arr[N-j-1][i]);
				}
			}
			for(int i = 0 ; i < N ; i++) {
				int idx = 0;
				while(!link[i].isEmpty()) {
					int val = link[i].poll();
					brr[N-1-idx++][i] = val;
					answer = Math.max(answer, val);
				}
				for(;idx < N ; idx++) {
					brr[N-1-idx][i] = 0;
				}
			}
			for(int i = 0 ; i < 4 ; i++) {
				dfs(brr,i,level+1);
			}
		}else if(dir == 2) {	//옆
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					input(link[i],arr[i][j]);
				}
			}
			for(int i = 0 ; i < N ; i++) {
				int idx = 0;
				while(!link[i].isEmpty()) {
					int val = link[i].poll();
					brr[i][idx++] = val;
					answer = Math.max(answer, val);
				}
				for(;idx < N ; idx++) {
					brr[i][idx] = 0;
				}
			}
			for(int i = 0 ; i < 4 ; i++) {
				dfs(brr,i,level+1);
			}
		}else if(dir == 3) {	//오른쪽
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					input(link[i],arr[i][N-1-j]);
				}
			}
			for(int i = 0 ; i < N ; i++) {
				int idx = 0;
				while(!link[i].isEmpty()) {
					int val = link[i].poll();
					brr[i][N-1-idx++] = val;
					answer = Math.max(answer, val);
				}
				for(;idx < N ; idx++) {
					brr[i][N-1-idx] = 0;
				}
			}
			for(int i = 0 ; i < 4 ; i++) {
				dfs(brr,i,level+1);
			}
		}
	}
	public static void input(LinkedList<Integer> link,int in) {
		if(link.isEmpty()) link.add(in);
		else {
			if(link.peek() == in) {
				input(link,link.poll() + in);
			}else link.add(in);
		}
	}

	private static void input() throws IOException {
		N = stoi(br.readLine());
		arr = new int[N][N];
		answer = 0;
		
		for(int i = 0 ; i < N ; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				arr[i][j] = stoi(st.nextToken());
			}
		}
	}

}
