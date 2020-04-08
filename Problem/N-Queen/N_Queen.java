
public class N_Queen {
	public static int cnt = 0;
	public static void main(String[] args)
	{
		
		int N = 4;
		int[] arr = new int[N];
		
		backtracking(arr,0);
		
		System.out.println("cnt : " + cnt);
	}
	
	public static void backtracking(int[] arr, int depth)
	{
		
		if(depth == arr.length)
		{
			cnt++;
			for(int i = 0 ; i < arr.length; i++)
				System.out.print(arr[i] + " ");
			System.out.println();
			return ;
		}
		
		for(int i = 0 ; i < arr.length; i++)
		{
			arr[depth] = i;
			// 유망한 조건인지 판별 : 이 조건으로 실행했을경우 올바르게 나오는지
			if(permising(arr,depth))
			backtracking(arr,depth+1);
		}
		
	}
	
	public static boolean permising(int[] arr, int depth)
	{
		boolean flag = true;
		
		for(int i = 0 ; i < depth; i++)
		{
			if(arr[i] == arr[depth] ||	// 같은 위치에 있는 조건
					arr[i] + i - depth == arr[depth] ||		// 대각선 위치에 있는 조건
					arr[i] - i + depth == arr[depth])
			{
				flag = false;
				break;
			}
		}
		
		return flag;
	}
	
}