import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int tNum = 1; tNum <= T ; tNum++)
		{
			int N = Integer.parseInt(br.readLine());
			int solv = countingAdd(N);
			bw.write(String.valueOf(solv)+"\n");
		}//for tNum
		bw.flush();
		bw.close();
	}//main
	public static int countingAdd(int remainder)
	{
		if(remainder == 0) return 1;
		else if(remainder < 0) return 0;
		
		int solv = 0;
		solv += countingAdd(remainder - 1);
		solv += countingAdd(remainder - 2);
		solv += countingAdd(remainder - 3);
		
		return solv;
	}
	

}
