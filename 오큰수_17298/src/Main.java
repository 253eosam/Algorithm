import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		Stack <Integer> s = new Stack<>	();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++)
		{
			int tmp = Integer.parseInt(st.nextToken());
			arr[i] = tmp;
		}
		s.push(arr[N-1]);
		arr[N-1] = -1;
		for(int i = N-2 ; i >= 0 ; i--)
		{
			int val = arr[i];
			while(!s.isEmpty() &&  s.peek() <= val)
				s.pop();
			if(s.isEmpty())
				arr[i] = -1;
			else
				arr[i] = s.peek();
			s.push(val);
		}
	
		for(int tmp : arr)
			System.out.print(tmp + " ");
	
	}

}
