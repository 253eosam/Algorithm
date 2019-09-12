import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static int M,N;
	public static long L;
	public static Pos[] animal;
	public static ArrayList<Integer> edge;
	public static ArrayList<Data> line;
	public static int cnt;
	public static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//init
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		L = Long.parseLong(st.nextToken());
		edge = new ArrayList<>();
		line = new ArrayList<>();
		animal = new Pos[N];
		visited = new boolean[N];
		
		//input
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < M ; i++)
		{
			edge.add(Integer.parseInt(st.nextToken()));
		}
		for(int i = 0 ; i < N ; i++)
		{
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			animal[i] = new Pos(y,x);
		}
		
		
		//logic
		for(int x : edge)	//방정식 만들기
			makeLine(x);
		
		//동물을 방정식에 넣어보기
		for(int i = 0 ; i < line.size() ; i+=2)	//방정식	
		{
			Data dataA = line.get(i);
			Data dataB = line.get(i+1);
			for(int j = 0 ; j < N ; j++)	//동물
			{
				if(visited[j]) continue;
				if(animal[j].y - dataA.a*animal[j].x - dataA.b < 0 &&
						animal[j].y - dataB.a*animal[j].x - dataB.b < 0)
				{
					visited[j] = true;
					cnt++;
				}
			}
		}
		
		bw.write(String.valueOf(cnt));
		bw.flush();
		bw.close();
		
	}
	public static void makeLine(long x)
	{
		long topX = x;
		long topY = L;
		
		long pivotX = x - L;
		long pivotY = 0;
		
		double a = (pivotY-topY)/(pivotX - topX);
		double b = (pivotY-topY)/(pivotX - topX)*(-topX) + topY;
		line.add(new Data(a,b,L));
		
		pivotX = x + L;
		pivotY = 0;
		
		a = (pivotY-topY)/(pivotX - topX);
		b = (pivotY-topY)/(pivotX - topX)*(-topX) + topY;
		line.add(new Data(a,b,L));
	}
}
class Pos
{
	public int y,x;
	Pos(int y,int x)
	{
		this.y = y;
		this.x = x;
	}
}
class Data
{
	public double a,b;
	public long top;
	Data(double a, double b, long top)
	{
		this.a = a;
		this.b = b;
		this.top = top;
	}
}