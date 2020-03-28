import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int N, M, answer;
    public static char[][] arr;
    public static boolean[][] visited;
    public static ArrayList<Pos> fireList;
    public static Queue<Pos> q;

    public static class Pos {
        int y, x, c;
        boolean isFire;

        public Pos(int y, int x, int c, boolean isFire) {
            this.y = y;
            this.x = x;
            this.c = c;
            this.isFire = isFire;
        }

        @Override
        public String toString() {
            return "Pos{" +
                    "y=" + y +
                    ", x=" + x +
                    ", c=" + c +
                    ", isFire=" + isFire +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        logic();
        print();
    }

    private static void print() throws IOException {
        if (answer == 0) {
            bw.append("IMPOSSIBLE");
        } else {
            bw.append(String.valueOf(answer));
        }
        bw.flush();
    }

    private static void logic() {
        for (Pos p : fireList) {
            q.add(p);
            visited[p.y][p.x] = true;
        }
        BFS();
    }

    private static void BFS() {
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            Pos p = q.poll();
            if (!p.isFire && arr[p.y][p.x] == 'F') continue;

            for (int i = 0; i < dy.length; i++) {
                int ty = dy[i] + p.y;
                int tx = dx[i] + p.x;
                if (0 <= ty && ty < N && 0 <= tx && tx < M && arr[ty][tx] != '#') {
                    if (p.isFire && arr[ty][tx] != 'F') {
                        q.add(new Pos(ty, tx, p.c + 1, p.isFire));
                        visited[ty][tx] = true;
                        arr[ty][tx] = 'F';
                    } else if (!p.isFire && arr[ty][tx] == '.' && !visited[ty][tx]) {
                        q.add(new Pos(ty, tx, p.c + 1, p.isFire));
                        visited[ty][tx] = true;
                    }
                } else if (!p.isFire && !(0 <= ty && ty < N && 0 <= tx && tx < M)) {
                    answer = p.c + 1;
                    return;
                }
            }
        }
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        visited = new boolean[N][M];
        answer = 0;
        fireList = new ArrayList<>();
        q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = str.charAt(j);
                if (c == 'J') {
                    q.add(new Pos(i, j, 0, false));
                    visited[i][j] = true;
                } else if (c == 'F') fireList.add(new Pos(i, j, 0, true));
                arr[i][j] = c;
            }
        }
    }
}
