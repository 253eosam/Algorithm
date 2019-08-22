import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[N+1];
		for(int i = 1 ; i <= N ; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int P = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < P ; i++)
		{
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			
			if(sex == 1) man(arr,idx);
			else if(sex == 2) woman(arr,idx);
		}
		
		for(int i = 1 ; i <= N ; i++)
		{
			bw.write(String.valueOf(arr[i])+" ");
			if(i % 20 == 0) bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
	public static void man(int[] arr, int index)
	{
		for(int i = index ; i <= N ; i += index)
			arr[i] = reverse(arr[i]);
	}
	public static void woman(int[] arr, int index) 
	{
		int cnt = 1 ;
		arr[index] = reverse(arr[index]);
		while(true)
		{
			int i = index + cnt;
			int j = index - cnt;
			if(!(1 <= j && i <= N))
				break;
			if(arr[i] == arr[j])
			{
				arr[i] = reverse(arr[i]);
				arr[j] = reverse(arr[j]);
			}
			else break;
			cnt++;
		}
	}
	public static int reverse(int v)
	{
		return v==1 ? 0 : 1;
	}

}
