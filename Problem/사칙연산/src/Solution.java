import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static final int MAX_SIZE = 1000;
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
				node[index].data = st.nextToken();
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
			bw.write(String.valueOf(postOrder(node[1])));
			bw.write("\n");
		}//for tNum
		
		bw.flush();
		bw.close();
	}
	public static int postOrder(Node head) throws IOException
	{
		int leftVal=0, rightVal=0;
		boolean pass = true;
		
		if(head.left == null)
			pass = false;
		else
			leftVal = postOrder(head.left);
		
		if(head.right == null)
			pass = false;
		else
			rightVal = postOrder(head.right);
		
		if(pass)
		{
			int outputNum = 0;
			switch(head.data)
			{
			case "+":
				outputNum = leftVal + rightVal;
				break;
			case "-":
				outputNum = leftVal - rightVal;
				break;
			case "*":
				outputNum = leftVal * rightVal;
				break;
			case "/":
				outputNum = leftVal / rightVal;
				break;
			}
			return outputNum;
		}
		else
			return Integer.parseInt(head.data);
	}
}
class Node
{
	public String data;
	public Node left, right;
}