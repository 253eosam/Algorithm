import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static Set<String> set = new TreeSet<>(new Comparator<String>() {
		@Override
		public int compare(String o1, String o2) {
			if(o1.length() == o2.length())
				return o1.compareTo(o2);
			return o1.length() - o2.length();
		}
	});
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		String triple = "666";
		
		backAdd(triple);
		frontAdd(triple);
	}//main
	
	public static void backAdd(String str)
	{
		if(str.length() == 6) return;
		for(int i = 0 ; i <= 9 ; i++)
		{
			String tmp = String.valueOf(i);
			set.add(str+tmp);
			backAdd(str+tmp);
		}
	}
	public static void allAdd(String str)
	{
		
	}
	public static void frontAdd(String str)
	{
		for(int i = 1 ; i <= 999 ; i++)
		{
			set.add(String.valueOf(i) + str);
		}
	}
}
