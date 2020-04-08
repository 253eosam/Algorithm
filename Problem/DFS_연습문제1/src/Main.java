import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static final int MAX_SIZE = 10;
	public static boolean[] DFSvisit = new boolean[MAX_SIZE];
	public static boolean[] BFSvisit = new boolean[MAX_SIZE];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList<Integer>[] list = new LinkedList[MAX_SIZE];
		
		for(int i = 0 ; i < MAX_SIZE; i++)
			list[i] = new LinkedList<>();
		
		int input[] = {1,2,1,3,2,4,2,5,4,6,5,6,6,7,3,7};
		
		for(int i = 0 ; i < input.length ; i+=2)
		{
			list[input[i]].add(input[i+1]);
			list[input[i+1]].add(input[i]);
		}
		
		for(int i = 1 ; i < list.length ; i++)
			System.out.println(i + " : " + list[i]);
		
		System.out.println("DFS starting!!");
		dfs(list,1);
		System.out.println();
		System.out.println("BFS starting!!");
		bfs(list,1);
		
		
	}
	
	public static void dfs(LinkedList<Integer>[] list , int index)
	{
		if(DFSvisit[index]) return;
		
		DFSvisit[index] = true;
		System.out.print(index + " ");
		
		for(int t : list[index])
			dfs(list,t);
	}//dfs
	
	public static void bfs(LinkedList<Integer>[] list , int start)
	{
		BFSvisit[start] = true;
		
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		
		while(!q.isEmpty())
		{
			int index = q.poll();
			System.out.print(index + " ");
			
			for(int go : list[index])
			{
				if(BFSvisit[go]) continue;
				BFSvisit[go] = true;
				q.offer(go);
			}
		}//while !q.isEmpty()
	}//bfs
}
