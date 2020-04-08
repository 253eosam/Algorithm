import java.util.ArrayList;

/*
 * [2020카카오공채] 문자열 압축
 */
public class Solution {
	public static int solution(String s) {
		if(s.length() <= 2) return s.length();
		int minimum = Integer.MAX_VALUE;
		for(int unit = 1 ; unit <= s.length()/2 ; unit++) {
			// 문자열 쪼개기
			int idx = unit ,preIdx = 0;
			ArrayList<String> list = new ArrayList<>();
			for(idx = unit ; idx <= s.length() ; idx += unit) {
				String str = s.substring(preIdx, idx);
				list.add(str);
				preIdx = idx;
			}
			if(idx != s.length()) list.add(s.substring(preIdx));
			
			
			// 문자열 비교
			int cnt = 1; String preStr , str = "";
			StringBuilder sb = new StringBuilder();
			for(int i = 1 ; i < list.size() ; i++) {
				preStr = list.get(i-1);
				str = list.get(i);
				if(str.equals(preStr)) {
					cnt++;
				}else {
					if(cnt == 1) sb.append(preStr);
					else sb.append(cnt+preStr);
					cnt = 1;
				}
			}
			if(cnt == 1) sb.append(str);
			else sb.append(cnt+str);
			minimum = Math.min(minimum, sb.length());
		}//for unit
		
		
		return minimum;
		
	}

	public static void main(String[] args) {
		String[] inputs = { "aabbaccc", "ababcdcdababcdcd", "abcabcdede", "abcabcabcabcdededededede",
				"xababcdcdababcdcd","a" };
		int[] results = { 7, 9, 8, 14, 17, 1 };
		for (int i = 0; i < inputs.length; i++) {
			int result = solution(inputs[i]);
			if (result != results[i]) {
				System.out.println("result : " + result);
				return;
			}
		}
		System.out.println("success!!");
	}
}
