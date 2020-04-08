import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Minsuck_homework {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		int tNum = 1;
		int n , k;
		while(T > 0)
		{
			StringTokenizer token = new StringTokenizer(br.readLine());
			n = Integer.parseInt(token.nextToken());
			k = Integer.parseInt(token.nextToken());
			token = new StringTokenizer(br.readLine());
			int[] counting = new int[n+1];
			for(int i = 1 ; i <= k ; i++)
			{
				int inputTmp = Integer.parseInt(token.nextToken());
				counting[inputTmp]++;
			}
			bw.write("#"+(tNum++)+" ");
			for(int i = 1; i <= n ; i++)
			{
				if(counting[i] == 0)
					bw.write(i + " ");
			}
			bw.write("\n");
			bw.flush();
			T--;
		}
		bw.close();
	}

}
