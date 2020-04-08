
public class Main {
	public static int[] p;
	public static int max = 10;
	
	public static void main(String[] args) {
		p = new int[max];
		makeSet();
		unionSet(0,1);
		
	}
	public static int findSet(int x) //부모 찾기
	{
		if(p[x] == x) return x;
		return p[x]=findSet(p[x]);
	}
	public static void unionSet(int x, int y)//부모 합치기
	{
		x = findSet(x);
		y = findSet(y);
		if(x == y)	return ;
		p[y] = x;
	}
	public static void makeSet()	
	{
		for(int i = 0 ; i < p.length; i++)
		{
			p[i] = i;
		}
	}
}
