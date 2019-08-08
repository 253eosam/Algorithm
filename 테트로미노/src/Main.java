import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static final int MAX_SIZE = 500;
	public static int[][] arr = new int[MAX_SIZE][MAX_SIZE];
	public static int N, M;
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int cur = 100;
		int target = Integer.parseInt(br.readLine());
		
		int N = Integer.parseInt(br.readLine());
		Set<Integer> set = new TreeSet<>();
		int[] cnt = new int[10];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++)
		{
			int tmp = Integer.parseInt(st.nextToken());
			cnt[tmp]++;
		}
		for(int i = 0 ; i < 10 ; i++)
			if(cnt[i] == 0)
				set.add(i);	//고장나지 않은 버튼
		
		ArrayList<Integer> arr = new ArrayList<>();
		String str = Integer.toString(target);
		
		for(int i = 0 ; i < str.length() ; i++)
		{
			
		}
		
		
		
	}

}
