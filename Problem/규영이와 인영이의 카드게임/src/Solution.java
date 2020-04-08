import java.util.Scanner;

public class Solution {

	static long min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			long[][] arr = new long[N][2];

			min = 999999999999999L;

			for (int i = 0; i < N; i++) {
				arr[i][0] = sc.nextInt();

				arr[i][1] = sc.nextInt();

			}

			boolean[] sel = new boolean[N];
			comb(arr, 0,0,sel);
			System.out.println("#"+tc+" "+min);
		}
	}


	static void comb(long[][] arr, int idx, int select, boolean[] sel) {
		if (idx == arr.length) {
			long sumX = 0L;
			long sumY = 0L;
			if (select == arr.length / 2) {
				long v = 0L;
				for (int i = 0; i < arr.length; i++) {
					if (sel[i]) {
						sumX += arr[i][0];
						sumY += arr[i][1];
					}if(!sel[i]) {
						sumX -= arr[i][0];
						sumY -= arr[i][1];
					}
				}
				v =(sumX*sumX +sumY*sumY);
				if (v < min)
					min = v;
			}
			return;
		}
		sel[idx] = true;
		comb(arr, idx + 1, select + 1, sel);
		sel[idx] = false;
		comb(arr, idx + 1, select, sel);
	}
}