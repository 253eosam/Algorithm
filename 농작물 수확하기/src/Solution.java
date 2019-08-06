import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Data
{
	int i;
	int j;
	int v;
	Data(int i ,int j, int v)
	{
		this.i = i;
		this.j = j;
		this.v = v;
	}
}

public class Solution {
	
	public static void main(String[] args) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tNum = 1; tNum <= T; tNum++)
		{
			int N = Integer.parseInt(br.readLine());
			
			int arr[][] = new int[N][N];
			for(int i = 0 ; i < N ;i++)
			{
				String str = br.readLine();
				String[] splitStr = str.split("");
				for(int j = 0 ;  j < N ;j++)
				{
					arr[i][j] = Integer.parseInt(splitStr[j]);
				}
			}
			int[] dy = { 0,0,1,-1};
			int[] dx = { 1,-1,0,0};
			int tx = N /2; int ty = N/2;
			LinkedList<Data> list = new LinkedList<>();
			int visit[][] = new int[N][N];
			list.add(new Data(ty,tx,arr[	ty][tx]));
			visit[ty][tx]= 1;
			int sum = 0;
			outer:while(!list.isEmpty())
			{
				Data d = list.pop();
				ty = d.i; tx = d.j; sum += d.v;
				for(int j = 0 ; j < 4; j++)
				{
					int x = tx + dx[j];
					int y = ty + dy[j];
					if(0 > x || x >= N || 0 > y || y >= N)
					{
						break outer;
					}
					else if(visit[y][x] == 0)
					{
						visit[y][x] = 1;
						list.add(new Data(y,x,arr[y][x]));
						
					}
				}
			}
			while(!list.isEmpty())
				sum += list.pop().v;
			
			bw.write("#"+tNum+" "+sum+"\n");
			
			
			
		}//for tNum
		bw.flush();
		bw.close();
	}
}
