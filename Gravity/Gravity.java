package day2;

public class Gravity {
	public static void main(String[] args){
		
		int[] arr = {7,4,2,0,0,6,6,0};
		
		int max = 0;
		int N = arr.length;
		for (int i = 0; i < N; i++) {
			int cnt = N - (i + 1); // 오른쪽으로 돌리면 크기 N에서 내 인덱스+1 을 뺀게 최대 낙차
			for(int j = i + 1; j < N; j++) { 
				//내 오른쪽으로 나보다 키가 크거나 같은 친구가 있으면 최대낙차 - 1
				if(arr[j] >= arr[i])
					cnt--;
			}
			//cnt에 내 낙차 max에 현재까지 검사한 막대들 중 최대낙차
			if(max < cnt)
				max = cnt;
		}
		System.out.println(max);
	}

}
