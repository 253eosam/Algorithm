import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Flatten {

	static int MAX_SIZE = 100;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = 10; int tNum = 1;
		int[] arr = new int[MAX_SIZE];
		while(T > 0)
		{
			int dumpNum = Integer.parseInt(br.readLine());
			StringTokenizer token = new StringTokenizer(br.readLine());
			
			for(int i = 0 ; i < MAX_SIZE ; i++ )
			{
				arr[i] = Integer.parseInt(token.nextToken());
			}
			int endIndex = arr.length-1;
			for(int i = 0 ; i < dumpNum; i++)
			{
				Arrays.sort(arr);
				arr[endIndex]--;
				arr[0]++;
			}
			Arrays.sort(arr);
			int solv = arr[endIndex] - arr[0];
			bw.write("#"+(tNum++)+" "+ solv + "\n");
			bw.flush();
			
			T--;
		}
		bw.close();
	}

}
