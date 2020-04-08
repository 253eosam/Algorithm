import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static int[]	in,out;
	public static int open,close;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		//init
		int N = Integer.parseInt(br.readLine());
		in = new int[2]; out = new int[2];
		
		ArrayList<Lib> list = new ArrayList<>();
		//logic
		for(int i = 0 ; i < N ; i++)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.add(new Lib(a,b));
		}
		Collections.sort(list);
		for(int i = 0 ; i < list.size() ; i++)
		{
			if(out[0] < list.get(i).s)
			{
				open = Math.max(open, out[0] - in[0]);
				close = Math.max(close, list.get(i).s - out[0]);
				in[0] = list.get(i).s;
				out[0] = list.get(i).e;
			}
			else
			{
				out[0] = Math.max(out[0], list.get(i).e);
			}
		}
		open = Math.max(open, out[0] - in[0]);
		bw.write(open + " " + close + "\n");
		bw.flush();
		bw.close();
		
	}
	public static class Lib implements Comparable<Lib>
	{
		int s, e;
		Lib(int s, int e)
		{
			this.s = s;
			this.e = e;
		}
		@Override
		public int compareTo(Lib o) {
			if(this.s == o.s ) return this.e - o.e;
			return this.s - o.s;
		}
		@Override
		public String toString() {
			return "Lib [s=" + s + ", e=" + e + "] \n";
		}
		
	}

}
