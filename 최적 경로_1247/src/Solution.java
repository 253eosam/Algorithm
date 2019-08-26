import java.util.Scanner;
 
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[][] pos;
         
        for(int i=1; i<=T; i++) {
            int N = sc.nextInt(); //°í°´ ¼ö
            pos = new int[N+2][2];
            for(int j=0; j<N+2; j++) {
                pos[j][0] = sc.nextInt(); //xÁÂÇ¥
                pos[j][1] = sc.nextInt(); //yÁÂÇ¥
            }
            min = Integer.MAX_VALUE;
            visited = new boolean[N];
            dfs(pos,pos[0][0],pos[0][1],0,0);
            System.out.println("#"+i+" "+min);
        }
    }
    static boolean[] visited;
    static int min;
    private static void dfs(int[][] pos, int x, int y, int depth,int d) {
        if(min<d) return;
        if(depth==visited.length) {
            distance(pos,x,y,d);
            return;
        }
 
        for(int i=0; i<visited.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(pos, pos[i+2][0], pos[i+2][1], depth+1, d+Math.abs(x-pos[i+2][0])+Math.abs(y-pos[i+2][1]));
                visited[i] = false;
            }
        }
    }
     
    private static void distance(int[][] pos, int x, int y, int d) {
        d += Math.abs(x-pos[1][0])+Math.abs(y-pos[1][1]);
        if(min>d) min = d;
    }
}