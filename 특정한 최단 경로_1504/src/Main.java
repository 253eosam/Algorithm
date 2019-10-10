import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static ArrayList<Integer>[] arr;
	public static PriorityQueue<Edge> pq;
	public static int V,E;
	public static class Edge implements Comparable<Edge>
	{
		int idx, cost;
		Edge(int idx, int cost)
		{
			this.idx=idx;
			this.cost=cost;
		}
		@Override
		public int compareTo(Edge o) {
			return this.cost-o.cost;
		}
		
	}
	public static void main(String[] args) {

		
	}

}
