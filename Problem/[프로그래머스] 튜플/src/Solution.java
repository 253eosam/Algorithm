import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        
        ArrayList<String> list = new ArrayList<>(); 
        Queue<Character> queue = new LinkedList<>();
        for(int i = 1 ; i < s.length()-1; i++) {
        	Character tmp = s.charAt(i);
        	if(tmp == '}') {
        		StringBuilder sb = new StringBuilder();
        		while(!queue.isEmpty()) {
        			Character c = queue.poll();
        			if(c == '{') continue;
        			sb.append(c);
        		}
        		i++;
        		list.add(sb.toString());
        	}else {
        		queue.add(tmp);
        	}
        }
        Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
        int[] arr = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++) {
        	ArrayList<Integer> tmpList = new ArrayList<>();
        	for(String tmpStr : list.get(i).split(",")) {
        		tmpList.add(Integer.parseInt(tmpStr));
        	}
        	for(int j = 0 ; j < i ; j++) {
        		int tmp = arr[j];
        		tmpList.remove((Object)tmp);
        	}
        	arr[i] = tmpList.get(0);
        }
        
        return answer = arr;
    }
    public static void main(String[] args) {
    	System.out.println(
    			
    			Arrays.toString(new Solution().solution(new String("{{4,2,3},{3},{2,3,4,1},{2,3}}"	)))
    			
    			);
    }
}