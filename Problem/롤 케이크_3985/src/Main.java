import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int len = sc.nextInt();
		
		int N = sc.nextInt();
		int outputmax = 0;
		int outputIndex = 0;
		int[] arr = new int[len+1];
		
		for(int k = 1 ; k <= N ; k++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			for(int i = a ; i <= b ; i++)
			{
				if(arr[i] == 0)
					arr[i] = k;
				if(outputmax < b-a+1)
				{
					outputmax = b-a+1;
					outputIndex = k;
				}
			}
		}
//		for(int i =1 ; i <= len ; i++)
//		{
//			System.out.print(arr[i]+" ");
//		}
//		System.out.println();
		int[] counting = new int[len+1];
		int maximum = 0;
		int index = 0;
		for(int i = 1 ; i <= len ; i++)
		{
			if(arr[i] == 0) continue;
			counting[arr[i]]++;
			if(maximum < counting[arr[i]])
			{
				maximum = counting[arr[i]];
				index = arr[i];
			}
		}
		
		System.out.println(outputIndex + "\n" + index);
	}

}
