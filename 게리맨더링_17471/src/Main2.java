import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2 {
	public static int N;
	public static int arr[];
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int stoi(String str) { return Integer.parseInt(str); }
	public static final int MAX_SIZE = 11;
	public static ArrayList<Integer>[] list;
	public static boolean visited[];
	public static int pick[];
	public static void main(String[] args) throws Exception{
		
		//init
		N = stoi(br.readLine());
		st = new StringTokenizer(br.readLine());
		arr = new int[MAX_SIZE];
		visited = new boolean[MAX_SIZE];
		pick = new int[MAX_SIZE];
		
		for(int i = 1 ; i <= N ; i++)
			arr[i] = stoi(st.nextToken());
		
		list = new ArrayList[MAX_SIZE];
		for(int i = 0 ; i <= N ; i++)
			list[i] = new ArrayList<Integer>();
		
		for(int i = 1 ; i <= N ; i++ )
		{
			st = new StringTokenizer(br.readLine());
			int M = stoi(st.nextToken());
			for(int j = 0 ; j < M ; j++)
				list[i].add(stoi(st.nextToken()));
		}
		
		//조합
		for(int i = 1 ; i <= 2 ; i++)
			com(i,0,0);
	}
	public static void com(int target , int deep, int cur)
	{
		if(deep == target)
		{
			for(int i = 0 ; i < deep ; i++)
				System.out.print(pick[i] + " ");
			System.out.println();
			return;
		}
		
		for(int i = cur ; i <= N ; i++)
		{
			if(visited[i]) continue;
			pick[deep] = i;
			visited[i] = true;
			com(target,deep+1,i+1);
			visited[i] = false;
		}
	}
}
