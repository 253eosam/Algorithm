import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        boolean[] students = new boolean[n+2];
        
        for(int i = 0 ; i < lost.length ; i++){
            students[lost[i]] = true;
        }// 잃어버린 학생들
        
        ArrayList<Integer> reserveList = new ArrayList<Integer>();
        for(int i = 0 ; i < reserve.length ; i++){
            if(students[reserve[i]]){
                students[reserve[i]] = false;
                answer++;
            }else{
                reserveList.add(reserve[i]);
            }
        }// 여벌의 체육복을 보유한 학생이 도난당한 경우
        
        for(int i = 0 ; i < reserveList.size() ; i++){
            int idx = reserveList.get(i);
            if(students[idx-1]){
                students[idx-1] = false;
                answer++;
        
            }
            else if(students[idx + 1]){
                students[idx+1] = false;
                answer++;
               
            }
        }
        
        
        return answer;
    }
}