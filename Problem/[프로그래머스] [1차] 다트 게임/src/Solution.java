import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        String[] inputs = {
                "1S2D*3T",
                "1D2S#10S",
                "1D2S0T",
                "1S*2T*3S",
                "1D#2S*3S",
                "1T2D3D#",
                "1D2S3T*"
        };
        for (String input : inputs) {
            System.out.println("최종값 : " + solution(input) + "\n");
        }
    }
    public static int solution(String dartResult) {
        int answer = 0;
        System.out.printf("다트 값 : %s\n",dartResult);
        LinkedList<String> link = new LinkedList<>();
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            if(c == 'S') {
                sb = new StringBuilder(String.valueOf(Integer.parseInt(sb.toString())));
                flag = true;
            }
            else if(c == 'D') {
                sb = new StringBuilder(String.valueOf(Integer.parseInt(sb.toString()) * Integer.parseInt(sb.toString())));
                flag = true;
            }
            else if(c == 'T') {
                sb = new StringBuilder(String.valueOf(Integer.parseInt(sb.toString()) * Integer.parseInt(sb.toString()) * Integer.parseInt(sb.toString())));
                flag = true;
            }
            else if(c == '*') {
                if(!link.isEmpty()){
                    link.pollLast();
                    link.add("*");
                    link.add("2");
                    link.add("+");
                }
                link.add(sb.toString());
                link.add("*");
                link.add("2");
                link.add("+");
                sb = new StringBuilder();
                flag = false;
            }
            else if(c == '#') {
                link.add(sb.toString());
                link.add("*");
                link.add("-1");
                link.add("+");
                sb = new StringBuilder();
                flag = false;
            }else if('0' <= c && c <= '9') {
                if(flag) {
                    link.add(sb.toString());
                    link.add("+");
                    sb = new StringBuilder();
                    flag = false;
                }
                sb.append(c);
            }
        }
        System.out.println("StringBuilder 남은 값 : " + sb);
        if("".equals(sb.toString())) link.pollLast();
        link.add(sb.toString());
        StringBuilder expression = new StringBuilder();
        for (String string : link) {
            expression.append(string+" ");
        }
        System.out.println("StringBuilder 남은 값까지 다 계산한 최종 값 : " + expression.toString());
        answer = calculate(expression.toString());
        return answer;
    }
    public static int stoi(String str){ return Integer.parseInt(str);}
    public static int calculate(String expression){
        System.out.println("계산 식에 들어온 값 : " + expression);
        LinkedList<String> link = new LinkedList<String>();
        String[] splitStrs = expression.split(" ");
        for (int i = 0; i < splitStrs.length; i++) {
            String str = splitStrs[i];
            if("*".equals(str)){
                String newValue = String.valueOf(stoi(link.pollLast()) * stoi(splitStrs[++i]));
                link.add(newValue);
            }else if("/".equals(str)){
                String newValue = String.valueOf(stoi(link.pollLast()) / stoi(splitStrs[++i]));
                link.add(newValue);
            }else link.add(str);
        }// *,/ 1순위 연산들
        System.out.println("*,/ 계산 후 남은 식 : " + link.toString());
        splitStrs = link.toArray(new String[link.size()]);
        link.clear();
        for (int i = 0; i < splitStrs.length; i++) {
            String str = splitStrs[i];
            if("+".equals(str)){
                String newValue = String.valueOf(stoi(link.pollLast()) + stoi(splitStrs[i+1]));
                link.add(newValue);
                i++;
            }else if("-".equals(str)){
                String newValue = String.valueOf(stoi(link.pollLast()) - stoi(splitStrs[i+1]));
                link.add(newValue);
                i++;
            }else link.add(str);
        }// +,- 2순위 연산들
        System.out.printf("+,- 계산 후 최종 값 : %s\n",link.peek());
        return Integer.parseInt(link.poll());
    }
}