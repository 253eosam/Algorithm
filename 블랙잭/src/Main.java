import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = null;
	public static BufferedWriter bw = null;
	public static int minimum = 300000;
	public static void main(String[] args) throws IOException {
		
		 br = new BufferedReader(new InputStreamReader(System.in));
		 bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N ; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		backtracking(arr,0,0,M,0);
		
		bw.write(Integer.toString(M-minimum));
		bw.flush();
		bw.close();
	}
	
	public static void backtracking(int[] arr, int index ,int depth, int target, int sum) throws IOException
	{

	}
	public static void swap(int[] arr ,int i, int j)
	{
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}
