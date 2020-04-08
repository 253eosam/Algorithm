import java.util.Arrays;

class Solution {
  public String solution(String[] seoul) {
      int answer = 0;
      
      for(int i = 0 ; i < seoul.length ; i++){
          String str = seoul[i];
          if("Kim".equals(str)){
              answer = i;
              break;
          }
      }
      
      return "김서방은 " + answer + "에 있다";
  }
  
  
  public String findKim(String[] seoul){
      //x에 김서방의 위치를 저장하세요.
      int x = Arrays.asList(seoul).indexOf("Kim");

      return "김서방은 "+ x + "에 있다";
  }
}	