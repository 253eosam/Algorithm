import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int tNum = 1; tNum <= 10 ; tNum++)
		{
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int base = Integer.parseInt(st.nextToken());
			int pow = Integer.parseInt(st.nextToken());
			
			bw.write("#"+tNum+" "+permutation(base, pow)+"\n");
		}
		
		bw.flush();
		
	}//main
	
	public static int permutation(int base , int exp)
	{
		if(exp == 0)
			return 1;
		else if(exp == 1)
			return base;
		return base * permutation(base,exp-1);
	
	}
}