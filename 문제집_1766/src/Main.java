import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main 
{
	public static Scanner sc = new Scanner(System.in);
	public static int[] in;
	public static  Queue<Integer> searchQueue;
	public static  Queue<Integer> resultQueue;
	public static ArrayList<Integer>[] list;
	public static int N,M;
	public static void main(String[] args) 
	{
		init();
		DAO();
	}
	private static void DAO() 
	{
		
	}
	public static void init()
	{
		N = sc.nextInt();
		M = sc.nextInt();
		
		in = new int[N+1];
		searchQueue = new LinkedList<>();
		resultQueue = new LinkedList<>();
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
