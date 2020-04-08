import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Main{
	private static int n, m;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static int[][] lake, melt;
    private static boolean[][] visit;
    private static Node swan;
    private static Scanner sc;
    public static void main(String[] args){
    	sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        lake = new int[n][m];
        melt = new int[n][m];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < m; j++) {
                lake[i][j] = line.charAt(j);
                if (lake[i][j] == 'L') swan = new Node(i, j);
            }
        }
        System.out.println(swim());
    }
    private static int swim() {
        int right = 0;
        int left = 0;
        int day = (right + left) >> 1;
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (lake[i][j] == 'X') continue;
                q.offer(new Node(i, j));
                melt[i][j] = 1;
            }
        }
        while (!q.isEmpty()) {
        	Node node = q.poll();
            for (int i = 0; i < 4; i++) {
            	int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || melt[nx][ny] != 0) continue;
                melt[nx][ny] = melt[node.x][node.y] + 1;
                if (right < melt[nx][ny]) right = melt[nx][ny];
                q.offer(new Node(nx, ny));
            }
        }
        day = (right + left) >> 1;
        while (left <= right) {
            visit = new boolean[n][m];
            if (isConnect(day)) right = day - 1;
            else left = day + 1;
            day = (left + right) >> 1;
        }
        return day;
    }
    private static boolean isConnect(int day) {
        Queue<Node> q = new LinkedList<>();
        boolean flag = false;
        q.offer(swan);
        visit[swan.x][swan.y] = true;
        while (!q.isEmpty()) {
        	Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visit[nx][ny] || melt[nx][ny] > day) continue;
                if (lake[nx][ny] == 'L' && nx != swan.x && ny != swan.y) {
                    flag = true;
                    break;
                }
                visit[nx][ny] = true;
                q.offer(new Node(nx, ny));
            }
            if (flag) break;
        }
        return flag;
    }
    private static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}