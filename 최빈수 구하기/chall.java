import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Many_used {
	
	public static int MAX_SIZE = 1000;
	static int[] students = new int[MAX_SIZE];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		

		int T = Integer.parseInt(br.readLine());
		while(T > 0)
		{
			int[] counting = new int[MAX_SIZE];
			int maximum = -987654321;
			int maxIndex = 0;
			int pNum = Integer.parseInt(br.readLine());
			StringTokenizer token = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < MAX_SIZE; i++)
			{
				students[i] = Integer.parseInt(token.nextToken());
				counting[students[i]]++;
				if(maximum <= counting[students[i]])
				{
					maximum = counting[students[i]];
					maxIndex = students[i];
				}
			}
			
			bw.write("#"+pNum+" "+maxIndex+"\n");
			bw.flush();
			T--;
		}

	}

}
