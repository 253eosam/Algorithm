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
}