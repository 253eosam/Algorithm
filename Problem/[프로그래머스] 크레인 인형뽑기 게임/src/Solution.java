import java.util.Stack;

class Solution {
	public int solution(int[][] board, int[] moves) {
		int answer = 0;
		int size = board[0].length;
		Stack<Integer>[] s = new Stack[size];
		for(int i = 0 ; i < size ; i++)
			s[i] = new Stack<Integer>();
		
		for(int i = 0 ; i < board[0].length ; i++) {
			for(int j = board.length-1 ; j >= 0 ; j--) {
				int tmp = board[j][i];
				if(tmp == 0) break;
				s[i].push(tmp);
			}
		}
		
		Stack<Integer> cart = new Stack<>();
		for(int i = 0 ; i < moves.length ; i++) {
			if(s[moves[i]-1].empty()) continue;
			int tmp = s[moves[i]-1].pop();
			if(!cart.empty() && cart.peek() == tmp) {
				cart.pop();
				answer += 2;
			}else cart.push(tmp);
		}
		
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(

				new Solution().solution(
						new int[][] { 
							{ 0, 0, 0, 0, 0 }, 
							{ 0, 0, 1, 0, 3 }, 
							{ 0, 2, 5, 0, 1 },
							{ 4, 2, 4, 4, 2 }, 
							{ 3, 5, 1, 3, 1 } }, 
						new int[] { 1, 5, 3, 5, 1, 2, 1, 4 }));
	}
}