class Solution {
  public String solution(String s) {
      String answer = "";
      
      String[] splitStrArr = s.split(" ",-1);
      StringBuilder sb = new StringBuilder();
      for(String str : splitStrArr){
//    	  if("".equals(str)) continue;
          for(int i = 0 ; i < str.length(); i++){
              String tmp = String.valueOf(str.charAt(i));
              if(i%2==0) sb.append(tmp.toUpperCase());
              else if(i%2==1) sb.append(tmp.toLowerCase());
          }
          sb.append(" ");
      }
      answer = new String(sb);
      return answer.substring(0,answer.length()-1);
  }
  public static void main(String[] args) {
	  System.out.println(new Solution().solution("try    hello world"));
  }
}