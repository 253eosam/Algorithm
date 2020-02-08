import java.util.Arrays;

class Solution {
  public static String[] solution(int n, int[] arr1, int[] arr2) {
      String[] answer = new String[n];
      for(int i = 0 ; i < n ; i++) {
    	  String tmp = Integer.toBinaryString(arr1[i] | arr2[i]);
    	  StringBuilder sb = new StringBuilder();
    	  
    	  if(tmp.length() != n) {
    		  while(tmp.length() != n) {
    			  tmp = "0"+tmp;
    		  }
    	  }
    	  for(int j = 0 ; j < tmp.length() ; j++) {
    		  sb.append(tmp.charAt(j) == '1' ? "#" : " ");
    	  }
    	  answer[i] = sb.toString();
      }
      return answer;
  }
  public String[] solution2(int n, int[] arr1, int[] arr2) {
      String[] result = new String[n];
      for (int i = 0; i < n; i++) {
          result[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
      }

      for (int i = 0; i < n; i++) {
          result[i] = String.format("%" + n + "s", result[i]);
          result[i] = result[i].replaceAll("1", "#");
          result[i] = result[i].replaceAll("0", " ");
      }

      return result;
  }
  public static void main(String[] args) {
	  int n = 6;
	  int[] arr1 = {46, 33, 33 ,22, 31, 50};
	  int[] arr2 = 	{27 ,56, 19, 14, 14, 10};
	  String[] result = solution(n, arr1, arr2);
	  System.out.println(Arrays.toString(result));
  }
}