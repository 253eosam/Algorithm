public class Solution {

	public static void main(String[] args) {
		int[] arr = { 5,3,7,2,1,8,9,9};
		int len = arr.length;
		quick_sort(arr,0,len-1);
		for(int i = 0 ; i < len; i++)
			System.out.println("arr[" + i + "] : " + arr[i]);
	}


	public static void quick_sort(int[] arr, int left, int right)
	{
		int pivot = arr[(left+right)/2];
		int start = left;
		int end = right;
		while(start < end)
		{
			while(arr[start] < pivot)
				start++;
			while(pivot < arr[end])
				end--;
			if(start <= end)
			{
				int tmp = arr[start];
				arr[start] = arr[end];
				arr[end] = tmp;

				start++;
				end--;
			}
			
			if(start < right) 
				quick_sort(arr,start,right);
			if(left < end)
				quick_sort(arr,left,end);
			
		}
	}
}