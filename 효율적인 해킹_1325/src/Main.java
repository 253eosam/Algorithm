import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static int N, M; 
	public static int MaxDepth;
	public static Set<Integer> maxSetList;
	public static int[] isNum;
	public static boolean[] visited;
	public static ArrayList<ArrayList<Integer> > list = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//init
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maxSetList = new TreeSet<>();
		isNum = new int[N+1];
		visited = new boolean[N+1];
		
		for(int i = 0 ; i <= N ; i++)
		{
			list.add(new ArrayList<>());
		}
		
		//input
		// a <- b
		for(int i = 0 ; i < M ; i++)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(b).add(a);
		}
		
		//logic
		for(int i = 1 ; i < list.size() ; i++)
		{
			int depth = dfs(i,0);
//			System.out.println(depth + " : depth" + i);
			if(MaxDepth < depth)
			{
				MaxDepth = depth;
				maxSetList.clear();
				maxSetList.add(i);
			}
			else if(MaxDepth == depth)
			{
				maxSetList.add(i);
			}
		}
		
		//print
		for(int tmp : maxSetList)
			bw.write(tmp + " ");
		bw.flush();
		bw.close();
	}
	public static int dfs( int index, int depth)
	{
//		System.out.println("start : " + startingPoint + " index : "+ index + " depth : " + depth);
		int output = 0;
		if(visited[index] || list.get(index).size() == 0)
		{
			return isNum[index] = 1;
		}
		
		visited[index] = true;
		for(int i = 0 ; i < list.get(index).size() ; i++)
		{
			int tmp = 1;
			if(isNum[list.get(index).get(i)] == 0)
				tmp += dfs(list.get(index).get(i),depth+1);
			else if( isNum[list.get(index).get(i)] > 0)
				tmp += isNum[list.get(index).get(i)];
			output = Math.max(output, tmp);
		}
		return isNum[index] = output;
	}
}
