import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static int[] p;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//init
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		p = new int[N+1];
		for(int i = 0 ; i < M ; i++)
		{
			
		}
	}
	public static void makeSet(int x)
	{
		p[x] = x;
	}
	public static int findSet(int x)
	{
		if(p[x] == x) return x;
		return p[x] = findSet(p[x]);
	}
	public static void unionSet

}
