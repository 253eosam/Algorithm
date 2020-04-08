import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] house;
	static boolean[][] checked;
	static int cnt = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		house = new int[N][N];
		checked = new boolean[N][N];
		String str = "";
		int num=0;
		int[] res = new int[50];
		int idx = 0;
		
		for(int y=0;y<N;y++) {//�迭�� ���Է�
			str = sc.next();
			for(int x=0;x<N;x++) {
				house[y][x] = str.charAt(x)-'0';
			}
		}
		for(int y=0;y<N;y++) {//���ǿ� �������� bfs
			for(int x=0;x<N;x++) {
				if(house[y][x]==1&&!checked[y][x]) {
					res[idx++] = bfs(y,x);
					num++;
				}
			}
		}
		System.out.println(num);
		for(int c=0;c<idx;c++) {
			System.out.println(res[c]);
		}
	}//main
	
	public static int bfs(int y,int x) {
		Queue<Data> q = new LinkedList<>();
		int cnt = 1;
		int[] ty = {1,-1,0,0};//�����¿�
		int[] tx = {0,0,-1,1};//�����¿�
		q.offer(new Data(y,x));
		checked[x][y] = true;
		while(!q.isEmpty()) {
			Data pos = q.poll();
			for(int i=0;i<4;i++) {
				if(pos.y+ty[i]>=0&&pos.y+ty[i]<house.length&&pos.x+tx[i]>=0&&pos.x+tx[i]<house.length) {//���ȿ���
					if(house[pos.y+ty[i]][pos.x+tx[i]]==1&&!checked[pos.y+ty[i]][pos.x+tx[i]]) {//1�̰� üũ�ȉ�����
						q.offer(new Data(pos.y+ty[i],pos.x+tx[i]));//ť�� �ְ�
						checked[pos.y+ty[i]][pos.x+tx[i]] = true;//üũ����
						cnt +=1;
					}
				}
			}
		}
		return cnt;
	}//bfs
	
	public static class Data {
		int y,x;

		public Data(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}//data

}