import java.util.*;

public class Solution {
	public int[] solution(int []arr) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<Integer>();
        int pivot = arr[0];
        for(int i = 1 ; i < arr.length ; i++){
            if(pivot == arr[i]) continue;
            list.add(pivot);
            pivot = arr[i];
        }

        list.add(pivot);
        answer = new int[list.size()];
        for(int i = 0 ; i < list.size(); i++){
            answer[i] = list.get(i);
        }


        return answer;
	}
}