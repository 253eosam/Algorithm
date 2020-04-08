import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
 
public class Solution {
    static int N, M, R, C, L;
    static int[][] map;
 
    static int[][] dir = { {}, { 0, 1, 2, 3 }, { 1, 3 }, { 0, 2 }, { 0, 3 }, { 0, 1 }, { 1, 2 }, { 2, 3 } };
    static int[] dy = { 0, 1, 0, -1 };
    static int[] dx = { 1, 0, -1, 0 };
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCnt = Integer.parseInt(br.readLine());
        StringTokenizer st;
 
        for (int test = 1; test <= testCnt; test++) {
            st = new StringTokenizer(br.readLine());
 
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
 
            map = new int[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
 
            int cnt = bfs(R, C);
            System.out.println("#" + test + " " + cnt);
 
        } // test
 
    }
 
    private static int bfs(int row, int col) {
        LinkedList<Pos> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        LinkedList<Pos> p = new LinkedList<>();
 
        visited[row][col] = true;
        Pos start = new Pos(row, col, 1);
        queue.add(start);
        p.add(start);
        Pos from, to;
        int ty, tx;
        int symbol;
        int d;
        boolean flag = false;
        while (!queue.isEmpty()) {
 
            from = queue.poll();
            symbol = map[from.row][from.col];
            for (int i = 0; i < dir[symbol].length; i++) {
                d = dir[symbol][i];
 
                ty = from.row + dy[d];
                tx = from.col + dx[d];
 
                if (ty < 0 || ty >= N || tx < 0 || tx >= M)
                    continue;
 
                if (visited[ty][tx])
                    continue;
                if ((from.time + 1) > L)
                    continue;
                if (map[ty][tx] == 0)
                    continue;
                flag=false;
                for (int k = 0; k < dir[map[ty][tx]].length; k++) 
                {
                    if(d==0 && dir[map[ty][tx]][k]==2)
                    {
                        flag=true;
                    }
                    else if(d==1 && dir[map[ty][tx]][k]==3){
                        flag=true;
                    }
                    else if(d==2 && dir[map[ty][tx]][k]==0){
                        flag=true;
                    }
                    else if(d==3 && dir[map[ty][tx]][k]==1){
                        flag=true;
                    }
                }
                if(!flag) continue;
 
                to = new Pos(ty, tx, from.time + 1);
 
                visited[ty][tx] = true;
                queue.add(to);
                p.add(to);
            }
        }
        //System.out.println(p);
        return p.size();
 
    }
 
    static class Pos {
        int row;
        int col;
        int time;
 
        public Pos(int row, int col, int time) {
            super();
            this.row = row;
            this.col = col;
            this.time = time;
        }
 
        @Override
        public String toString() {
            return "Pos [row=" + row + ", col=" + col + ", time=" + time + "]";
        }
 
    }
}