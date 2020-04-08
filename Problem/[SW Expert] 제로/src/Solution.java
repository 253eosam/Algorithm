import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		int tc = Integer.parseInt(br.readLine());
		for(int num = 1; num <= tc ; num++) {
			
			//input
			int K = Integer.parseInt(br.readLine());
			int [] arr = new int[K];
			for(int i = 0 ; i < K ; i++) arr[i] = Integer.parseInt(br.readLine());
			
			//calculate
			int sum = calMoney(arr);
			bw.append(String.format("#%d %d\n",num, sum));
		}
		bw.close();
	}


	private static int calMoney(int[] arr) throws NumberFormatException, IOException {
		
		Stack<Integer> stack = new Stack<>();
		
		int sumMoney = 0;
		
		for(int money : arr) 
			sumMoney += money == 0 ? -stack.pop() : stack.push(money);

		return sumMoney;
	}
	
}
