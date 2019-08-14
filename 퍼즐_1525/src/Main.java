import java.util.Scanner;
public class Main {
	static class Data{
		int x;
		int y;
		Data(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] puzzle = new char[3][3];
		Data cur = null;
		boolean flag = false;
		for(int i=0; i<3; i++) {
			puzzle[i] = sc.nextLine().replace(" ", "").toCharArray();
			if(flag) continue;
			for(int j=0; j<3; j++) {
				if(puzzle[i][j]=='0') {
					cur = new Data(j,i);
					flag = true;
					break;
				}
			}
		}
		
		dfs(puzzle, cur, 0);
		System.out.println(min==999 ? -1 : min);
	}
	
	static int[] dy = {-1,0,0,1};
	static int[] dx = {0,1,-1,0};
	static int min=999;
	static boolean[][] visited = new boolean[3][3];
	private static void dfs(char[][] puzzle, Data cur, int move) {
		if(cur.y==2 && cur.x==2) {
			if(doSame(puzzle)) 	{
				if(min>move) min=move;
			}
			return;
		}
		
		visited[cur.y][cur.x] = true;
		int tx, ty;
		for(int i=0; i<4; i++) {
			tx = cur.x + dx[i];
			ty = cur.y + dy[i];
			if(tx>=0 && tx<3 && ty>=0 && ty<3 && !visited[ty][tx]) {
				Data next = new Data(tx,ty);
				swap(puzzle, cur, next);
				dfs(puzzle, next, move+1);
				visited[ty][tx] = false;
				swap(puzzle, cur, next);
			}
		}
	}

	private static void swap(char[][] puzzle, Data cur, Data next) {
		char c = puzzle[next.y][next.x];
		puzzle[next.y][next.x] = puzzle[cur.y][cur.x];
		puzzle[cur.y][cur.x] = c;
	}

	private static boolean doSame(char[][] puzzle) {
		char val = '0';
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(val=='8') return true;
				if(puzzle[i][j] != ++val)	return false;
			}
		}
		return true;
	}
}