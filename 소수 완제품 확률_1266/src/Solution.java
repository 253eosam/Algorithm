
public class Solution {
	public static int[] prime = new int[100];
	public static void main(String[] args) {

		for(int i = 2 ; i < 100 ; i ++)
		{
			if(prime[i] != 0) continue;
			for(int j = i+i ; j < 100 ; j+=i)
				prime[j] = 1;
		}
		
		for(int i = 2 ; i < 100 ; i ++)
			if(prime[i] == 0)
				System.out.print(i+" ");
		
	}

}
