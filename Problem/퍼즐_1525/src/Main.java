import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Data
{
	int y,x;
	Data(int y, int x)
	{ this.y=y; this.x=x; }
}
public class Main {
	public static final int N = 3;
	public static Map<String,Integer> visit = new HashMap<>();
	public static Queue<String> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String startingPos = "";
		for(int i = 0 ; i < N ; i++)
		{
			String[] tmp = br.readLine().split(" ");
			for(int j = 0 ; j < N ; j++)
			{
				startingPos += tmp[j];
			}
		}// input arr
		
		int pass = bfs(startingPos);
		
		if(pass != -1)
			bw.write(String.valueOf(pass));
		else
			bw.write("-1");
		bw.flush();
		bw.close();
	}//main
	public static int[] dir = {-3,1,3,-1}; // 1차원배열의 시계방향 이동
	public static int bfs(String startingPos) {
		int output = -1;
		
		q.offer(startingPos);
		visit.put(startingPos, 0);
		
		while(!q.isEmpty())
		{
			String str = q.poll();
			if(str.equals("123456780"))
			{
				output = visit.get(str);
				break;
			}
			
			int zeroIdx = findZero(str);
			for(int i = 0 ; i < 4 ; i++)
			{
				int tDir = zeroIdx + dir[i];
				if(zeroIdx % 3 == 0 && dir[i] == -1 ) continue;
				if(zeroIdx % 3 == 2 && dir[i] == 1 ) continue;
				if(0 <= tDir && tDir < str.length())
				{
					String swapZero = swap(str,zeroIdx,tDir);
					if(visit.get(swapZero) == null)
					{
						q.offer(swapZero);
						visit.put(swapZero, visit.get(str)+1);
					}// 방문
					swap(str,zeroIdx,tDir);
				}
			}// 방향
		}
		
		return output;
	}//bfs
	public static String swap(String str, int a, int b)
	{
		char[] chars = str.toCharArray();
		char tmp = chars[a];
		chars[a] = chars[b];
		chars[b] = tmp;
		return new String(chars);
	}
	public static int findZero(String str)
	{
		for(int i = 0 ; i < str.length() ; i++)
			if(str.charAt(i) == '0') 
				return i;
		
		return -1;
	}
}
