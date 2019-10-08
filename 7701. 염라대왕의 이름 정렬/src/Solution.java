import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static void main(String[] args) throws Exception{

		int T = Integer.parseInt(br.readLine());
		for(int tNum = 1 ; tNum <= T ; tNum++)
		{
			int N = Integer.parseInt(br.readLine());
			Set<String> set = new TreeSet<>(new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					if(o1.length() == o2.length()) return o1.compareTo(o2);
					return o1.length() - o2.length();
				}
				
			});
			for(int i = 0 ; i < N ; i++)
				set.add(br.readLine());
			
			bw.write("#"+tNum+"\n");
			for(String str : set)
				bw.write(str + "\n");
			
		}
		bw.close();
	}

}
