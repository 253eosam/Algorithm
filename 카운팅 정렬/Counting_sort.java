
public class Counting_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = new int[] {9,8,7,6,5,4,4,3,2,1};
		couting_sort(arr);
	}
	
	public static void couting_sort(int[] arr)
	{
		int[] count = new int[arr.length];
		for(int i:arr)
			count[i]++;
		int[] sortArr = new int[arr.length];
		int cnt = 0;
		for(int i = 0 ; i < arr.length; i++)
		{
			while(count[i] > 0)
			{
				sortArr[cnt++] = i;
				count[i]--;
			}
		}
		
		for(int i = 0; i < sortArr.length ; i++)
			System.out.println("sortArr[" + i + "] : " + sortArr[i]);
	}
}
