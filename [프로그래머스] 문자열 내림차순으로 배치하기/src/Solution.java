import java.util.Arrays;
import java.util.Comparator;

class Solution {
	String solution(String s) {
       Character[] chars = new Character[s.length()];
       
       for(int i = 0 ; i < s.length() ; i++) {
    	   chars[i] = s.charAt(i);
       }

       Arrays.sort(chars,Comparator.reverseOrder());
       StringBuilder sb = new StringBuilder();
       for(int i = 0 ; i < chars.length ; i++) {
    	   sb.append(chars[i]);
       }
       return new String(sb);
    }
    public static void main(String[] args) {
    	String s = "Zbcdefg";
    	System.out.println(new Solution().solution(s));
    }
}