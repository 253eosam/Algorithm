import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Data
{
	public int num;
	public String calStr;
	public Data(int n , String s)
	{
		this.num = n;
		this.calStr = s;
	}
}

public class Main {
	public static final int MAnum_SIZE = 100000;
	public static boolean visit[] ;
	public static int post;
	public static LinkedList<Data> queue;
	public static String solv;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < T ; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int pre = Integer.parseInt(st.nextToken());
			post = Integer.parseInt(st.nextToken());
			visit = new boolean[MAnum_SIZE+1]; 
			Data dataPre  = new Data(pre,"");
			queue = new LinkedList<>();
			queue.push(dataPre);
			bfs();
			bw.write(solv+"\n");
		}
		bw.flush();
		bw.close();
	}
	

	
	public static void bfs()
	{
		while(!queue.isEmpty())
		{
			Data dTmp = queue.removeLast();
			int num = dTmp.num;
			String str = dTmp.calStr;
			visit[num] = true;
			if(post == num)
			{
				solv = str;
				break;
			}
			int tmpVal;
			
			
			//D 2n mod 10000
			tmpVal = (2*num) % 10000;
			if(!visit[tmpVal])
			{
				visit[tmpVal] = true;
				queue.push(new Data(tmpVal,str+"D"));
			}
			
			//S n-1 != 0 -> 9999
			tmpVal = (num + 9999) % 10000;
			if(!visit[tmpVal])
			{
				visit[tmpVal] = true;
				queue.push(new Data(tmpVal,str+"S"));
			}
			
			//L <-
			tmpVal = (num * 10) % 10000 + (num/1000);
			if(!visit[tmpVal])
			{
				visit[tmpVal] = true;
				queue.push(new Data(tmpVal,str+"L"));
			}
			
			
			//R  ->
			tmpVal =  num / 10 + (num % 10) * 1000 ;
			if(!visit[tmpVal])
			{
				visit[tmpVal] = true;
				queue.push(new Data(tmpVal,str+"R"));
			}
		
		}
	}
}
