import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int N;
	public static int[][] arr;
	public static int stoi(String str) { return Integer.parseInt(str); }
	public static void main(String[] args) throws Exception 
	{
		
		N = stoi(br.readLine());
		arr = new int[N][2];
		
		for(int i = 0 ; i < N  ; i++)
		{
			st = new StringTokenizer(br.readLine());
			arr[i][0] = stoi(st.nextToken());
			arr[i][1] = stoi(st.nextToken());
			mapNode.put(i, new Data(arr[i][0],arr[i][1]));
		}
		
		dfs(0,new ArrayList<String>());
		
		
	}
	public static Map<Integer,String> map = new HashMap<>();
	public static Map<Integer,Data> mapNode = new HashMap<>();
	public static void dfs(int index ,ArrayList<String> list)
	{
		if(index == N)
		{
			for(String tmp : list)
				System.out.println(tmp);
			return;
		}
		Data node = mapNode.get(index);
		
		// 더하기
		int a = node.a ;
		int b = node.b ;
		int result = a + b;
		String resultStr = String.valueOf(a) + " + " + String.valueOf(b) + " = " + String.valueOf(result);
		if(!map.containsKey(result))
		{
			map.put(result,resultStr);
			list.add(resultStr);
			dfs(index + 1,list);
			map.remove(result);
		}
		
		//빼기
		a = node.a ;
		b = node.b ;
		result = a - b;
		resultStr = String.valueOf(a) + " - " + String.valueOf(b) + " = " + String.valueOf(result);
		if(!map.containsKey(result))
		{
			map.put(result,resultStr);
			list.add(resultStr);
			dfs(index + 1,list);
			map.remove(result);
		}
		
		//곱하기
		a = node.a ;
		b = node.b ;
		result = a * b;
		resultStr = String.valueOf(a) + " * " + String.valueOf(b) + " = " + String.valueOf(result);
		if(!map.containsKey(result))
		{
			map.put(result,resultStr);
			list.add(resultStr);
			dfs(index + 1,list);
			map.remove(result);
		}
		
	}
	public static class Data
	{
		int a,b;
		Data(int a, int b)
		{
			this.a=a;
			this.b=b;
		}
	}
}
