class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int pCnt=0, yCnt=0;
        
        s = s.toLowerCase();
        for(int i = 0 ; i < s.length() ; i++) {
        	if(s.charAt(i) == 'p') pCnt++;
        	else if(s.charAt(i) == 'y') yCnt++;
        }
        
        return pCnt == yCnt;
    }
    public static void main(String[] args) {
    	String s = "Pyy";
    	System.out.println(new Solution().solution(s));
    }
}