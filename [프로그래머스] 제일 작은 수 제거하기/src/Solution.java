import java.util.ArrayList;
class Solution {
  public static int[] solution(int[] arr) {
	  
	  ArrayList<Integer> list = new ArrayList<>();
	  int min = Integer.MAX_VALUE, minIdx = 0;
	  for(int i = 0 ; i < arr.length ; i++) {
		  if(arr[i] < min) {
			  min = arr[i];
			  minIdx = i;
		  }
		  list.add(arr[i]);
	  }
	  
	  list.remove(minIdx);
	  if(list.size() == 0) list.add(-1);
	  
	  int[] answer = new int[list.size()];
	  for(int i = 0 ; i < list.size() ; i++) answer[i] = list.get(i);
	  
	  return answer;
	  
  }
}