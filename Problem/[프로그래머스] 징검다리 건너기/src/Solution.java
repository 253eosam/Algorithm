import java.util.Arrays;

class Solution {
	public int solution(int[] stones, int k) {
		int[] tmp = stones.clone();
		Arrays.sort(tmp);
		int min = tmp[0]; int max = tmp[tmp.length-1];
		while(max > min) {
			int mid = (max+min)/2;
			if(!inspec(stones, k, mid)) {
				max = mid;
			}else {
				min = mid+1;
			}
		}
		return  max;
	}

	public boolean inspec(int[] stones, int k, int val) {
		int idx = -1;
		outer: while (stones.length > idx) {
			for (int j = k; j > 0; j--) {
				if(idx + j == -1 )return false;
				if (idx + j >= stones.length)
					return true;
				if (stones[idx + j] - val > 0) {
					idx += j;
					continue outer;
				} 
			}
			break;
		}
		return stones.length <= idx;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().solution(new int[] { 2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3));
	}
}