import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int tc = Integer.parseInt(br.readLine());
		int[] arr = new int[10];
		for(int num = 1 ; num <= tc ; num++) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < arr.length ; i++) arr[i] = Integer.parseInt(st.nextToken());
			for(int i = 0 ; i < arr.length ; i++) arr[i] = sumEachIdx(arr[i]);
			Arrays.sort(arr);
			bw.append(String.format("#%d %d %d\n",num,arr[arr.length-1],arr[0]));
		}
		bw.close();
	}
	private static int sumEachIdx(int val) {
		int sum = 0;
		while(val > 0) {
			sum += val % 10;
			val /= 10;
		}
		return sum;
	}

}
