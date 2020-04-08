import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static int cnt = 0 ;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		
		bw.write(String.valueOf((int)Math.pow(2, K)-1)+"\n");
		hanoi(K,1,3,2);
		bw.flush();
		bw.close();
		
	}
	
	public static void hanoi(int n , int from , int to ,int tmp) throws IOException
	{
		if(n == 1)
		{
			bw.write(from +" "+to+"\n");
			return;
		}
		hanoi(n-1,from,tmp,to);
		bw.write(from+" "+to+"\n");
		hanoi(n-1,tmp,to,from);
	}

}
