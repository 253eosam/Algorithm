public class Solution2 {

	public static int MAX_SIZE = 100;

	public static void main(String[] args) {
		
		int[] data = new int[]{7,4,2,0,0,6,0,7,0};
		int col, row;
		col = MAX_SIZE;
		row = data.length;
		int min = 987654321;
		int[] num_cnt = new int[col];
		
		for(int i = 0 ; i < row; i++)
		{
			for(int j = 0 ; j < data[i] ; j++)
			{
				num_cnt[j]++;
				
			}
		}
		
		for(int i = 0 ; i < col ; i++)
			if(min > num_cnt[i] && num_cnt[i] != 0)
			{
				min = num_cnt[i];
			}
		
		int output = row - min;
		System.out.println(output);
			
	}
}
