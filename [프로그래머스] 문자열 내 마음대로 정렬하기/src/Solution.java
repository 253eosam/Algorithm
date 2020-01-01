import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public static ArrayList<String>[] list;
    public String[] solution(String[] strings, int n) {
        list = new ArrayList[26];
        for(int i = 0 ; i < list.length ; i++){
            list[i] = new ArrayList<>();
        }
    
        for(int i = 0 ; i < strings.length ; i++){
            char key = strings[i].charAt(n);
            list[key-'a'].add(strings[i]);
        }

        ArrayList<String> tempList = new ArrayList<>();
        for(int i = 0 ; i < list.length ; i++) {
        	Collections.sort(list[i]);
        	for(String str : list[i]) {
        		tempList.add(str);
        	}
        }
        String[] answer = new String[tempList.size()];
        for(int i = 0 ; i < tempList.size() ; i++) {
        	answer[i] = tempList.get(i);
        }
      
      return answer;
  }
    public static void main(String[] args) {
    	Solution sol = new Solution();
//    	String[] strings = {"abce","abcd","cdx"};
    	String[] strings = {"sun","bed","car"};
    	int n = 1;
    	sol.solution(strings, n);
    }
}