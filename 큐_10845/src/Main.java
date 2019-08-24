import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		MyQueue q = new MyQueue();
		int T = sc.nextInt();
		for(int i = 0 ; i < T ; i++)
		{
			String str = sc.next();
			
			switch(str)
			{
			case "push":
				int n = sc.nextInt();
				q.push(createNode(n));
				break;
			case "front":
				Node output = q.front();
				if(output == null)
					bw.write("-1\n");
				else
					bw.write(output+"\n");
				break;
			case "back":
				output = q.back();
				if(output == null)
					bw.write("-1\n");
				else
					bw.write(output+"\n");
				break;
			case "pop":
				output = q.pop();
				if(output == null)
					bw.write("-1\n");
				else
					bw.write(output+"\n");
				break;
			case "size":
				bw.write(q.size()+"\n");
				break;
			case "empty":
				int outputNum = q.isEmpty() == true ? 1 : 0;
				bw.write(outputNum+"\n");
				break;
			case "top":
				bw.write(q.top()+"\n");
				break;
			}
		}
		bw.flush();
		bw.close();
	}
	public static Node createNode(int val)
	{
		return new Node(val);
	}

}
class Node
{
	public int val;
	public Node next;
	public Node() {	}
	public Node(int v)
	{
		this.val = v;
	}
	@Override
	public String toString() {
		return String.valueOf(val);
	}
}
class MyQueue
{
	public Node tail;
	public Node head;
	public int size = 0;
	MyQueue() { }
	
	public void push(Node node)
	{
		if(isEmpty())
			head = tail = node;
		else
		{
			tail.next = node;
			tail = tail.next;
		}
		size++;
	}
	public int size()
	{
		return size;
	}
	public Node top()
	{
		return head;
	}
	public Node pop()
	{
		Node output = null;
		if(!isEmpty())
		{
			output = head;
			head = head.next;
			size--;
		}
		return output;
	}
	public boolean isEmpty()
	{
		return head==null;
	}
	public Node front()
	{
		Node output = null;
		if(isEmpty()) return output;
		return head;
	}
	public Node back()
	{
		Node output = null;
		if(isEmpty()) return output;
		return tail;
	}
}