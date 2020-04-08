import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Solution {
	public static int binaryNum, threeNum;
	public static ArrayList<Integer> resultList;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int tNum = 1 ; tNum <= T ; tNum++)
		{
			//init
			String bList = br.readLine();
			String tList = br.readLine();
			resultList = new ArrayList<>();
			
			for(int i = 0 ; i < bList.length() ; i++)
			{
				
			}
		}
	}
	
}
