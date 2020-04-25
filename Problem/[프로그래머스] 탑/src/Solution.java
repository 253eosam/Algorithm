import java.util.*;

class Solution {
	public int[] solution(int[] heights) {
		int size = heights.length;
		int[] answer = new int[size];

		Stack<Integer> s = new Stack<Integer>();
		s.add(heights[size - 1]);
		for (int i = size - 2; i >= 0; i--) {
			int idx = 1;
			while (!s.empty() && heights[i] > s.peek()) {
				answer[i+idx++] = (i + 1);
				s.pop();
			}
			s.add(heights[i]);
		}

		System.out.println(Arrays.toString(answer));

		return answer;
	}

	public static void main(String[] args) {
		int[][] input = new int[][] {
			{6,9,5,7,4},{3,9,9,3,5,7,2},{1,5,3,6,7,6,5}
		};
		for(int i = 0 ; i < 3 ; i++)
		System.out.println(

				new Solution().solution(input[i]));
	}
}