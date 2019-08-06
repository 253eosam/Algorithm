package ¾ÏÈ£¹®1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = 10;
		for(int tNum = 1; tNum <= T ; tNum++)
		{
			int cryptNum = Integer.parseInt(br.readLine());
			ArrayList<String> list = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < cryptNum ; i++)
				list.add(st.nextToken());
			int commandNum = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < commandNum ; i++)
			{
				String insertCom = st.nextToken();
				int index = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				for(int j = 0 ; j < num ; j++)
				{
					String tmp = st.nextToken();
					list.add(index+j, tmp);
				}
			}
			bw.write("#"+tNum+" ");
			for(int i = 0 ; i < 10 ; i++)
				bw.write(list.get(i)+" ");
			bw.write("\n");
		}//for tNum
		bw.flush();
		bw.close();
	}

}
