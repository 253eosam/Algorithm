import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Solution {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws NumberFormatException, IOException {
		int tc = Integer.parseInt(br.readLine());
		HashSet<Character> set = new HashSet<>(); 
		for(int num = 1 ; num <= tc ; num++) {
			String str = br.readLine();
			for(int i = 0 ; i < str.length() ; i++) {
				char c = str.charAt(i);
				if(set.contains(c)) set.remove(c);
				else set.add(c);
			}
			bw.append(String.format("#%d %d\n",num, set.size()));
			set.clear();
		}
		bw.close();
	}
}
