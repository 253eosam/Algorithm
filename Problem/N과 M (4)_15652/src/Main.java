import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static int[] pick;
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception 
	{
		long time = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		pick = new int[M+1];
		
		permutation(1,0);
		bw.flush();
		bw.close();
	}
	public static void permutation(int index, int depth) throws IOException
	{
		
		if(depth == M)
		{
			for(int i = 1; i <= M ; i++)
				bw.write(pick[i] + " ");
			bw.write("\n");
			return ;
		}
		
		for(int i = index ; i <= N ; i++)
		{
			pick[depth+1] = i;
			permutation(i,depth+1);
		}
	}
}
