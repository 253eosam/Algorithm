import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		Pos start = new Pos(Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()));
		st = new StringTokenizer(br.readLine());
		Pos target = new Pos(Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()));
		int N = Integer.parseInt(br.readLine())+2;
		Pos[] posArr = new Pos[N];
		posArr[0] = start; posArr[N-1] = target;
		for(int i = 1 ; i < N-1 ; i++) {
			st=new StringTokenizer(br.readLine());
			posArr[i] = new Pos(Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()));
		}
		
		double[] distance = new double[N];
		for(int i = 1 ; i < N ; i++) distance[i] = Integer.MAX_VALUE;
		PriorityQueue<Dis> pq = new PriorityQueue<Main.Dis>();
		pq.add(new Dis(0,0));
		while(!pq.isEmpty()) {
			Dis p = pq.poll();
			
			if(p.b == N-1) break;
			
			for(int i = 0 ; i < N ; i++) {
				if(i == p.b) continue;
				double tmpDis = calDis(p.b,i,posArr);
				double alphaTime = tmpDis / 5;
				double betaTime = (Math.abs(tmpDis-50)/5) +2;
				tmpDis = Math.min(alphaTime, betaTime);
				if(p.b == 0) tmpDis = alphaTime;
				if(distance[i] > distance[p.b] + tmpDis) {
					distance[i] = distance[p.b] + tmpDis;
					pq.add(new Dis(i,distance[i]));
				}
			}
		}
		
		bw.append(String.format("%f\n", distance[N-1]));
		bw.close();
	}
	public static double calDis(int a, int b, Pos[] posArr) {
		return Math.sqrt(Math.pow(posArr[a].y - posArr[b].y,2) + Math.pow(posArr[a].x - posArr[b].x,2)); 
	}
	public static class Dis implements Comparable<Dis>{
		int b;
		double w;
		public Dis(int b, double w) {
			super();
			this.b = b;
			this.w = w;
		}
		@Override
		public int compareTo(Dis o) {
			return this.w - o.w > 0 ? 1 : -1;
		}
	}
	public static class Pos{
		double x,y;
		public Pos(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
