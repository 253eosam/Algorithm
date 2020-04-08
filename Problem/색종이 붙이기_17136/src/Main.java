import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static final int N = 10;
	public static int[][] arr;
	public static boolean[][] visited;
	public static int[][] dy = {{0,0,0,0,0},{1,1,1,1,1},{2,2,2,2,2},{3,3,3,3,3},{4,4,4,4,4}};
	public static int[][] dx = {{0,1,2,3,4},{0,1,2,3,4},{0,1,2,3,4},{0,1,2,3,4},{0,1,2,3,4}};
	public static int solv;
	public static int stoi(String str ) { return Integer.parseInt(str); }
	public static void main(String[] args) throws IOException {
		input();
		logic();
		print();
	}
	private static void print() throws IOException {
		bw.write(String.valueOf(solv));
		bw.flush();
	}
	private static void logic() {
		for(int i = 4 ; i >= 0 ; i--)
		{
			for(int j = 0 ; j < N ; j++)
			{
				for(int k = 0 ; k < N ; k++)
				{
					if(arr[j][k] == 1 && !visited[j][k])
					{
						fulling(j,k,i);
					}
				}
			}
		}
	}
	private static void fulling(int y, int x, int index) {
		// TODO Auto-generated method stub
		
	}
	private static void input() throws IOException {
		arr = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0 ; i < N ; i++)
		{
			st=new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++)
			{
				arr[i][j] = stoi(st.nextToken());
			}
		}
		
	}

}
