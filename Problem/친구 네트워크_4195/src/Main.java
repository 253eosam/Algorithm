import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static Map<String,String> map;
	public static Map<String,Integer> mapCnt;
	public static int F;
	public static int stoi(String str) { return Integer.parseInt(str); }
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
		
		int T = stoi(br.readLine());
		for(int tNum = 1 ; tNum <= T ; tNum++)
		{
			//init
			map = new HashMap<>();
			mapCnt = new HashMap<>();
			//input
			F = stoi(br.readLine());
			String tmp,A,B;
			String[] split;
			for(int i = 0 ; i < F ; i++)
			{
				tmp = br.readLine();
				split = tmp.split(" ");
				A = split[0]; B = split[1];
				makeSet(A); makeSet(B);
				bw.write(String.valueOf(unionSet(A, B)) + "\n");
			}
			//print
		}
		bw.flush();
		bw.close();
	}
	public static void makeSet(String str)
	{
		if(map.containsKey(str)) return;
		map.put(str, str);
		mapCnt.put(str, 1);
	}
	public static String findSet(String x)
	{
		if(map.get(x).equals(x)) return x;
		map.replace(x, findSet(map.get(x)));
		return map.get(x);
	}
	public static int unionSet(String a, String b)
	{
		String alpha = findSet(a);
		String beta = findSet(b);
		if(!alpha.equals(beta))
		{
			mapCnt.replace(alpha,mapCnt.get(alpha) + mapCnt.get(beta));
			map.replace(beta, alpha);
		}
		return mapCnt.get(alpha);
	}
}
