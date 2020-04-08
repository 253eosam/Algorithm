package 불5427;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 불 5427
 */
public class Main {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int stoi(String str) { return Integer.parseInt(str); }
	
	public static int H,W,answer;
	public static char[][] arr;
	public static boolean[][] visited;
	public static Queue<Pos> q;
	
	public static class Pos{
		int y,x,c;
		boolean human;
		public Pos(int y, int x, int c, boolean human) {
			this.y = y;
			this.x = x;
			this.c = c;
			this.human = human;
		}
	}
	
	public static void main(String[] args) throws IOException {
		int tc = stoi(br.readLine());
		for(int i = 0 ; i < tc ; i++) {
			input();
			logic();
			print();
		}
		bw.flush();
	}

	private static void print() throws IOException {
		if(answer == 0) bw.append("IMPOSSIBLE\n");
		else bw.append(String.valueOf(answer)+"\n");
	}

	private static void logic() {
		int[] dy = { -1, 0 , 1, 0 };
		int[] dx = { 0 , 1 , 0, -1};
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			
			if(p.human && arr[p.y][p.x] == '*') continue;
			
			for(int i = 0 ; i < 4 ; i++) {
				int ty = dy[i] + p.y;
				int tx = dx[i] + p.x;
				
				if(p.human) {
					if(0 <= ty && ty < H && 0 <= tx && tx < W) {
						if(arr[ty][tx] == '.' && !visited[ty][tx]) {
							q.add(new Pos(ty,tx,p.c+1,true));
							visited[ty][tx] = true;
							arr[ty][tx] = '@';
						}
					}else{
						answer = p.c+1;
						return;
					}

				}else {
					if(0 <= ty && ty < H && 0 <= tx && tx < W
							&& arr[ty][tx] != '#' && arr[ty][tx] != '*') {
						q.add(new Pos(ty,tx,0,false));
						arr[ty][tx] = '*';
					}
				}
			}
		}//while : q not empty
	}


	private static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		W = stoi(st.nextToken());
		H = stoi(st.nextToken());

		arr = new char[H][W];
		visited = new boolean[H][W];
		q = new LinkedList<>();
		answer = 0;
		
		ArrayList<Pos> fires = new ArrayList<>();
		
		for(int i = 0 ; i < H ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < W ; j++) {
				char c = str.charAt(j);
				arr[i][j] = c;
				if(c == '#') visited[i][j] = true;
				else if(c == '*') fires.add(new Pos(i,j,0,false));
				else if(c == '@') {
					visited[i][j] = true;
					q.add(new Pos(i,j,0,true));
				}
			}
		}
		
		for(Pos p : fires) {
			q.add(p);
		}
		
	}//input

}
