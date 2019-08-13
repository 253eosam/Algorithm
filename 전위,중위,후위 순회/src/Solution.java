import java.util.Scanner;

class Node
{
	public int data;
	public Node left;
	public Node right;
	Node(int data, Node l, Node r)
	{
		this.data = data;
		this.left = l;
		this.right = r;
	}
	Node(){}
	Node(int data){this.data= data;}
}
public class Solution {

	public static void main(String[] args) {
		int inputA[] = { 1, 1, 2, 3, 3, 4, 5, 5 , 6 , 6 , 7, 11};
		int inputB[] = { 2, 3, 4, 5, 6, 7, 8, 9 , 10, 11,12, 13};

		Scanner sc = new Scanner(System.in);
		int V = inputA.length;
		Node[] node = new Node[100];
		for(int i = 1; i < V+1 ; i++)
		{
			node[i] = new Node(i);
		}
		
		for(int i = 0 ; i < V-1 ; i++)
		{
			int a = inputA[i];
			int b = inputB[i];
			if(node[a].left == null)
				node[a].left = node[b];
			else if(node[a].right == null)
				node[a].right = node[b];
		}
		
		/*
			1
			2								3
			4				x				5				6
			7		x		x		x		8		9		10		11
			12	x	x	x	x	x	x	x	x	x	x	x	x	x	13	x
		 */
		
		System.out.println("\tPreorder");
		preorder(node[1]);
		System.out.println();System.out.println();
		
		System.out.println("\tInorder");
		inorder(node[1]);
		System.out.println();System.out.println();	
		
		System.out.println("\tPostorder");
		postorder(node[1]);
	}
	public static void preorder(Node head)
	{
		if(head == null) return;
		System.out.print(head.data + " ");
		preorder(head.left);
		preorder(head.right);
	}
	public static void inorder(Node head)
	{
		if(head == null) return;
		inorder(head.left);
		System.out.print(head.data + " ");
		inorder(head.right);
	}
	public static void postorder(Node head)
	{
		if(head == null) return;
		postorder(head.left);
		postorder(head.right);
		System.out.print(head.data + " ");
	}
}
