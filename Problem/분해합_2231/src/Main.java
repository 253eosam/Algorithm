import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static final int MAX_SIZE = 1_000_000;
	public static int N, output;
	public static int[] arr = new int[MAX_SIZE+1];
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		init();
		
		bw.write(String.valueOf(output));
		bw.flush();
		bw.close();
		
		
	
	}
	
	public static void init()
	{
		for(int i = 1 ; i < N ; i++)
		{
			arr[i] = generator(i);
			if(arr[i] == N)
			{
				output = i;
				return;
			}
		}
	}
	
	public static int generator(int i)
	{
		int sum = i;
		while(i > 0)
		{
			sum += i % 10;
			i /= 10;
		}
		return sum;
	}

}
