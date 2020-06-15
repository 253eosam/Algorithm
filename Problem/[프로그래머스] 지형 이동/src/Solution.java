import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        int[][][] lands = {
                {
                        {1, 4, 8, 10},
                        {5, 5, 5, 5},
                        {10, 10, 10, 10},
                        {10, 10, 10, 20}
                },
                {
                        {10, 11, 10, 11},
                        {2, 21, 20, 10},
                        {1, 20, 21, 11},
                        {2, 1, 2, 1}
                }
        };
        int[] heights = {
                3,1
        };
        for (int i = 0; i < heights.length; i++) {
            System.out.println(solution(lands[i],heights[i]));
        }
    }
    public static final boolean TEST_FLAG = false;
    public static int solution(int[][] land, int height) {
        int answer = 0;

        int N = land.length;
        int M = land[0].length;
        // BFS를 통해 각 영역을 정한다.
        // MST를 이용하여 각 영역들의 최소 비용을 뽑아낸다.

        int[][] space = new int[N][M];
        int spaceCnt = 1;
        for(int i = 0 ; i < N ; i++){
            for (int j = 0; j < M; j++) {
                if(space[i][j] != 0) continue;
                bfs(i,j,spaceCnt++,N,M,land,height,space);
            }
        }

        if (TEST_FLAG) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    System.out.print(space[i][j] + " ");
                }
                System.out.println();
            }
        }

        ArrayList<Dis> list = new ArrayList<Dis>();
        int[] parent = new int[spaceCnt];
        int mstCnt = spaceCnt-2;
        makeSet(parent);
        int[] dy = {-1,0,1,0};
        int[] dx = {0,1,0,-1};
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                for (int k = 0; k < 4; k++) {
                    int ty = dy[k] + y;
                    int tx = dx[k] + x;
                    if(0 <= ty && ty < N && 0 <= tx && tx < M){
                        if(space[y][x] != space[ty][tx]){
                            list.add(new Dis(space[y][x],space[ty][tx],Math.abs(land[y][x]-land[ty][tx])));
                        }
                    }
                }
            }
        }
        Collections.sort(list,(f,s)->Integer.compare(f.v,s.v));
        for (Dis dis : list) {
            if(mstCnt == 0) break;
            int result = unionSet(dis.a,dis.b,dis.v,parent);
            if(result > 0) mstCnt--;
            answer += result;
        }
        return answer;
    }
    public static class Dis{
        int a,b,v;
        public Dis(int a, int b, int v) {
            this.a = a;
            this.b = b;
            this.v = v;
        }
    }

    private static int unionSet(int a, int b, int v, int[] parent){
        int alpha = findSet(a,parent);
        int beta = findSet(b,parent);
        if(alpha != beta){
            parent[alpha] = beta;
            return v;
        }
        return 0;
    }

    private static int findSet(int x, int[] parent){
        if(parent[x] == x) return x;
        return parent[x] = findSet(parent[x],parent);
    }

    private static void makeSet(int[] parent) {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    public static class Pos{
        int y,x;
        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    private static void bfs(int y, int x, int space, int N, int M, int[][] land, int height, int[][] visited) {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(y,x));
        visited[y][x] = space;

        int[] dy = {-1,0,1,0};
        int[] dx = {0,1,0,-1};

        while(!q.isEmpty()){
            Pos p = q.poll();

            for (int i = 0; i < 4; i++) {
                int ty = dy[i] + p.y;
                int tx = dx[i] + p.x;
                if(0 <= ty && ty < N && 0 <= tx && tx < M){
                    if(visited[ty][tx] == 0){
                        if(Math.abs(land[p.y][p.x] - land[ty][tx]) <= height){
                            visited[ty][tx] = space;
                            q.add(new Pos(ty,tx));
                        }
                    }
                }
            }
        }
    }

}
