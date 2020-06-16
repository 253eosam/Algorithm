import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		new Solution().solution(4);
	}

    public int[] solution(int n) {
    	int len = (int)Math.pow(2, n)-1;
        int[] answer = new int[len];
        dfs(0,len,0,answer);
        
        System.out.println(Arrays.toString(answer));
        return answer;
    }

	private void dfs(int left, int right,int pValue, int[] answer) {
		if(left == right) return;
		int mid = (left+right)/2;
		answer[mid] = pValue;
		dfs(left,mid,0,answer);
		dfs(mid+1,right,1,answer);
	}


}
