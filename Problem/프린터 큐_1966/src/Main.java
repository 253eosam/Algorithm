import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tNum = 1 ; tNum <= T ; tNum++)
		{
			//init
			Queue<Data> q = new LinkedList<>();
			
			//input
			int N = sc.nextInt();
			int findData = sc.nextInt();
			Map<Integer,Integer> m = new HashMap<>();
			for(int i = 9 ; i >= 1 ; i--)
				m.put(i, 0);
			for(int i = 0 ; i < N ; i++)
			{
				int pri = sc.nextInt();
				m.replace(pri, m.get(pri)+1);
				q.offer(new Data(i,pri));
			}
			
			//logic
			int cnt = 0; Data tmp = null;
			outer : for(int idx = 9 ; idx >= 1 ; idx--)
			{
				while(m.get(idx) > 0)
				{
					tmp = q.poll();
					if(idx == tmp.priority)
					{
						m.replace(idx, m.get(idx)-1);
						cnt++;
						if(tmp.val == findData)
							break outer;
					}
					else
						q.offer(tmp);
				}
			}
			
			//print
			System.out.println(cnt);
			
		}//for tNum
	}

}
class Data
{
	public int val;
	public int priority;
	Data(int v, int p)
	{
		this.val = v;
		this.priority = p;
	}
}