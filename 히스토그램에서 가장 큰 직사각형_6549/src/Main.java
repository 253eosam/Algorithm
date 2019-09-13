import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			if(N == 0) break;
			ArrayList<Integer> list = new ArrayList<>();
			int[] arr = new int[N];
			for(int i = 0 ; i < N ; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			int maximum = 0;
			for(int i = N-1 ; i >= 0 ; i--)
			{
				for(int j = 0 ; j < arr[i] ; j++)
				{
					maximum = Math.max(maximum, width(arr,N,i,j,0)*(j+1));
				}
			}
			
			bw.write(String.valueOf(maximum) + "\n");
		}
		bw.flush();
		bw.close();
	}
	public static int width(int[] arr, int N, int index, int hight, int len)
	{
		if(index >= N) return len;
		
		if(arr[index] > hight)
		{
			return width(arr,N,index+1,hight,len+1);
		}
		return len;
	}

}
