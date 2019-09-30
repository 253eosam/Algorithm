import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int N ;
	public static int[][] arr;
	public static int targetY , targetX;
	public static void main(String[] args) throws Exception {

		N =	Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		st = new StringTokenizer(br.readLine());
		targetY = Integer.parseInt(st.nextToken());
		targetX = Integer.parseInt(st.nextToken());
		
		
		
	}
	public static int shapes[][][] = { 
			{{1,0} , {0,1} , {1,1}},	//one
			{{0,0} , {1,0} , {1,1}},	//two
			{{0,0} , {0,1} , {1,0}},	//three
			{{0,0} , {0,1} , {1,0}}		//four
	};
	public static int zeroIndex[][] = {
			{ 0 , 0 } , { 0 , 1 } , { 1 , 0 } , { 1 , 1 }
	};
	public static void divide(int y, int x, int k)
	{
		
	}
}
