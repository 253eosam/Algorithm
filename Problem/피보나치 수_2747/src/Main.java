import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static final int MAX_SIZE = 1000000;
	public static long[] values = new long[MAX_SIZE];
	public static long fibo(int n)
	{
		if(n == 1 || n == 0)
			return n == 1 ? 1 : 0;
		if(values[n] > 0) return values[n];
		return values[n] = fibo(n-2) + fibo(n-1);
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		long solv = fibo(N);

		bw.write(String.valueOf(solv));
		bw.flush();
		bw.close();
	}

}
