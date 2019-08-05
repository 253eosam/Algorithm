import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static LinkedList<String> queue = new LinkedList<>();
	public static void maketree(String[] arr,int left,int right)
	{
		int mid = (left+right)/2;
		queue.add(arr[mid]);
		if(mid == left)
			return;
		maketree(arr,left,mid-1);
		maketree(arr,mid+1,right);
	}
	public static void main(String[] args) throws Exception{
		
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for(int tNum = 1; tNum <= T ;tNum++)
		{
			int K = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			String[] arr = new String[K*2+1];
			int cnt = 0;
			while(st.hasMoreTokens())
			{
				arr[cnt++] = st.nextToken();
			}
			
			maketree(arr,0,arr.length-1);
			
			while(!queue.isEmpty())
			{
				System.out.println(queue.pop() + " ");
			}
			
			
		}//for tNum
		bw.flush();
		bw.close();
	}

}
