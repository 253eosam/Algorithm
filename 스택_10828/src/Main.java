import java.util.Scanner;
class SStack
{
	int size;
	int rear;
	int[] arr;
	SStack(int size)
	{
		this.size = size;
		rear = 0;
		arr = new int[size];
	}
	void push(int v)
	{
		arr[++rear] = v;
	}
	int pop()
	{
		if(isEmpty()  == 1)
			return -1;
		return arr[rear--];
	}
	int size()
	{
		return rear;
	}
	int isEmpty()
	{
		return rear <= 0 ? 1 : 0;
	}
	int top()
	{
		if(isEmpty()  == 1)
			return -1;
		return arr[rear];
	}
}
public class Main {

	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		SStack s = new SStack(10_001);
		int T = sc.nextInt();
		for(int i = 0 ; i < T ; i++)
		{
			String str = sc.next();
			switch(str)
			{
			case "push":
				int n = sc.nextInt();
				s.push(n);
				break;
			case "pop":
				System.out.println(s.pop());
				break;
			case "size":
				System.out.println(s.size());
				break;
			case "empty":
				System.out.println(s.isEmpty());
				break;
			case "top":
				System.out.println(s.top());
				break;
			}
		}
	}

}
