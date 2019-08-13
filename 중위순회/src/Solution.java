import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static final int MAX_SIZE = 100;
	public static Node[] node = new Node[MAX_SIZE+1];
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = 10;
		for(int tNum = 1; tNum <= T ; tNum++)
		{
			bw.write("#"+tNum+" ");
			int N = Integer.parseInt(br.readLine());
			
			for(int i = 1 ; i <= N ; i++)	// create Node
				node[i] = new Node();
			
			for(int i = 1 ; i <= N ; i++)	// input Node data
			{
				st = new StringTokenizer(br.readLine());
				int index = Integer.parseInt(st.nextToken());
				node[index].data = st.nextToken().charAt(0);
				if(st.hasMoreTokens())
				{
					int leftNodeIndex = Integer.parseInt(st.nextToken());
					node[index].left = node[leftNodeIndex];
				}
				if(st.hasMoreTokens())
				{
					int rightNodeIndex = Integer.parseInt(st.nextToken());
					node[index].right = node[rightNodeIndex];
				}
				
			}
			inOrder(node[1]);
			bw.write("\n");
		}//for tNum
		
		bw.flush();
		bw.close();
	}
	
	public static void inOrder(Node head) throws IOException
	{
		if(head == null) return;
		inOrder(head.left);
		bw.write(String.valueOf(head.data));
		inOrder(head.right);
	}
}
class Node
{
	public char data;
	public Node left, right;
}