import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static pair[] ary=null;
	static int xsum=0;
	static int ysum=0;
	
	static double answer=Long.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{

		int T=Integer.parseInt(br.readLine());
		
		for(int test=1;test<=T;test++) {
			problem(test);
		}

	}
	
	private static void problem(int test) throws IOException{
		int N=Integer.parseInt(br.readLine());
		answer=Long.MAX_VALUE;
		ary=new pair[N];
		xsum=0;
		ysum=0;
		for(int i=0;i<N;i++) {
			String in[]=br.readLine().split(" ");
			int x=Integer.parseInt(in[0]);
			int y=Integer.parseInt(in[1]);
			xsum+=x; ysum+=y;
			ary[i]=new pair(x,y);
		}
		
		comb(new int[N/2],N,0,0);
		
		System.out.println("#"+test+" "+(long)answer);
	}
	
	/**
	 * 
	 * @param picked 인덱스만 넣어놓은 내가 조합 뽑은거
	 * @param N
	 * @param start
	 * @param cnt picked의 index
	 */
	
	private static void comb(int[] picked, int N, int start, int cnt) {
		if(cnt==picked.length) {
			int txsum=0; int tysum=0;
			for(int i:picked) {
				txsum+=ary[i].x;
				tysum+=ary[i].y;
			}
			int tx=xsum-(txsum*2);
			int ty=ysum-(tysum*2);
			double at=Math.pow(tx, 2)+Math.pow(ty, 2);
			if(answer>at) {
				answer=at;
			}
			return;
		}
		
		for(int i=start;i<N;i++) {
			picked[cnt]=i;
			comb(picked,N,i+1,cnt+1);
		}
		
	}

	static class pair{
		int x;
		int y;
		
		public pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String toString() {
			return "pair [x=" + x + ", y=" + y + "]";
		}
		
	}
}