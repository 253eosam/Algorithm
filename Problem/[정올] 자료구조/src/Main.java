import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static int stoi(String str) 	{ return Integer.parseInt(str); }
	public static void main(String[] args) throws IOException {
		int n = stoi(br.readLine());
		int[] arr = new int[n];
		long[] cnt = new long[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = stoi(br.readLine());
		}
		Stack<Data> stack = new Stack<>();
		
		for(int i = n-1 ; i >= 0 ; i--) {
			while(!stack.isEmpty() && arr[i] > stack.peek().val) {
				Data d = stack.pop();
				if(cnt[d.idx] == 0) ++cnt[i];
				else cnt[i] += cnt[d.idx]+1;
			}
			stack.push(new Data(arr[i],i));
		}
		
		long answer = 0;
		for(int i = 0 ; i < n ; i++) {
			answer += cnt[i];
		}
		bw.append(String.valueOf(answer));
		bw.flush();
	}
	public static class Data{
		int idx, val;
		public Data(int val, int idx) {
			super();
			this.val = val;
			this.idx = idx;
		}
	}
}
