import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static Data[] data;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		//init
		data = new Data[T];
		//input
		for(int i = 0 ; i < T ; i++)
		{
			st = new StringTokenizer(br.readLine());
			data[i] = new Data(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		//logic
		for(int i = 0 ; i < T ; i++)
		{
			int g = 0;
			for(int j = 0 ; j < T ; j++)
			{
				if(data[i].weight < data[j].weight 
						&& data[i].height < data[j].height)
				{
					g++;
				}
			}
			data[i].grade = g+1;
		}
		
		//print
		for(Data d : data)
			System.out.print(d.grade + " ");
		
	}//main
}

class Data
{
	public int weight;
	public int height;
	public int grade;
	public Data(int w, int h)
	{
		this.weight = w;
		this.height = h;
	}
	@Override
	public String toString() {
		return "Data [weight=" + weight + ", height=" + height + ", grade=" + grade + "]";
	}
}