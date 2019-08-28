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
	public static int minimum = Integer.MAX_VALUE;
	public static int N,M;
	public static void main(String[] args) throws IOException {
		
		 br = new BufferedReader(new InputStreamReader(System.in));
		 bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N ; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		dfs(arr,0,3,0);
		
		bw.write(Integer.toString(M-minimum));
		bw.flush();
		bw.close();
	}
	
	public static void dfs(int[] arr, int cur ,int target , int sum)
	{
		if(cur == target)
		{
//			System.out.println(Arrays.toString(arr));
			if(M - sum < 0) return;
			minimum = Math.min(M-sum, minimum);
			return ;
		}
		for(int i = cur ; i < arr.length ; i++)
		{
			swap(arr,cur,i);
			dfs(arr,cur+1,target,sum+arr[cur]);
			swap(arr,cur,i);
		}
	}
	public static void swap(int[] arr ,int i, int j)
	{
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}
