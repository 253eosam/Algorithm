import java.util.*;

class Solution {
    public static int answer;
    public static void main(String[] args) {
    	System.out.println(
    			
    			solution(new int[]{1,1,1,1,1},3)
    			
    	);
    }
    public static int solution(int[] numbers, int target) {
        answer = 0;

        dfs(numbers, 1,0,0,target);
        dfs(numbers,-1,0,0,target);

        return answer;
    }

    public static void dfs(int[] arr, int dir, int idx, int sum, int target){
        if(idx == arr.length) return;
        int val = sum + dir * arr[idx];
        if(idx == arr.length - 1 && val == target) answer++;
        dfs(arr, dir,idx+1,val,target);
        dfs(arr,-dir,idx+1,val,target);
    }
}