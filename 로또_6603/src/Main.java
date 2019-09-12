import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static int N ;
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		while(true)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N == 0) break;
			int[] arr = new int[N];
			boolean[] visited = new boolean[N];
			for(int i = 0 ; i < N ; i++ )
			{
				arr[i] = Integer.parseInt(st.nextToken());
			}
			combination(arr,visited,0,N,6);
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
	static void combination(int[] arr, boolean[] visited, int start, int n, int r) throws IOException {
		if(r == 0) {
			print(arr, visited, n);
			return;
		} else {
			for(int i=start; i<n; i++) {
				visited[i] = true;
				combination(arr, visited, i + 1, n, r - 1);	
				visited[i] = false;
			}
		}
	}
	static void print(int[] arr, boolean[] visited, int n) throws IOException {
		for(int i=0; i<n; i++) {
			if(visited[i] == true)
				bw.write(arr[i] + " ");
		}
		bw.write("\n");
	}
}
