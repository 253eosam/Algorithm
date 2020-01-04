import java.util.ArrayList;
import java.util.Arrays;

class Solution {


public String solution(String s, int n) {
      final int len = 26;
      ArrayList<Character> alpha = new ArrayList<>();
      ArrayList<Character> beta = new ArrayList<>();

      for(int i = 0 ; i < len ; i++){
          alpha.add( (char)('A'+i));
          beta.add( (char)('a'+i));
      }
      
      System.out.println(alpha);
      System.out.println(beta);
      
      StringBuilder sb = new StringBuilder();
      for(int i = 0 ; i < s.length(); i++){
          char val = s.charAt(i); int idx = 0;
          if((idx = alpha.indexOf(val)) > beta.indexOf(val)) val = alpha.get((idx+n)%len);          
          else if((idx = beta.indexOf(val)) > alpha.indexOf(val)) val = alpha.get((idx+n)%len);
          sb.append(val);
      }
      
      return sb.toString();
  }
  
  public static void main(String[] args) {
	  Solution s = new Solution();
	  String result = s.solution("AB", 1);
	  System.out.println(result);
  }
}