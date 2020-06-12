import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		System.out.println(solution("()(((()())(())()))(())"));
	}

	public static int solution(String arrangement) {
		int answer = 0;
		
		Stack<String> stack = new Stack<>();
		for(int i = 0 ; i < arrangement.length() ; i++) {
			char c = arrangement.charAt(i);
			if( c == ')' && arrangement.charAt(i-1) == ')') {
				int cnt = 0;
				int bim = 1;
				while( bim != 0 ) {
					String tmp = stack.pop();
					if(")".equals(tmp)) {
						bim++;cnt++;
					}
					else if("(".equals(tmp)) bim--;
					else cnt += Integer.parseInt(tmp);
				}
				answer += cnt +1;
				if(cnt > 0) stack.add(String.valueOf(cnt));
			}else stack.add(String.valueOf(c));
		}
		
		return answer;
	}
}
