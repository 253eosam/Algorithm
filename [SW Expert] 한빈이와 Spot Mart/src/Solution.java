import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	
	public static int N,M;
	public static Integer[] arr;
	
	public static void main(String[] args) throws IOException {
		int testCase = Integer.parseInt(br.readLine());
		for(int num = 1 ; num <= testCase ; num++) {
			input();
			int result = logic();
			bw.append(String.format("#%d %d\n", num,result));
		}
		bw.close();
		
	}

	private static int logic() {
		
		sortArr(arr);
		
		int maximum = -1;
		for(int i = 0 ; i < arr.length ; i++) {
			int pick = arr[i];
			for(int j = arr.length-1 ; j > i ; j--) {
				int tmp = pick + arr[j];
				if(tmp == M) return M;
				if(tmp <= M) maximum = maximum < tmp ? tmp : maximum;
				else break;
			}
		}
		return maximum;
	}
	
	public static void sortArr(Integer[] arr) {
		Arrays.sort(arr, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		
	}

	private static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new Integer[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}

}
