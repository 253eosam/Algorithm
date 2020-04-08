import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/*
 * 1. 조합을 통해 A팀을 선택
 * 2. 조합으로 선택된 A팀이 모두 연결되어 있는지 확인
 * 3. 나머지 B팀이 모두 연결되어 있는지 확인
 * 4. A팀 , B팀 모두 연결되어 있다면 두 팀의 합의 차의 최솟값을 구한다.
 * 
 * :: 
 * 조합을 써야하는 이유 
 * -> 두 길로 갈라지는 경우의 값을 dfs로 A팀을 선정할 경우 모든 경우를 구할 수 없다.
 */
public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int N;
	public static int[] arr;
	public static ArrayList<Integer>[] list;
	public static int stoi(String str) { return Integer.parseInt(str); }
	public static boolean DEBUG = true;
	public static int[] picked;
	public static boolean[] visited;
	public static int MIN = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception
	{
		
		//init
		N = stoi(br.readLine()) + 1;
		arr = new int[N];
		st = new StringTokenizer(br.readLine()); 
		for(int i = 1 ; i < N ; i++)  	
			arr[i] = stoi(st.nextToken());
		list = new ArrayList[N];
		picked = new int[N];
		visited = new boolean[N];
		for(int i = 1 ; i < N ; i++)
		{
			list[i] = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			int M = stoi(st.nextToken());
			for(int j = 0 ; j < M ; j++)
				list[i].add(stoi(st.nextToken()));
		}
		
		for(int i = 1 ; i < N-1 ; i++) //모두 A팀으로 만들면 어짜피 두팀이 성립안됨
			pickTeamA(i,0,1);
		
		if(MIN == Integer.MAX_VALUE)
			bw.write("-1");
		else
			bw.write(String.valueOf(MIN));
		bw.flush();
		bw.close();
	}
	public static int bfs(ArrayList<Integer> checked, int len)
	{
		Queue<Integer> q = new LinkedList<>();
		int output = -1;
		q.offer(checked.get(0));
		visited[checked.get(0)] = true;
		
		int sum = 0;
		int cnt = 0;
		while(!q.isEmpty())
		{
			int pos = q.poll();
			sum += arr[pos];
			cnt ++;
			for(int i = 0 ; i < list[pos].size() ; i++)
			{
				if(!visited[list[pos].get(i)] && checked.contains(list[pos].get(i)))
				{
					visited[list[pos].get(i)] = true;
					q.offer(list[pos].get(i));
				}
			}
		}
		
		if(cnt == len)
			output = sum;
		
		return output;
	}
	
	public static void pickTeamA(int target, int deep, int cur)
	{
		if(deep == target)
		{
			if(DEBUG)
			{
				for(int i = 0 ; i < deep ; i++)
				{
					System.out.print(picked[i] + " ");
				}
				System.out.println();
			}
			
//			int[] unpick = new int[N];
			ArrayList<Integer> pick = new ArrayList<>();
			ArrayList<Integer> unpick = new ArrayList<>();
			for(int i = 0; i < deep ; i++)
			{
				pick.add(picked[i]);
			}
			for(int i = 1 ; i < N ; i++)
			{
				if(!pick.contains(i))
					unpick.add(i);
			}
			if(DEBUG)
			{
				System.out.println(pick + " " + unpick);
			}
			
			visited = new boolean[N];
			int teamA = bfs(pick,pick.size());
			int teamB = bfs(unpick,unpick.size());
			
			if(teamA > 0 && teamB > 0)
			{
				MIN = Math.min(MIN, Math.abs(teamA - teamB));
			}
			
			return;
		}
		
		for(int i = cur ; i < N ; i++)	
		{
			picked[deep] = i;
			pickTeamA(target,deep+1,i+1);
		}
	}

}
