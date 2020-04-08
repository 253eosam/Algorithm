

class Solution {
  public static long solution(long n) {
      double answer = 0;
      answer = Math.sqrt(n);
      if(answer % 1 > 0) 
    	  answer = -1;
      else 
          answer = Math.pow(answer+1,2);
      
      return (long)answer;
  }
  public static void main(String[] args) {
	  System.out.println(solution(3));
  }
}