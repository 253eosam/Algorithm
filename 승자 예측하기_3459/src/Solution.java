import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public static long N;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int tNum = 1 ; tNum <= T ; tNum++)
		{
			N = Long.parseLong(br.readLine());
			boolean solv = bfs();
			
			bw.write("#"+tNum+" "); 
			if(solv)
				bw.write("Alice");
			else
				bw.write("Bob");
			bw.write("\n");
		}//for tNum
		bw.flush();
		bw.close();
	}
	public static boolean bfs()
	{
		Queue<Data> q = new LinkedList<>();
		boolean pass = false;
		q.offer(new Data(1,1));	// Alice에서 출발
		while(!q.isEmpty())
		{
			Data index = q.poll();
			
			if(N < index.val)
			{
				if(index.sw == 1)	// Alice로 끝난다 -> Alice가 진다.
				{
					pass = true;
					break;
				}
					continue;
			}
			
			q.offer(new Data(index.val * 2, index.sw * -1));
			q.offer(new Data((index.val * 2)+1, index.sw * -1));
		}
		return pass;
	}

}
class Data
{
	public long val,sw;
	Data(long val , long sw)
	{
		this.val = val;
		this.sw = sw;
	}
}
