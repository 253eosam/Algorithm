import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Pos
{
	public int y,x;
	public char gateNum;
	Pos(int y, int x)
	{ this.y = y; this.x = x; }
	Pos(int y, int x, char g)
	{ this.y = y; this.x = x; this.gateNum = g; }
}
public class Main {
	public static int h,w,cnt;
	public static char[][] arr;
	public static boolean[][] visit;
	public static Queue<Pos> q;
	public static ArrayList<Character> myKeys;
	public static ArrayList<Pos> doNotOpenGate;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tNum = 1 ; tNum <= T ; tNum++)
		{
			String tmp = br.readLine();
			String[] splitTmp = tmp.split(" ");

			// init
			h = Integer.parseInt(splitTmp[0]); 
			w = Integer.parseInt(splitTmp[1]);
			arr = new char[h][w];
			visit = new boolean[h][w];
			q = new LinkedList<>();
			cnt = 0;
			myKeys = new ArrayList<>();
			doNotOpenGate = new ArrayList<>();

			// input stating point
			for(int i = 0 ; i < h ; i++)
			{
				tmp = br.readLine();
				for(int j = 0 ; j < w ; j++)
				{
					arr[i][j] = tmp.charAt(j); 
					if(i == 0 || i == h-1 || j == 0 || j == w-1)
					{
						if(arr[i][j] != '*')
						{
							q.offer(new Pos(i,j));
							visit[i][j] = true;
						}
					}
				}
			}

			// input keys
			tmp = br.readLine().toUpperCase();
			for(int i = 0 ; i < tmp.length() ; i++)
			{
				myKeys.add(tmp.charAt(i));
			}
			
			// call bfs()
			bfs();
			
			bw.write(cnt + "\n");
		}//for tNum
		bw.flush();
		bw.close();
	}//main
	public static int[] dy = { -1, 0, 1, 0};
	public static int[] dx = {  0, 1, 0,-1};
	public static void bfs()
	{
		while(!q.isEmpty())
		{
			Pos p = q.poll();
			int y = p.y;
			int x = p.x;

			// 조건 처리
			if(arr[y][x] == '$')
				cnt++;
			else if('A' <= arr[y][x] && arr[y][x] <= 'Z' && !myKeys.contains(arr[y][x]))
			{
				doNotOpenGate.add(new Pos(y,x,arr[y][x]));
				continue;
			}
			else if('a' <= arr[y][x] && arr[y][x] <= 'z')
			{
				myKeys.add(Character.toUpperCase(arr[y][x]));
				for(Pos tmpPos : doNotOpenGate)
				{
					if(tmpPos.gateNum == Character.toUpperCase(arr[y][x]))
					{
						q.offer(tmpPos);
					}
				}
			}
			
			for(int i = 0 ; i < 4 ; i++)
			{
				int ty = dy[i] + y;
				int tx = dx[i] + x;
				if(0 > ty || ty >= h || 0 > tx || tx >= w || visit[ty][tx] || arr[ty][tx] == '*') continue;
				visit[ty][tx] = true;
				q.offer(new Pos(ty,tx));
			}//for direction

		}//while !q.isEmpty()
	}//bfs

}
/*
 * 1. 무조건 테두리에서 접근해야 한다.
 * 2. 현재 가지고 있는 키를 확인 가능한 변수가 필요하다 
 * 3. 키를 가지고 문을 만난 경우
 * 4. 키를 나중에 발견하는 경우
 *  -> 오다가 만난 문을 어느 변수에 저장해두다가 해당 키를 찾으면 순간이동한다. 
 * -> 같은 문이 여러개가 존재 할 수 있으므로 ArrayList사용 
 */
