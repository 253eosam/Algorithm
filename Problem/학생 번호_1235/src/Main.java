import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Set<String> set = new HashSet<>();
		ArrayList<String> list = new ArrayList<>();
		ArrayList<String> tmp = new ArrayList<>();
		
		int k = 0;
		for(int i = 0 ; i < N ; i++)
		{
			String s = sc.next();
			k = s.length();
			list.add(s);
		}
		int len = k;
		int M = 0;
		while(N != M)
		{
			set.clear();
			tmp.clear();
			
			for(String s : list)
			{
				tmp.add(s.substring(k-1 , s.length()));
			}
//			System.out.println("tmp : " + tmp);
			k--;
			
			
			for(String s : tmp)
			{
				if(set.contains(s)) continue;
				set.add(s);
			}
//			System.out.println("set : " + set);
//			System.out.println();
			M = set.size();
		}
		
		System.out.println(len-k);
	}
}
