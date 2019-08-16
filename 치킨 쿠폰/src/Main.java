import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = null;
		for(int i = 0 ; i < 3; i ++)
		{
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int solv = coupon(n,k);
			bw.write(solv+"\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static int coupon(int n,int k)
	{
		n += n / k;
		if(stamp < k)
			return n;
		return coupon(n+stamp,n%k,k);
	}

}
