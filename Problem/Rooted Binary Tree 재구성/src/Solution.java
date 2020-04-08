import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	public static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for(int tNum = 1; tNum <= T ; tNum++)
		{
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int arrLen = (int)Math.pow(2, N)-1;
			int[] arr = new int[arrLen];
			for(int i = 0 ; i < arr.length ; i++)
			{
				arr[i] = Integer.parseInt(st.nextToken());
			}
			ArrayList<Integer>[] list = new ArrayList[N+1];
			for(int i = 0 ; i < N+1 ; i++)
				list[i] = new ArrayList<Integer>();
			
			binaryTree(list,arr,0,arrLen,1);
			
			bw.write("#"+tNum+" ");
			for(int i = 1 ; i < N+1 ; i++)
			{
				for(int j = 0 ; j < list[i].size() ; j++)
				{
					bw.write(Integer.toString(list[i].get(j)) + " ");
				}
				bw.write("\n");
			}
		}//for tNum
		bw.flush();
		bw.close();
	}
	public static void binaryTree(ArrayList<Integer>[] list, int[] arr ,int left, int right, int depth)
	{
		if(depth > N)
			return ;
		int mid = (left+right)/2;
		list[depth].add(arr[mid]);
		binaryTree(list,arr,left,mid,depth+1);
		binaryTree(list,arr,mid,right,depth+1);
	}

}
