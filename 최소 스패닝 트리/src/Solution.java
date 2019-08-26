import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {
	public static Node[] nodes;
	public static int[] p;
	public static long result;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//input
		int T = Integer.parseInt(br.readLine());
		for(int tNum = 1 ; tNum <= T ; tNum++)
		{
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			//init
			nodes = new Node[e+1];	//정점의 갯수만큼
			p = new int[e+1];
			result = 0;
			for(int i = 0 ; i < nodes.length ; i++)
			{
				makeSet(i);
			}
			
			//input
			for(int i = 0 ; i < e ; i++)
			{
				st = new StringTokenizer(br.readLine());
				int to = Integer.parseInt(st.nextToken());
				int from = Integer.parseInt(st.nextToken());
				int val = Integer.parseInt(st.nextToken());
				nodes[i] = new Node(to,from,val);
			}
			
			Arrays.sort(nodes,0,e);
			
			for(int i = 0 ; i < e ; i++)
				unionSet(nodes[i]);
			
			bw.write("#"+tNum+" " +result+"\n");
			
			
			// treeSet 
//		Set<Node> set = new TreeSet<>();
		}//tNum
		bw.flush();
		bw.close();
	}
	public static void unionSet(Node node)
	{
		int px = findSet(node.A);
		int py = findSet(node.B);
		
		if(px != py)
		{
			p[py] = px;
			result += node.C;
		}
	}
	public static int findSet(int x)
	{
		if(p[x] == x) return x;
		return p[x] = findSet(p[x]);
	}
	public static void makeSet(int x)
	{
		p[x] = x;
	}

}
class Node implements Comparable<Node>
{
	public int A; 	// from
	public int B;	// to
	public int C;	// 가중치
	Node(int a, int b , int c)
	{
		this.A = a;
		this.B = b;
		this.C = c;
	}
	@Override
	public int compareTo(Node o) {
		return this.C - o.C;
	}
}