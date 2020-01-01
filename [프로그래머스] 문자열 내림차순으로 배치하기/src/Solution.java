import java.util.Arrays;

class Solution {
	String solution(String s) {
       char[] chars = s.toCharArray();
       
       Arrays.sort(chars);
       
       return new StringBuilder(new String(chars)).reverse().toString();
    }
    public static void main(String[] args) {
    	String s = "Zbcdefg";
    	System.out.println(new Solution().solution(s));
    }
}