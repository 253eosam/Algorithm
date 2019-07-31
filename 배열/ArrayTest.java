
public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		int[][] arr = { 
				{1,2,3,4},
				{2,3,4,5},
				{3,5,2,1},
				{1,5,6,3}};
		
		// 합을구하는데 그 합이 가장 큰 위치의 좌표값과 그 합을 출력하라
		
		int maximum = -987654321; int mx = -1 ; int my = -1;
		for(int y = 0 ; y < arr.length ; y++)
		{
			for(int x = 0 ; x < arr[y].length ; x++)
			{
				int sum = 0;
				int[] dx = {0,0,-1,1};
				int[] dy = {-1,1,0,0};
				
				int tx , ty;
				
				for(int i = 0 ; i < 4; i++)
				{
					tx = x + dx[i];
					ty = y + dy[i];
					if(tx < 0 || tx >= arr[y].length || ty < 0 || ty >= arr.length)
					{
						continue;
					}
					sum += arr[ty][tx];
				}
				
				if(maximum < sum)
				{
					maximum = sum;
					mx = x;	my= y;
				}
			}
		}
		System.out.println("maximum :" + maximum + ", x : "+ mx + ", y : " + my);
		
		/*
		// 특정한 셀으 상하좌우 값의 합을 구하여 출력하라
		int x , y;
		x = 0 ; y = 2;
		int sum = 0;
		int[] dx = {0,0,-1,1};
		int[] dy = {-1,1,0,0};
		
		int tx , ty;
		
		for(int i = 0 ; i < 4; i++)
		{
			tx = x + dx[i];
			ty = y + dy[i];
			if(tx < 0 || tx >= arr.length || ty < 0 || ty >= arr.length)
			{
				continue;
			}
			sum += arr[ty][tx];
		}
		
		System.out.println("sum : " + sum);
		*/
	}

}
