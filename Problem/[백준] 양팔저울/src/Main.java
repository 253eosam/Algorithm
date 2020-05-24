import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static int S;
	public static int[] gArr;
	public static int stoi(String str) { return Integer.parseInt(str); }
	public static void main(String[] args) throws IOException {
		S = stoi(br.readLine());
		gArr = new int[S];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int maximum = 0;
		for(int i = 0 ; i < S ; i++) maximum += gArr[i] = stoi(st.nextToken());
		
		ArrayList<String> comList = new ArrayList<>();
		com(new StringBuilder(),0,S,comList);
		boolean[] nums = new boolean[maximum+1];
		for(String str : comList) {	// 선택하는 경우의 수
//			System.out.println(str);
			LinkedList<String> tmpComList = new LinkedList<>();
			int cnt = 0;
			for(char c : str.toCharArray()) if(c == '1') ++cnt;
			com(new StringBuilder(),0,cnt,tmpComList);
//			System.out.println(tmpComList);
//			System.out.println();
			for(String s : tmpComList) {	// 음수 ,양수를 선택하는 경우의 수
				int sum = 0;
				int idx = 0;
				for(int i = 0 ; i < str.length() ; i++) {
					if(str.charAt(i) == '1') {	// 선택된 값의 위치
						sum += s.charAt(idx++) == '1' ? gArr[i] : -gArr[i];	//선택된 값의 음 or 양를 더함
					}
				}
				if(0 <= sum && sum <= maximum) nums[sum] = true;
			}
		}
		int answer = 0;
		for(int i = 0 ; i < maximum ; i++) if(!nums[i]) answer++;
		bw.append(String.valueOf(answer));
		bw.close();
	}
	public static void com(StringBuilder bit, int deep, int target,List<String> resList) throws IOException {
		if(deep == target) {
			resList.add(bit.toString());
			return ;
		}
		
		for(int i = 0 ; i <= 1 ; i++) {
			StringBuilder sb = new StringBuilder(bit);
			sb.append(String.valueOf(i));
			com(sb,deep+1,target,resList);
		}
	}

}
