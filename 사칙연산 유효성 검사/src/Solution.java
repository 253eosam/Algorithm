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
			bw.write(postOrder(node[1]));
			bw.write("\n");
		}//for tNum
		
		bw.flush();
		bw.close();
	}
	public static String postOrder(Node head) throws IOException
	{
		// �ڽĵ��� �ǿ������̿��� �Ѵ�.
		// ���� �ڽĵ��� �����ڰ� �ִٸ� ����
		// �θ�� �ǿ�����
		boolean isParent = true;
		String pass = "";
		
		//�ڽĳ����� �̵�
		if(head.left == null)
			isParent = false;
		else
			pass += postOrder(head.left);
		if(head.right == null)
			isParent = false;
		else
			pass += postOrder(head.right);

		// �ѹ��̶� ������ ���� ������ 0�� ����
		if(pass.contains("0"))
			pass = "0";
		else
			pass = "1";
		
		//�ڽ� ��忡�� ���������� �ƴ����� üũ
		if(!isParent)
		{
			if(isOperation(head.data))
			{
				return "0";
			}
			else
				return "1";
		}
		return pass;
	}//postOrder
	
	public static boolean isOperation(String val)	
	{
		boolean output = false;
		switch(val)
		{
		case"+":
		case"-":
		case"*":
		case"/":
			output = true;
			break;
		}
		return output;
	}// isOperation
}
class Node
{
	public String data;
	public Node left, right;
}