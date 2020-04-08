import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int arr[] = new int[N+1];
		boolean pass = true; int preMax = 0;
		for(int i = 1 ; i <= N ; i++)
		{
			arr[i] = sc.nextInt();
			if(arr[i-1] < arr[i])
			{
				if(preMax < arr[i])
					preMax = arr[i];
				else
					pass = false;
			}
		}
		if(!pass)
		{
			System.out.println("NO");
			return;
		}
		Stack<Integer> s = new Stack<>();
		int cnt = 1; int arrCnt =1;
		while(cnt <= N)
		{
			s.push(cnt++);
			System.out.println("+");
			while(!s.isEmpty() && s.peek() == arr[arrCnt])
			{
				s.pop();
				System.out.println("-");
				arrCnt++;
			}
		}

	}

}
