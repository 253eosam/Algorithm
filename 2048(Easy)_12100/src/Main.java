import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Data
{
	public int[][] arr;
	Data()
	{
		arr = new int[Main.N][Main.N];
	}
}
public class Main {
	public static final boolean DEBUG = true;
	public static int N , target;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// init
		N = Integer.parseInt(br.readLine());
		target = 5;
		
		// input
		Data data = new Data();
		for(int i = 0 ; i < N ; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++)
			{
				data.arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// call dfs
//		int solv = dfs(data,0);
		
		if(DEBUG)
		{
			moving(data,'<');
			for(int i = 0 ; i < N ; i++)
			{
				for(int j = 0 ; j < N ; j++)
				{
					System.out.print(data.arr[i][j] + " ");
				}
				System.out.println();
			}
			
		}
		
		//print
//		bw.write(String.valueOf(1));
//		bw.flush();
//		bw.close();
//		
	}
	
//	public static int dfs(Data data, char direction, int cur, int maximum)
//	{
//		if(cur == target) return maximum;
//		return null;
//	}
	
	public static void moving(Data data, char direction)
	{
		switch(direction)
		{
		case '^':
//			for(int x = 0 ; x < N ; x++)
//			{
//				for(int y = 0 ; y < N ; y++)
//				{
//					int idx = searchLastZeroIndexCol(data.arr, y, -1, x);
//					if(data.arr[idx][x] == 0 || idx == 0 || idx == N-1)
////						swap(data.arr[y][],idx,x);
//					else
//						compareNumber(data.arr[y],idx+1,idx);
//				}
//			}
			break;
		case '>':
			for(int y = 0 ; y < N ; y++)
			{
				for(int x = N-1 ; x >= 0 ; x--)
				{
					int idx = searchLastZeroIndexRow(data.arr, x, 1, y);
					if(data.arr[y][idx] == 0 || idx == 0 || idx == N-1)
						swap(data.arr[y],idx,x);
					else
						compareNumber(data.arr[y],idx+1,idx);
				}
			}
			break;
		case 'v':
			for(int x = 0 ; x < N ; x++)
				for(int y = N-1 ; y >= 0 ; y--)
					searchLastZeroIndexCol(data.arr, y, 1, x);
			break;
		case '<':
			for(int y = 0 ; y < N ; y++)
			{
				for(int x = 0 ; x < N ; x++)
				{
					int idx = searchLastZeroIndexRow(data.arr, x, -1, y);
					if(data.arr[y][idx] == 0 || idx == 0 || idx == N-1)
						swap(data.arr[y],idx,x);
					else
						compareNumber(data.arr[y],idx-1,idx);
				}
			}
			break;
		}
	}
	
	public static int searchLastZeroIndexRow(int[][] arr, int idx , int dir , int pivot)
	{
		while(0 <= idx+dir && idx+dir < arr.length && arr[pivot][idx+dir] == 0)
			idx += dir;
		return idx;
	}
	public static int searchLastZeroIndexCol(int[][] arr, int idx , int dir , int pivot)
	{
		while(0 <= idx+dir && idx+dir < arr.length && arr[idx+dir][pivot] == 0)
			idx += dir;
		return idx;
	}
	public static void compareNumber(int[] arr , int fix , int coming)
	{
		if(arr[fix] == arr[coming])
		{
			arr[fix] += arr[coming];
			arr[coming] = 0;
		}
	}
	public static void swap(int[] arr, int a, int b)
	{
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
