import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static final int MAX_SIZE = 100;
	public static boolean[][] visited;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tNum = 1 ; tNum <= T ; tNum++)
		{
			String[] tmp = br.readLine().split(" ");
			int x = Integer.parseInt(tmp[0]);
			int y = Integer.parseInt(tmp[1]);
			visited = new boolean[100][100];
			
			for(int i = y ; i < y + 10 ; i++)
			{
				for(int j  = x ; j < x + 10 ; j++)
				{
					visited[i][j] = true;
				}
			}
		}//for tNum
		
		int sum = 0;
		for(int i = 0 ; i < MAX_SIZE ; i++)
		{
			for(int j = 0 ; j < MAX_SIZE; j++)
			{
				if(visited[i][j])
					sum++;
			}
		}
		
		bw.write(String.valueOf(sum));
		bw.flush();
		bw.close();
	}

}
