import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static Queue<Integer> q = new LinkedList<>();
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		for(int i = 1 ; i <= N ; i++)
		{
			q.offer(i);
		}
		
		int[] arr = new int[N];
		int cnt = 0;
		while(!q.isEmpty())
		{
			arr[cnt++] = popQueue(K);
		}
		System.out.print("<");
		for(int i = 0 ; i < arr.length ; i++)
		{
			if(i == arr.length-1)
			{
				System.out.print(arr[i]);
				break;
			}
			System.out.print(arr[i]+", ");
		}
		System.out.print(">");
	}
	public static int popQueue(int k)
	{
		for(int i = 1 ; i < k ; i++)
		{
			int tmp = q.poll();
			q.offer(tmp);
		}
		
		return q.poll();
	}

}
