import java.util.Scanner;

public class Main {
	public static final int MAX_SIZE = 100_001;
	public static int[] parent = new int[MAX_SIZE];
	public static int g,p;
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		g = sc.nextInt();
		p = sc.nextInt();
		int ans = 0;

		makeSet();
		
		for (int i = 1; i <= p; i++) {
			int gi = sc.nextInt();

			int docking = findSet(gi);
			if (docking != 0) {
				unionSet(docking-1 , docking);
				++ans;
			} else {
				break;
			}
		}
		System.out.println(ans);
	}
	public static void makeSet()
	{
		for(int i = 1 ; i <= g ; i++)
		{
			parent[i] = i;
		}
	}
	public static int findSet(int x)
	{
		if(parent[x] == x) return x;
		return parent[x] = findSet(parent[x]);
	}
	public static void unionSet(int a, int b)
	{
		int pa = findSet(a);
		int pb = findSet(b);
		if(pa != pb)
			parent[pb] = pa;
	}
}
