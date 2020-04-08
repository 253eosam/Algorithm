import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.out.println(

				logic();

//		);
	}

	private static void logic() throws NumberFormatException, IOException {
		int tc = Integer.parseInt(br.readLine());
		for (int num = 1; num <= tc; num++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[] R = new int[N];
			int[] W = new int[M];
			for (int i = 0; i < N; i++)
				R[i] = Integer.parseInt(br.readLine());
			for (int i = 0; i < M; i++)
				W[i] = Integer.parseInt(br.readLine());

			int[] arrPark = new int[N];
			Queue<Integer> queue = new LinkedList<>();

			int sum = 0;
			for (int i = 0; i < 2 * M; i++) {
				int carNum = Integer.parseInt(br.readLine());
				int idx = findIndex(arrPark,Math.abs(carNum));
				if (idx == -1) { // 들어옴
					if ((idx = isEmptyPark(arrPark)) < N) { // 공간있음
						arrPark[idx] = carNum;
					} else { // 공간없음
						queue.add(carNum);
					}
				} else { // 나감
					sum += calFare(R, W, idx, -carNum);
					arrPark[idx] = 0;

					if (!queue.isEmpty()) {
						idx = isEmptyPark(arrPark);
						arrPark[idx] = queue.poll();
					}
				}
			}//for end parking
			bw.append(String.format("#%d %d\n",num,sum));
		}
		bw.close();
	}

	public static int calFare(int[] R, int[] W, int idx, int carNum) {
		return R[idx] * W[carNum - 1];
	}

	public static int findIndex(int[] arr, int val) {
		for (int i = 0; i < arr.length; i++)
			if (val == arr[i])
				return i;
		return -1;
	}

	private static int isEmptyPark(int[] park) {
		int idx = 0;
		for (; idx < park.length; idx++)
			if (park[idx] == 0)
				break;
		return idx;
	}

}
