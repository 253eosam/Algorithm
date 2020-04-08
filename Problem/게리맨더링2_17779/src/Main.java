import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
   static int N;
   static int min;
   static int[][] map;
   static int[] dy = {1, 1};
   static int[] dx = {-1, 1};
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      N = Integer.parseInt(br.readLine().trim());
      map = new int[N][N];
      for(int i=0; i<N; i++) {
         StringTokenizer st = new StringTokenizer(br.readLine().trim());
         for(int j=0; j<N; j++) {
            map[i][j] = Integer.parseInt(st.nextToken());
         }
      }

      min = 987_654_321;
      for(int i=0; i<N-2; i++) {//대각선 가능 시작점
         for(int j=1; j<N-1; j++) {
            for(int d1=1; j-d1>=0 ; d1++) { //마름모 왼쪽 오른쪽 꼭지점 가능점 선별
               for(int d2=1; j+d2<N; d2++) {
                  if(i+d1+d2<N) { //마름모 아래쪽이 가능하면 함수 ㄱ
                     count(i, j, d1, d2);
                  }
               }
            }
         }
      }
      
      System.out.println(min);
      
   }
   static void count(int y, int x, int d1, int d2) {
      int sum1 = 0; //중간값 합산
      boolean[][] hascounted = new boolean[N][N]; //중간값 계산 처리를 위해서
      
      for(int i=0; i<=d1; i++) { //왼쪽 대각선을 기준으로 출발
         for(int j=0; j<=d2; j++) {
            sum1 += map[y+i+j][x+j-i];
            hascounted[y+i+j][x+j-i] = true;
         }
      }
      
      for(int i=0; i<d1; i++) { //왼쪽 대각선을 기준으로 출발 y값 한칸아래 해주면 전체 처리 가능
         for(int j=0; j<d2; j++) {
            sum1 += map[y+i+j+1][x+j-i];
            hascounted[y+i+j+1][x+j-i] = true;
         }
      }
      int submax = sum1;
      int submin = sum1;
      
      int sum2 = 0;//좌상단
      for(int i=0; i<y+d1 ; i++) {
         for(int j=0; j<=x; j++) {
            if(!hascounted[i][j]) sum2 += map[i][j];
         }
      }
      if(submax<sum2) submax = sum2;
      if(submin>sum2) submin = sum2;
      
      int sum3 = 0;//우상단
      for(int i=0; i<=y+d2; i++) {
         for(int j=x+1; j<N; j++) {
            if(!hascounted[i][j]) sum3 += map[i][j];
         }
      }
      if(submax<sum3) submax = sum3;
      if(submin>sum3) submin = sum3;
      
      int sum4 = 0;//좌하단
      for(int i=y+d1; i<N; i++) {
         for(int j=0; j<x+d2-d1; j++) {
            if(!hascounted[i][j]) sum4 += map[i][j];
         }
      }
      if(submax<sum4) submax = sum4;
      if(submin>sum4) submin = sum4;
      
      
      int sum5 = 0;//우하단
      for(int i=y+d2+1; i<N; i++) {
         for(int j=x+d2-d1; j<N; j++) {
            if(!hascounted[i][j]) sum5 += map[i][j];
         }
      }
//      if(y==2 && x==2 && d1==1 && d2==1) {
//         System.out.println(sum1+" "+sum2+" "+sum3+" "+sum4+" "+sum5+" "+(submax-submin));
//      }
      if(submax<sum5) submax = sum5;
      if(submin>sum5) submin = sum5;
      if(min>submax-submin) min = submax-submin;
   }
}