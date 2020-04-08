import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution
{
	public static char[] v = { '0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int N,k;
	public static String str;
	public static CircleQueue cq;
	public static long solv;
	public static TreeSet<String> set;
	public static class Node 
	{
		char val;
		Node next;
		public Node(char val) {
			super();
			this.val = val;
		}
		@Override
		public String toString() {
			return "Node [val=" + val + ", next=" + next + "]";
		}
		public Node() {
			super();
		}
	}
	public static class CircleQueue
	{
		int size;
		Node first, cur, last;
		
		public CircleQueue() {
			size = 0;
			first = new Node();
			cur = new Node();
			last = new Node();
		}

		void add(Node n )
		{
			if(size == 0)
			{
				first = cur = last = n;
				first.next = cur.next = last.next = n;
			}
			else
			{
				last.next = n;
				last = n;
				last.next = first;
			}
			size++;
		}
		void print()
		{
			Node tmp = cur;
			while(tmp != first)
			{
				System.out.println(tmp);
				tmp = tmp.next;
			}
			
		}
		String addSet(int cut)
		{
			Node tmp = cur;
			StringBuilder s = new StringBuilder();
			for(int i = 0 ; i < cut ; i++)
			{
				s.append(tmp.val);
				tmp = tmp.next;
			}
			cur = cur.next;
			return s.toString();
		}
	}
    public static void main(String[] args) throws Exception 
    {
    	int T = stoi(br.readLine());
    	for(int tNum = 1 ; tNum <= T ; tNum++)
    	{
    		input();
    		logic();
    		print(tNum);
    	}
    }
    private static void logic() {
    	for(int i = 0 ; i < str.length() ; i++)
    		set.add(cq.addSet(N/4));
    	
    	String tmp = "";
    	for(int i = 0 ; i < k ; i++)
    		tmp = set.pollFirst();
    	
    	
    	for(int i = tmp.length()-1 ; i >= 0 ; i--)
    	{
    		for(int j = 0 ; j < v.length ; j++)
    		{
    			if(tmp.charAt(i) == v[j])
    			{
    				solv += j * (int) Math.pow(16, tmp.length()-1 -i);
    				break;
    			}
    		}
    	}
    	
	}
    private static void print(int tNum) throws IOException {
    	bw.write("#" + tNum + " " + solv + "\n");
    	bw.flush();
	}
	private static int stoi(String readLine) {
    	return Integer.parseInt(readLine);
	}
	private static void input() throws IOException {
		st=new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		k = stoi(st.nextToken());
		str = br.readLine();
		solv = 0;
		cq = new CircleQueue();
		set = new TreeSet<String>(new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}


			});
		for(int i = 0 ; i < str.length() ; i++)
			cq.add(new Node(str.charAt(i)));
		cq.print();
	}
}