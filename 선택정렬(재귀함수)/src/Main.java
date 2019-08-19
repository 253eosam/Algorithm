import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {1,0,8,5,2,7,4,1,9,6,3,10};

		selectedSort(arr);
		
		System.out.println(Arrays.toString(arr));
	}
	
	public static void selectedSort(int[] arr)
	{
		for(int i = 0 ; i < arr.length ; i++)
		{
			int tmp = 0;
			tmp = selectSortRecursion(arr, i);
			swap(arr,i,tmp);
		}
	}
	
	public static int selectSortRecursion(int[] arr, int depth)
	{
		if(arr.length-1 == depth) return depth;
		
		int minimumIndex = depth;
		int tmp = selectSortRecursion(arr, depth+1);
		minimumIndex = arr[tmp] < arr[depth] ? tmp : depth;
		
		return minimumIndex;
	}
	
	public static void swap(int[] arr , int a, int b)
	{
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

}
