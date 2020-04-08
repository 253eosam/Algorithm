import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static class Data implements Comparable<Data>
	{
		public int val;
		public int index;
		@Override
		public int compareTo(Data o) {
			// TODO Auto-generated method stub
			return this.index < o.index ? 1 : 0;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		Stack<Data> stack = new Stack<>();
		Data[] dataList = new Data[T];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < T ; i++)
		{
			dataList[i] = new Data();
			dataList[i].val = Integer.parseInt(st.nextToken());
			dataList[i].index = i+1;
		}
		
		for(int i = T-1 ; i >= 0 ; i--)
		{
			if(stack.isEmpty())
				stack.push(dataList[i]);
			else
			{
				while(!stack.isEmpty() && stack.peek().val < dataList[i].val)
				{
					Data tmpData = stack.pop();
					tmpData.val = dataList[i].index;
					dataList[tmpData.index-1] = tmpData;
				}
				stack.push(dataList[i]);
			}
		}
		while(!stack.isEmpty())
		{
			Data tmpData = stack.pop();
			tmpData.val = 0;
			dataList[tmpData.index-1] = tmpData;
		}

		Arrays.sort(dataList);
		
		for(Data d : dataList)
		{
			bw.write(d.val + " ");
		}
		
		bw.flush();
	}// main
	
}
