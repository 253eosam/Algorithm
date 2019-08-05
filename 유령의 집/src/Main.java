import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Data{
	int x;
	int y;
	char v;
	Data(int y,int x , char v)
	{
		this.x = x;
		this.y = y;
		this.v = v;
	}
}
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	// 행
		int M = Integer.parseInt(st.nextToken());	// 열
		int K = Integer.parseInt(st.nextToken());	// 유령 , 거울 갯수
		int Q = Integer.parseInt(st.nextToken());	// 시점
		ArrayList<Data> list = new ArrayList<>();
		for(int i = 0; i < K ; i++)
		{
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			char val = st.nextToken().charAt(0);
			
			list.add(new Data(y,x,val));
			
		}//for i
		
		for(int i = 0 ; i < Q ; i++)
		{
			String str = br.readLine();
			int x = 0 , y = 0; int index = str.charAt(0)-'0';
			switch(str.charAt(1))
			{
			case'D':
			case'U':
				x = index;
				break;
			case'L':
			case'R':
				y = index;
				break;
			}
			
			for(Data d : list)
			{
				if(x == 0)
				{
					
				}
				else if(y == 0)
				{
					
				}
			}
		}
		
		
		
		
		bw.flush();
		bw.close();
	}

}
