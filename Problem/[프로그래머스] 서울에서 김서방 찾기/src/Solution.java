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
      
      return "�輭���� " + answer + "�� �ִ�";
  }
  
  
  public String findKim(String[] seoul){
      //x�� �輭���� ��ġ�� �����ϼ���.
      int x = Arrays.asList(seoul).indexOf("Kim");

      return "�輭���� "+ x + "�� �ִ�";
  }
}	