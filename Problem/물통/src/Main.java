import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static int A,B,C;
	public static final int MAX_SIZE = 200;
	public static Queue<Data[]> q = new LinkedList<>();
	public static boolean visit[][][] = new boolean[MAX_SIZE+1][MAX_SIZE+1][MAX_SIZE+1];
	public static Set<Integer> set = new TreeSet<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		bfs();
		
		for(int tmp : set)
			bw.write(String.valueOf(tmp)+" ");
		bw.flush();
		bw.close();
	}
	public static int[] pivots = { 0,1,2 };
	public static void bfs() throws CloneNotSupportedException 
	{
		Data[] data = new Data[3];
		data[0] = new Data(0,0,A);
		data[1] = new Data(1,0,B);
		data[2] = new Data(2,C,C);
		
		q.offer(data.clone());
		
		while(!q.isEmpty())
		{
			data = q.poll();
			
			if(visit[data[0].cur][data[1].cur][data[2].cur])	// 가지치기 (방문)
				continue;
			visit[data[0].cur][data[1].cur][data[2].cur] = true;
			
			if(data[0].cur == 0)	// A가 비어있을때마다 값을 set에 넣어주기
			{
				set.add(data[2].cur);
			}
			
			for(int i = 0 ; i < pivots.length ; i++)//A물통
			{
				for(int j = 0 ; j < pivots.length ; j++)//B물통
				{
					//A물통에서 B믈통으로 물을 부워준다.
					Data[] tmp = new Data[3];
					tmp[0] = (Data) data[0].clone();
					tmp[1] = (Data) data[1].clone();
					tmp[2] = (Data) data[2].clone();
					
					if(i == j)
						continue;
					if(tmp[i].cur == 0)
						continue;
					tmp[j].cur += tmp[i].cur;	// 부어주기
					if(tmp[j].cur > tmp[j].capacity)// 넘칠경우
					{
						tmp[i].cur = tmp[j].cur - tmp[j].capacity;	
						tmp[j].cur = tmp[j].capacity;
					}
					else
					{
						tmp[i].cur = 0;
					}
//					System.out.println("tmp " + i +" "+ j);
//					for(int k = 0 ; k < 3 ; k++ )
//						System.out.println(tmp[k]);
					
					q.offer(tmp.clone());
				}
			}
		}//while !isEmpty
	}//bfs
}
class Data implements Cloneable
{
	public int capacity;
	public int cur;
	public int index;
	Data(int i ,int v, int c)
	{
		this.index = i;
		this.cur = v;
		this.capacity = c;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	@Override
	public String toString() {
		return "Data [capacity=" + capacity + ", cur=" + cur + ", index=" + index + "]";
	}	
}
