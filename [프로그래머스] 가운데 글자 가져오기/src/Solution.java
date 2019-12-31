class Solution {
  public String solution(String s) {
      String answer = "";
      int len=s.length();
      answer = s.substring((len-1)/2,len/2+1);
      return answer;
  }
}