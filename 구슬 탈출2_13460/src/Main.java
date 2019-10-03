package 구슬탈출2;


import javax.swing.text.Position;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[][] map;
    static int[][] visited; //빨간공의 방문지점
    static int[][] visited2; //파란공의 방문지점
    static int N;
    static int M;
    static Position red;
    static Position blue;

    static int answer;

    //상하좌우 탐색방향
    static Position[] dir = {
            new Position(-1,0),
            new Position(0,1),
            new Position(1,0),
            new Position(0,-1)
    };

    public static void main(String[] args){


        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N+1][M+1];
        visited = new int[N+1][M+1];
        visited2 = new int[N+1][M+1];

        //입력받기
        for(int i=1; i<=N; i++){
            String tile = sc.next();

            for(int j=0; j<M; j++){

                String box = Character.toString(tile.charAt(j));
                if(box.equals("#")){
                    map[i][j+1] = 1;
                }else if(box.equals("R")){
                    red = new Position(i, j+1);
                }else if(box.equals("B")){
                    blue = new Position(i, j+1);
                }else if(box.equals("O")){
                    map[i][j+1] = 2;
                }
            }
        }

        visited[red.n][red.m]=1;
        visited2[blue.n][blue.m]=1;

        answer = 999;
        dfs(red, blue,1);

        if(answer==999) System.out.println("-1");
        else System.out.println(answer);


//        print();


    }

    static void dfs(Position red, Position blue, int count){

        //10회 시도해도 못찾으면 나가리
        if(10<count){
            return;
        }

//        System.out.printf("%d, %d\n", red.n, red.m);

        //4방햘 탐색
        for(int i=0; i<4; i++){

            Position nextRed = tilting(red, dir[i]); //빨강이동
            Position nextBlue = tilting(blue, dir[i]); //파랑이동


            //탈출처리
            if(nextRed.isEscape() && !nextBlue.isEscape()){ //빨간공만 탈출성공
//                System.out.printf("answer:%d, count:%d\n", answer, count);
                answer = Math.min(answer, count);
                return;
            }else if(nextRed.isEscape() && nextBlue.isEscape()){ //동시에 탈출해서 나가리
                continue;
            }else if(nextBlue.isEscape() ){ //파란공이 먼저 탈출해서 나가리
                continue;
            }


            //겹침처리(더 많이 움직인 애가 튕김
            if (nextRed.isSame(nextBlue)) {
                if (nextRed.move < nextBlue.move) {
                    overlap(nextBlue, i);
                } else if (nextRed.move > nextBlue.move) {
                    overlap(nextRed, i);
                }
            }


            dfs(nextRed, nextBlue, count+1);

//            //이전에 완전히 같은 상황이 있었으면 탐색하지 않음
//            if ( !(visited[nextRed.n][nextRed.m]==1 && visited2[nextBlue.n][nextBlue.m]==1) ) {
//                visited[nextRed.n][nextRed.m] = 1;
//                visited2[nextBlue.n][nextBlue.m] = 1;
//            }
        }//for


    }


    //기울였을때 가게 되는 점 반환
    static Position tilting(Position pos, Position dir){

        //원래 값은 유지가 되어야 함으로 새로 copy해서 쓴다.
        Position p = new Position(pos.n, pos.m);

        while(true){
            if(map[p.n+dir.n][p.m+dir.m]==0) p.add(dir);  //갈 수 있는 곳
            else if(map[p.n+dir.n][p.m+dir.m]==2){ //구멍
                return new Position(-1,-1);
            }
            else break;  //벽
        }
        return p;
    }



    /**
     * 겹쳤을 때 처리(진행방향 반대로 한칸 이동)
     * @param p: 이동할 공의 위치
     * @param direction: 진행방향
     */
    static void overlap(Position p, int direction){

        if(direction==0){
            p.n += 1;
        }else if(direction==1){
            p.m -= 1;
        }else if(direction==2){
            p.n -= 1;
        }else if(direction==3){
            p.m += 1;
        }

    }



    static void print(){
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                System.out.printf("%d ", map[i][j]);
            }
            System.out.println();
        }
    }



    static class Position{
        int n;
        int m;
        int move=0; //한 턴에 몇칸 움직였는지

        Position(int n, int m){
            this.n = n;
            this.m = m;
        }

        void add(Position p){
            this.n += p.n;
            this.m += p.m;
            this.move++;
        }

        boolean isEscape(){
            if(this.n==-1 && this.m==-1) return true;
            return false;
        }

        boolean isSame(Position p){
            if(this.n==p.n && this.m==p.m) return true;
            return false;
        }
    }
}