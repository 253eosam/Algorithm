import java.util.Arrays;

class Solution {
	public static String solution(String[] participant, String[] completion) {
        String answer = "";
        int len = completion.length;
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for(int i = 0 ; i < len ; i++) {
        	if(!participant[i].equals(completion[i])) {
        		answer = participant[i];
        		break;
        	}
        }
        if(answer.isEmpty())
        	return participant[len];
        return answer;
    }
}