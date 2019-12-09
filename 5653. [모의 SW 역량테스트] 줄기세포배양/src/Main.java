import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int solv,start,target;
	public static boolean[] prime,visited;
	public static final int MAX_SIZE = 100000;
	public static int stoi(String str) {return Integer.parseInt(str); }
	public static void main(String[] args) throws IOException {
		int T = stoi(br.readLine());
		calPrime();
		for(int tNum = 1 ; tNum <= T ; tNum++)
		{
			input();
			bfs();
			print();
		}
	}
	private static void input() throws IOException {
		st=new StringTokenizer(br.readLine());
		start = stoi(st.nextToken());
		target = stoi(st.nextToken());
		visited = new boolean[MAX_SIZE];
	}
	private static void calPrime() {
		prime = new boolean[MAX_SIZE];
		int size = (int) Math.sqrt(MAX_SIZE);
		for(int i = 2 ; i < size; i++)
		{
			if(prime[i]) continue;
			for(int j = i+i ; j < MAX_SIZE; j += i )
				prime[j] = true;
		}
		
	}
	private static void print() throws IOException {
		bw.write(String.valueOf(solv) + "\n");
		bw.flush();
	}
	public static class Num
	{
		String num; 
		int cnt;

		public Num(String num, int cnt) {
			super();
			this.num = num;
			this.cnt = cnt;
		}
		
	}
	private static void bfs() {
		Queue<Num> q = new LinkedList<>();
		q.add(new Num(String.valueOf(start),0));
		Num n = null;
		while(!q.isEmpty())
		{
			n = q.poll();
			
			if(stoi(n.num) == target)
			{
				solv = n.cnt;
				break;
			}
			
			for(int i = 0 ; i < 4 ; i++)
			{
				char[] tmp = n.num.toCharArray();
				for(int  j  = 0 ; j <= 9 ; j++)
				{
					tmp[i] = (char) (j + '0');
					String str = new String(tmp);
					int val = stoi(str);
					if(!visited[val] && !prime[val] && val >= 1000)
					{
						visited[val] = true;
						q.add(new Num(str,n.cnt+1));
					}
				}
			}
		}
	}

}
