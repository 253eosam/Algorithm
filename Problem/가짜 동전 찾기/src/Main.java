
public class Main {
	public static int arr[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		arr = new int[] {2,2,2,2,2,2,2,2,2,2, 2,2,2,1,2 ,2,2,2,2,2 ,2,2,2,2};
		System.out.println(arr.length + ", arr[13] :" + arr[13]);
		System.out.println("index : " + binarySearch(0, arr.length));
	}
	public static int binarySearch(int left, int right)
	{
		int mid = (left + right) / 2;
				
		int sumLeft, sumRight;
		sumLeft = sumRight = 0;
		
		for(int i = left ; i < mid ; i++)
			sumLeft += arr[i];
		
		for(int i = (right-left) % 2 == 0 ? mid : mid+1 ; i < right ; i++)
			sumRight += arr[i];
		
		if(sumLeft == sumRight)
			return mid;
		
		return sumLeft < sumRight ? binarySearch(left,mid) : binarySearch(mid, right);
		
	}

}
