import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
 
public class Solution {
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
 
        for (int z = 1; z <= T; z++) {
            int n = Integer.parseInt(br.readLine());
            int cnt = 1;
            int ans = 0;
            HashSet<Integer> set = new HashSet<Integer>();
            while(set.size()!=10) {
                ans = n*cnt++;
                 
                String strNum = ans+"";
                for(int i=0; i<strNum.length(); i++) {
                    set.add(strNum.charAt(i)-48);
                }
            }
            sb.append("#"+z+" "+ans+"\n");
             
             
        }
        System.out.print(sb);
 
    }
 
}