import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int[] arr;
	public static int M;
	public static int start,target;
	public static void main(String[] args) throws Exception 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//init
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i <= N ; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < M ; i++)
		{
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			target = Integer.parseInt(st.nextToken());
			Data solv = checkQuery();
			
			if(solv == null)
				bw.write("0\n");
			else
				bw.write((solv.end-solv.start) + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static Data checkQuery()
	{
		Data output = null;
		
		int sum = 0;
		for(int i = start ; i <= target ; i++ )
		{
			sum += arr[i];
			if(sum == 0)
			{
				output = new Data(start,i);
			}
		}
		
		return output;
	}

}
class Data
{
	public int start,end;
	Data(int s, int e)
	{
		this.start = s;
		this.end = e;
	}
}