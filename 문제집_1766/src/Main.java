import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main 
{
	public static Scanner sc = new Scanner(System.in);
	public static int[] in;
	public static  PriorityQueue<Num> searchQueue;
	public static ArrayList<Integer> resultQueue;
	public static ArrayList<Integer>[] list;
	public static int N,M;
	public static class Num implements Comparable<Num>
	{
		int preval , val;

		public Num(int preval, int val) {
			super();
			this.preval = preval;
			this.val = val;
		}

		@Override
		public String toString() {
			return "Num [preval=" + preval + ", val=" + val + "]";
		}

		@Override
		public int compareTo(Num o) {
			return this.val - o.val;
		}
		
	}
	public static void main(String[] args) 
	{
		init();
		DAG();
		print();
	}
	public static void print()
	{
		for(int output : resultQueue)
			System.out.print(output + " ");
	}
	private static void DAG() 
	{
		for(int i = 1 ; i <= N ; i++)
			if(in[i] == 0)
				searchQueue.add(new Num(i,i));

		while(!searchQueue.isEmpty())
		{
			Num idx = searchQueue.poll();
//			System.out.println(idx);
			for(int link : list[idx.val])
			{
				if(--in[link] == 0)
					searchQueue.add(new Num(idx.val,link));
			}
			
			boolean pass = false;
			if(idx.preval == idx.val)
			{
				resultQueue.add(idx.val);
				pass = true;
			}
			
			for(int i = resultQueue.indexOf(idx.preval)+1 ; i < resultQueue.size() ; i++)
			{
				if(resultQueue.get(i) > idx.val)
				{
					resultQueue.add(i,idx.val);
					pass = true;
					break;
				}
			}
			if(!pass)
				resultQueue.add(idx.val);
		}
	
	}
	public static void init()
	{
		N = sc.nextInt();
		M = sc.nextInt();
		
		in = new int[N+1];
		searchQueue = new PriorityQueue<>();
		resultQueue = new ArrayList<>();
		list = new ArrayList[N+1];
		for(int i = 0 ; i <= N ; i++)
			list[i] = new ArrayList<>();
		
		for(int i = 0 ; i < M ; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a].add(b);
			in[b]++;
		}
	}

}
