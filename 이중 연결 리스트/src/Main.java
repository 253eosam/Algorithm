import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Data
{
	int index, val;
	Data(int index, int val)
	{
		this.index = index;
		this.val = val;
	}
}
public class Main {
	public static int N , M ;
	public static final boolean DEBUG = true;
	public static Queue<Data> queue = new LinkedList<>();
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i = 1 ; i <= N ; i++)
			arr.add(i);
		
		for(int tNum = 1 ; tNum <= M ; tNum++)
		{
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			int val = Integer.parseInt(st.nextToken());
			int pivot = Integer.parseInt(st.nextToken());
			
			int valIndex = arr.indexOf(val);
			int pivotIndex = arr.indexOf(pivot);
			if(command.equals("A"))
			{
				arr.remove(valIndex);
				pivotIndex = pivotIndex-1 < 0 ? 0 : pivotIndex-1;
				arr.add(pivotIndex,val);
			}
			else if(command.equals("B"))
			{
				arr.remove(valIndex);
				if(pivotIndex < N)
					arr.add(pivotIndex,val);
				else
					arr.add(val);
			}
		}

		
		int caseNum = 0;
		for(int i = 0 ; i < arr.size(); i++)
		{
			if(arr.get(i) == i+1)
				continue;
			else
			{
				int nodeIndex = arr.indexOf(i+1);
				arr.remove(nodeIndex);
				if(nodeIndex-1 < 0)
				{
					arr.add(i+1);
				}
				else(nodeIndex-1 >= 0)
				{
					arr.add(nodeIndex-1 , i+1);
				}
				caseNum++;
			}
		}
		
		
		if(DEBUG)
		{
			System.out.println(arr);
			System.out.println(caseNum);
			
		}
	}
	
	public static void bfs()
	{
		
	}
}
