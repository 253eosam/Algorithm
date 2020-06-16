import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public static void main(String[] args) {
		System.out.println(
				Arrays.toString(new Solution().solution(6, 4, new int[][] {
					{1, 1, 1, 0}, 
					{1, 2, 2, 0}, 
					{1, 0, 0, 1},
					{0, 0, 0, 1},
					{0, 0, 0, 3},
					{0, 0, 0, 3}
				}))
				
				);
	}
	
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        boolean[][] visited = new boolean[m][n];
        
        for(int i = 0; i < m ; i++) {
        	for(int j = 0 ; j < n ; j++) {
        		if(!visited[i][j] && picture[i][j] != 0){
        			maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(i,j,picture,visited));
        			numberOfArea++;
        		}
        	}
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

	private int bfs(int i, int j, int[][] picture, boolean[][] visited) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(i,j,picture[i][j]));
		visited[i][j] = true;
		int cnt = 1;
		
		int[] dy = {-1,0,1,0};
		int[] dx = {0,1,0,-1};
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			for(int k = 0 ; k < 4 ; k++) {
				int ty = dy[k] + p.y;
				int tx = dx[k] + p.x;
				if(0 <= ty && ty < picture.length && 0 <= tx && tx < picture[0].length) {
					if(!visited[ty][tx] && p.v == picture[ty][tx]) {
						q.add(new Pos(ty,tx,p.v)); cnt++;
						visited[ty][tx] = true;
					}
				}
			}
		}
		
		return cnt;
	}
	
	public class Pos{
		int y,x,v;

		public Pos(int y, int x, int v) {
			super();
			this.y = y;
			this.x = x;
			this.v = v;
		}
		
	}
}