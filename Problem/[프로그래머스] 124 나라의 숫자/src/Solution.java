
public class Solution {

	public static void main(String[] args) {
		for(int i = 1 ; i <= 10 ; i++)
		System.out.println(i + " : " + solution(i));
	}

	public static String solution(int n) {
		
		StringBuilder sb = new StringBuilder();
		while(n > 0) {
			sb.append("124".charAt((n-1)%3));
			n = (n-1)/3;
		}
		return sb.reverse().toString();
	}
}