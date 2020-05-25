import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static int N;
	public static char[][] arr;
	public static int[][][] visited;

	public static class Pos {
		int y, x, c, dir;

		public Pos(int y, int x, int c, int dir) {
			super();
			this.y = y;
			this.x = x;
			this.c = c;
			this.dir = dir; // 0,1,2,3 -> 위,오른쪽,아래,왼쪽 순
		}

		@Override
		public String toString() {
			return "Pos [y=" + y + ", x=" + x + ", c=" + c + ", dir=" + dir + "]";
		}
	}

	public static int[] dy = { -1, 0, 1, 0 };
	public static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		Pos start = null;
		Pos target = null;
		arr = new char[51][51];
		visited = new int[51][51][4];
		for(int i = 0 ; i < N ; i++)
			for(int j = 0 ; j < N ; j++)
				for(int k = 0 ; k < 4 ; k++)
					visited[i][j][k] = Integer.MAX_VALUE;
		int mirrorCnt = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j);
				if (arr[i][j] == '!')
					mirrorCnt++;
				if (arr[i][j] == '#' && start == null)
					start = new Pos(i, j, 0, 0);
				else if (arr[i][j] == '#' && target == null)
					target = new Pos(i, j, 0, 0);
			}
		}
		Queue<Pos> q = new LinkedList<>();
		for (int i = 0; i < 4; i++) {
			q.add(new Pos(start.y, start.x, 0, i));
		}
		int answer = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			Pos p = q.poll();
//			System.out.println(p);
			if(p.c > answer || p.c > mirrorCnt) continue;
			if (p.y == target.y && p.x == target.x) {
				answer = Math.min(answer, p.c);
			}
			
			int ty = 0,tx = 0;
			switch (p.dir) {
			case 0:
				ty = p.y-1;
				tx = p.x;
				break;
			case 1:
				ty = p.y;
				tx = p.x+1;
				break;
			case 2:
				ty = p.y+1;
				tx = p.x;
				break;
			case 3:
				ty = p.y;
				tx = p.x-1;
				break;
			}
			if(0 <= ty && ty < N && 0 <= tx && tx < N && arr[ty][tx] != '*') {
				if(visited[ty][tx][p.dir] > p.c) {
					visited[ty][tx][p.dir] = p.c;
					q.add(new Pos(ty,tx,p.c,p.dir));
					if(arr[ty][tx] == '!') {
						q.add(new Pos(ty,tx,p.c+1,(p.dir+1)%4));
						visited[ty][tx][(p.dir+1)%4] = p.c;
						q.add(new Pos(ty,tx,p.c+1,(p.dir-1 < 0 ? 3 : p.dir-1)));
						visited[ty][tx][(p.dir-1 < 0 ? 3 : p.dir-1)] = p.c;
					}
				}
			}
			

		}
		bw.append(String.format("%d\n", answer));
		bw.close();

	}


}
