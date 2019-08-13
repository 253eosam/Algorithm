import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int A,B,C;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		int maximum_size = 200;
		int visit[][][] = new int[maximum_size+1][maximum_size+1][maximum_size+1];
		
		bfs();
		
	}
	public static int[] directions = { 1,2,3 };
	public static void bfs()
	{
		Queue<Data> q = new LinkedList<>();
		q.offer(new Data(3,C,C));
		
		while(!q.isEmpty())
		{
			
		}
	}
}
class Data
{
	public int capacity;
	public int val;
	public int index;
	Data(int i ,int v, int c)
	{
		this.index = i;
		this.val = v;
		this.capacity = c;
	}
}
