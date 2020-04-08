import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		for(int i = 1 ; i <= N ; i++)
			q.offer(i);
		
		while(!q.isEmpty())
		{
			if(q.size() == 1) break;
			popQueue();
			int tmp = popQueue();
			pushQueue(tmp);
		}
		
		System.out.println(q.poll());
	}
	
	public static int popQueue()
	{
		return q.poll();
	}
	public static void pushQueue(int v)
	{
		q.offer(v);
	}
}
