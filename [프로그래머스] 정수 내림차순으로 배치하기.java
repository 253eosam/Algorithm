class Solution {
  public long solution(long n) {
      long answer = 0;
      int[] numberCnt = new int[10];
      while(n != 0){
          int temp = (int)n%10;
          n/=10;
          numberCnt[temp]++;
      }
      for(int i = 9 ; i >= 0 ; i--){
          if(numberCnt[i] == 0) continue;
          for(int j = 0; j < numberCnt[i] ; j++){
              answer *= 10;
              answer += i;
          }
      }
      return answer;
  }
}