import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
	public int answer;
	public Set<String> set;
	public int solution(String[] user_id, String[] banned_id) {
		int size = banned_id.length;
		set=new HashSet<String>();
		com(user_id, banned_id, 0, 0, size, new int[size], new boolean[size]);
		return answer;
	}

	public void com(String[] user_id, String[] banned_id, int idx, int deep, int target, int[] picked,boolean[] visitedBan) {
		if (deep == target) {
			String tmp = Arrays.toString(picked);
			if(!set.contains(tmp)) {
				set.add(tmp);
				answer++;
			}
			return;
		}

		for (int i = idx; i < user_id.length; i++) {
			for (int j = 0; j < banned_id.length; j++) {
				if(visitedBan[j]) continue;
				if (inspec(user_id[i], banned_id[j])) {
					picked[deep] = i;
					visitedBan[j] = true;
					com(user_id, banned_id, i + 1, deep + 1, target, picked,visitedBan);
					visitedBan[j] = false;
				}
			}
		}
	}

	public boolean inspec(String user, String ban) {
		if (user.length() != ban.length())
			return false;
		for (int i = 0; i < user.length(); i++) {
			if (ban.charAt(i) == '*')
				continue;
			if (ban.charAt(i) != '*' && user.charAt(i) == ban.charAt(i))
				;
			else
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().solution(new String[] { "frodo", "fradi", "crodo", "abc123", "frodoc" },
				new String[] { "*rodo", "*rodo", "******"}));
//		System.out.println(new Solution().inspec("frodo", "*rodo"));
	}
}