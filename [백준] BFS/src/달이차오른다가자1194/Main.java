package 달이차오른다가자1194;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
	public static BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));
	public static StringTokenizer st;
	public static int stoi(String str) { return Integer.parseInt(str); }
	
	public static int N,M,answer;
	public static char[][] arr;
	public static boolean[][][] visited;
	public static int keyIdx(char c) { return ('a'<=c&&c<='z')?c-'a':c-'A'; }
	public static final int ALPHA_NUM = 1 << (keyIdx('f')+1);
	public static Queue<Pos> q;
	
	public static class Pos{
		int y,x,c,keys;
		
		public Pos(int y, int x, int c, int keys) {
			super();
			this.y = y;
			this.x = x;
			this.c = c;
			this.keys = keys;
		}

		@Override
		public String toString() {
			return "Pos [y=" + y + ", x=" + x + ", c=" + c + ", keys=" + Integer.toBinaryString(keys) + "]";
		}

	}
	
	public static void main(String[] args) throws IOException {
		input();
		login();
		print();
	}

	private static void print() throws IOException {
		bw.append(String.valueOf(answer));
		bw.flush();
	}

	private static void login() {
		int[] dy = {1,0,-1,0};
		int[] dx = {0,1,0,-1};
		Pos p = null;
		
		while(!q.isEmpty()) {
			p = q.poll();
			
//			System.out.println(p);
			
			if(arr[p.y][p.x] == '1') {
				answer = p.c;
				break;
			}
			
			for(int i = 0 ; i < 4; i++) {
				int ty = p.y + dy[i];
				int tx = p.x + dx[i];
				char loc = ' ';
				int pKey = p.keys;
				if(0 <= ty && ty < N && 0 <= tx && tx < M
						&& (loc = arr[ty][tx]) !='#' && !visited[ty][tx][p.keys]) {
					if('a' <= loc && loc <= 'f') {
						int key = 1 << keyIdx(loc);
						int keys = key | p.keys;
						pKey = keys;
					}else if('A' <= loc && loc <= 'F') {
						int key = 1 << keyIdx(loc);
						if((p.keys & key) == 0) continue; 
					}
					q.add(new Pos(ty,tx,p.c+1,pKey));
					visited[ty][tx][pKey] = true;
				}
			}
		}//while : q not empty
	}

	private static void input() throws IOException {
		st=new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		arr=new char[N][M];
		visited=new boolean[N][M][ALPHA_NUM];
		q=new LinkedList<>();
		answer = -1;
		
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				char c = str.charAt(j);
				arr[i][j] = c;
				if(c == '0') {
					q.add(new Pos(i,j,0,0));
					visited[i][j][0] = true;
				}
			}
		}
	}

}
