import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static Scanner sc = new Scanner(System.in); 
	public static int[] in;
	public static Queue<Integer> search_queue;
	public static Queue<Integer> result_queue;
	public static ArrayList<Integer>[] list;
	public static int N,M;
	public static void main(String[] args) {
		init();
		DAG();
		print();
	}
	private static void print() {
		for(int p : result_queue)
			System.out.print((p+1) + " ");
	}
	public static void DAG()
	{
		for(int i = 0 ; i < N ; i++)
		{
			if(in[i] == 0 && !result_queue.contains(i))
			{
				search_queue.add(i);
			}
		}

		while(!search_queue.isEmpty())
		{
			int sq = search_queue.poll();
			for(int link : list[sq])
			{
				in[link]--;
				if(in[link] == 0) search_queue.add(link);
			}
			result_queue.add(sq);
		}
	}
	public static void init()
	{
		N = sc.nextInt();
		M = sc.nextInt();

		in = new int[N];
		list = new ArrayList[N];
		for(int i = 0  ; i < N ; i++)
			list[i] = new ArrayList<>();

		search_queue = new LinkedList<>();
		result_queue = new LinkedList<>();

		for(int i = 0 ; i < M ; i++)
		{
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			list[a].add(b);
			in[b]++;
		}
	}

}
