import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String N = sc.nextLine();
		int[] nums = new int[10];
		for(char c : N.toCharArray()) {
			int tmp = c - '0';
			nums[tmp]++;
			
		}
		int sum = 0;
		for(int i = 1 ; i <= 9 ; i++){
			sum += nums[i] * i;
		}
		if(nums[0] <= 0) System.out.println(-1);
		else if(sum % 3 == 0){
			StringBuilder bs = new StringBuilder();
			for(int i = 9 ; i >= 0 ; i--) 
				for(int j = 0 ; j < nums[i] ; j++)
					bs.append(i);
			System.out.println(bs.toString());
		}else System.out.println(-1);
	}
}