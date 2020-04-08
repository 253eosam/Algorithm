import java.util.ArrayList;

class Solution {
    public static int[][] player = { {1,2,3,4,5}
                                    ,{2,1,2,3,2,4,2,5}
                                    ,{3,3,1,1,2,2,4,4,5,5} };
    public static int[] playerPoint = new int[3];
    public static int[] solution(int[] answers) {
        int[] answer = {};
        
        for(int i = 0 ; i < answers.length ; i++){
            for(int j = 0 ; j < player.length; j++){
                if(answers[i] == (player[j][i % player[j].length]))
                    playerPoint[j]++;
            }
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        int maximum = 0;
        for(int i = 0 ; i < playerPoint.length ; i++) {
        	if(maximum < playerPoint[i]) {
        		maximum = playerPoint[i];
        		list.clear();
        		list.add(i);
        	}else if(maximum == playerPoint[i]) {
        		list.add(i);
        	}
        }
        
        answer = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++) {
        	answer[i] = list.get(i)+1;
        }
        
        return answer;
    }
 
}