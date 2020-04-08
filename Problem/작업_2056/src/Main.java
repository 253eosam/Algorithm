import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main
{
	public static int N;
	public static Scanner sc = new Scanner(System.in);
	public static int[] indegree;
	public static Queue<Integer> search;
	public static Queue<Integer> result;
	public static ArrayList<Integer>[] list;
	public static int[] nodes,resultNodes;
	public static void main(String[] args)
	{
		init();
		logic();
		print();
	}
	private static void print() {
		int val= 0;
		for(int i = 1 ; i <= N ; i++)
		{
			result.poll();
			val = Math.max(resultNodes[i], val);
//			System.out.print(resultNodes[val] + " ");
		}
//		System.out.println();
		System.out.println(val);
	}
	public static void logic()
	{
		for(int i = 1 ; i <= N ; i++)
			if(indegree[i] == 0)
			{
				search.add(i);
				resultNodes[i] = nodes[i];
			}
		
		while(!search.isEmpty())
		{
			int idx = search.poll();
			for(int link : list[idx])
			{
				if(--indegree[link] == 0)
				{
					search.add(link);
				}
				resultNodes[link] = Math.max(resultNodes[link] , nodes[link] + resultNodes[idx]);
//				System.out.println("result : "+ resultNodes[link] + " " + link);
			}
			result.add(idx);
		}
	}
	public static void init()
	{
		N = sc.nextInt();
		
		indegree = new int[N+1];
		list = new ArrayList[N+1];
		for(int i = 0 ;  i <= N ; i++)
			list[i] = new ArrayList<>();
		result = new LinkedList<>();
		search = new LinkedList<>();
		nodes = new int[N+1];
		resultNodes = new int[N+1];
		
		for(int i = 1; i <= N ; i++)
		{
			int v = sc.nextInt();
			int k = sc.nextInt();
			for(int j = 0 ; j < k ; j++)
			{
				int t = sc.nextInt();
				list[t].add(i);
				indegree[i]++;
			}
			nodes[i] = v;
		}
	}

}
