import java.util.Scanner;

public class Greedy {
	public static int[] counting;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = 6;
		counting = new int[10];
		
		String tmp = sc.next();
		for(int i = 0 ; i < N ; i++)
		{
			counting[tmp.charAt(i)-'0']++;
		}
		
		System.out.println("counting sort : " + countingSort()); 
		
	}//main
	
	public static boolean countingSort()
	{
		int conditionCnt = 0;
		for(int i = 0 ; i < 10 ; )
		{
			if(counting[i] >= 3)
			{
				counting[i] -= 3;
				conditionCnt++;
				continue;
			}
			if(counting[i] >= 1 && counting[i+1] >= 1 && counting[i+2] >= 1)
			{
				for(int j = i ; j < i+3 ; j++)
					counting[j]--;
				conditionCnt++;
				continue;
			}
			i++;
		}
		return conditionCnt == 2;
	}//countingSort
	
}
