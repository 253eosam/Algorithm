import java.util.ArrayList;

public class Solution {
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        boolean[] isCompleted = new boolean[progresses.length];
        
        ArrayList<Integer> list = new ArrayList<>();
        while(true) {
        	int cnt = 0;
        	boolean pass = true;
        	for(int i = 0 ; i < progresses.length; i++) {
        		if(isCompleted[i]) continue;
        		progresses[i] += speeds[i];
        		pass = false;
        		System.out.println(progresses[i]);
        		if(!isCompleted[i] && progresses[i] >= 100) {
        			if(i == 0) isCompleted[i] = true;
        			else isCompleted[i] = isCompleted[i-1];
        		}
        		if(isCompleted[i]) cnt++;
        	}
        	if(cnt != 0) list.add(cnt);
        	if(pass) break;
        }
        System.out.println(list.toString());
        answer = new int[list.size()];
        for(int i=0;i<list.size();i++) answer[i] = list.get(i);
        return answer;
    }
}
