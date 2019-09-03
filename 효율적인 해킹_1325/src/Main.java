import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static ArrayList<Integer> mmap[];
	static boolean[] visited;
	static int N;
	
	public static void main(String[] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		mmap=new ArrayList[N];
		visited=new boolean [N];
		
		for(int i=0;i<N;i++) {
			mmap[i]=new ArrayList<Integer>();
		}
		
		for(int m=0;m<M;m++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken())-1;
			int b=Integer.parseInt(st.nextToken())-1;
			mmap[b].add(a);
		}
		
		int answer[]=new int[N];
		int max=0;
		LinkedList<Integer>q=new LinkedList<Integer>();
		
		for(int i=0;i<N;i++) {
			q.clear();
			visited=new boolean[N];
			answer[i]=bfs(q,i);
			if(max<answer[i]) max=answer[i];
		}
		
		for(int i=0;i<N;i++) {
			if(max==answer[i]) {
				bw.append((i+1)+" ");
			}
		}
		bw.newLine();
		bw.flush();
	}
	
	public static int bfs(LinkedList<Integer> q,int start) { //해킹을 많이 할 수 있는 개수
		int cnt=0;
		
		q.offer(start);
		visited[start]=true;
		
		while(!q.isEmpty()) {
			int cur=q.poll();
			for(int i: mmap[cur]) {
				if(!visited[i]) {
					visited[i]=true;
					q.offer(i);
					cnt++;
				}
			}
		}
		
		return cnt;
	}
	

}