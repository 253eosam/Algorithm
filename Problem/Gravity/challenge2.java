public class Solution {

	public static int MAX_SIZE = 100;

	public static void main(String[] args) {
		
		int[] data = new int[]{0,4,2,0,0,6,0,7,0};
		int col = MAX_SIZE;
		int row = data.length;
		
		int maximum = 0;
		
		//	maximum of data_array
		for(int i : data)
			if(maximum < data[i])
				maximum = data[i];
		
		int solv = data.length;
		int maxCnt = 0;
		int maxSw = 0;
		for(int i = 0 ; i < data.length; i++)
		{
			if(maxSw == 1 && maximum == data[i])
				maxCnt++;
			else if(maximum == data[i])
			{
				solv -= i+1;
				maxSw = 1;
			}
		}
		solv -= maxCnt;
		System.out.println(solv);
			
	}
}
