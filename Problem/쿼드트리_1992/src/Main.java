import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static int stoi(String str) { return Integer.parseInt(str); }
	public static int[][] arr;
	public static int[] counting;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//init
		int N = stoi(br.readLine());
		arr = new int[N][N];
		counting = new int[2];
		
		//input
		for(int i = 0 ; i < N ; i++)
		{
			String tmp = br.readLine();
			for(int j = 0 ; j < N ; j++)
				arr[i][j] = tmp.charAt(j) - '0';
		}
		
		String solv = new String(quadTree(N,0,0));
		bw.write(solv);
		bw.flush();
		bw.close();
	}
	public static StringBuilder quadTree(int N, int x, int y)
	{
		StringBuilder output = new StringBuilder();
		
		//checked quadTree
		counting = new int[2];
		for(int i = 0 ; i < N ; i++)
		{
			for(int j = 0 ; j < N ; j++)
			{
				counting[arr[y+i][x+j]]++;
			}
		}
		
		if(counting[0] == Math.pow(N, 2)|| counting[1] == Math.pow(N, 2))
		{
			output.append(counting[0] == Math.pow(N, 2) ? "0" : "1");
		}
		else
		{
			output.append("(");
			//좌상
			output.append(quadTree(N/2,x,y));
			//우상
			output.append(quadTree(N/2,x+N/2,y));
			//좌하
			output.append(quadTree(N/2,x,y+N/2));
			//우하
			output.append(quadTree(N/2,x+N/2,y+N/2));
			output.append(")");
		}
		
		return output;
	}
}
