import java.util.Arrays;

public class LotationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 1,2,3,4,5,6,7,8,9,10};
		System.out.print("lotation!\n" + Arrays.toString(arr) + " -> " );
		lotate(arr);
		System.out.println(Arrays.toString(arr));


		// 90도 회전한 것처럼 arr배열의 값을 brr배열에 넣어라
		// 전치행렬을 crr배열에 넣어라
		int[][] arr2 = new int[4][4];
		int cnt = 0 ;
		int[][] brr = new int[4][4];
		int[][] crr = new int[4][4];
		System.out.println("\n기본 2차원 배열!");
		for(int i = 0 ; i < 4; i++)
		{
			for(int j = 0 ; j < 4 ; j++)
			{
				arr2[i][j] = ++cnt;
				brr[3-j][i] = arr2[i][j];
				crr[j][i] = arr2[i][j];
				System.out.print(arr2[i][j] + "\t");
			}
			System.out.println();
		}

		System.out.println("\n왼쪽으로 90도 회전");

		for (int i = 0; i < brr.length; i++) {
			for (int j = 0; j < brr[i].length; j++) {
				System.out.print(brr[i][j] + "\t");
			}
			System.out.println();
		}


		//전치 행렬
		System.out.println("\n전치행렬!");

		for (int i = 0; i < crr.length; i++) {
			for (int j = 0; j < crr[i].length; j++) {
				System.out.print(crr[i][j] + "\t");
			}
			System.out.println();
		}

	}
	static void lotate(int[] arr)
	{
		int tmp;
		tmp = arr[0];
		for(int i = 0 ; i < arr.length-1; i++)
			arr[i] = arr[i+1];
		arr[arr.length-1] = tmp;

	}

}
