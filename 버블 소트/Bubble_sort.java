

public class Bubble_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = new int[] {9,8,7,6,5,4,3,2,1};
		bubble_sort(arr);
	}
	
	public static void bubble_sort(int[] arr)
	{

		for(int i = 1 ; i < arr.length ; i++)
		{
			for(int j = 0 ; j < arr.length-i ; j++)
			{
				if(arr[j] > arr[j+1])
				{
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		
		for(int i = 0 ; i < arr.length; i++)
			System.out.println("arr[" + i + "] : " + arr[i]);
		
			
	}

}
