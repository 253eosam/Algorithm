import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int tNum = 1; tNum <= T ; tNum++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int lcmNum = lcm(M,N);
			
			int tx, ty;
			tx = ty = x;
			
			boolean findout = false;
			while(tx <= lcmNum)
			{
				ty = ty % N == 0 ? N : ty % N; 
				if(ty == y)
				{
					findout = true;
					break;
				}
				tx += M;
				ty += M;
			}
			
			if(findout)
				bw.write(Integer.toString(tx)+"\n");
			else
				bw.write("-1\n");
			
		}//for tNum
		bw.flush();
		bw.close();
		
		
	}
	
	public static int lcm(int a , int b)
	{
		if(a < b)
		{
			int tmp = a; 
			a = b; 
			b = tmp;
		}
		
		int lcmNum = a * b / gcd(a,b);
		
		return lcmNum;
	}
	public static int gcd(int a, int b)
	{
		while(a % b != 0)
		{
			int tmp = b;
			b = a % b;
			a = tmp;
		}
		return b;
	}
}
