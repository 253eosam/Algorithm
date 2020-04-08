import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tNum = 1 ; tNum <= T ; tNum ++)
		{
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < N ; i++)
			{
				arr[i] = Integer.parseInt(st.nextToken());
			}
//			System.out.print("#" + tNum + " " + arr[0] + "\n");
			bw.write("#" + tNum + " " + arr[0] + "\n");
		}
		bw.flush();
		bw.close();
		
//		String[] splitStr = br.readLine().split(" ");
//		if(splitStr[0].equals("4"))
//			System.out.println("good");
//		if(splitStr[1].equals("6"))
//			System.out.println("good");
//		
//		
//		StringTokenizer st;
//		st = new StringTokenizer(br.readLine());
//		System.out.println(st.nextToken());
//		System.out.println(st.nextToken());
		
		
//		bw.write("fdfsfsdf");
//		
//		bw.flush();
//		bw.close();
	}

}
