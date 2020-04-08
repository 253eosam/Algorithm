import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		ArrayList<Character>[] list = new ArrayList[T];
		for(int i = 0 ; i < T ; i++)
		{
			list[i] = new ArrayList<Character>();
			
			String str = br.readLine();
			char[] chars = str.toCharArray();
			for(int j = 0 ; j < chars.length ; j++)
			{
				list[i].add(chars[j]);
			}
			Collections.sort(list[i]);
		}
		int gapNum = 0 ;
		for(int i = 1; i < T; i++)
		{
			ArrayList<Character> bigList = list[0].size() >= list[i].size() ? (ArrayList<Character>) list[0].clone() : list[i];  
			ArrayList<Character> smallList = list[0].size() < list[i].size() ? (ArrayList<Character>) list[0].clone() : list[i]; 
			int gap = 0;
			for(int j = smallList.size()-1 ; j >= 0 ; j--)
			{
				bigList.remove(smallList.get(j));
			}
			gap = bigList.size();
			if(gap <= 1)
				gapNum++;
		}
		bw.write(Integer.toString(gapNum)+"\n");
		bw.flush();
		bw.close();
		
	}

}
