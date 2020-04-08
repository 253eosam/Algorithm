class Solution {
    public static int[][] 둠스데이 = { {4,4},{6,6},{8,8},{10,10},{12,12},
                                        {5,9},{9,5},{7,11},{11,7},{3,7} //월요일 (윤년의 경우 이전년도의 두칸 건너뛰기)
                                        ,{2,29},{1,11}
                                        };
    public static String[] 요일 = {"MON","TUE","WED","THU","FRI","SAT","SUN"};
  public String solution(int a, int b) {
      String answer = "";

      for(int i = 0 ; i < 둠스데이.length ; i++){
          if(a == 둠스데이[i][0]){
              int day = (b-둠스데이[i][1]);
              if(day >= 0){
                day %= 7;
                answer = 요일[day];    
              }else{
                  day = -day;
                  answer = 요일[요일.length-(day%7)];
              }
              break;
          }
      }
      
      return answer;
  }
}