import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String[] pArr = {
                "(()())()", ")(", "()))((()"
        };
        for (String p : pArr) {
            System.out.println("result : " + solution(p));
            System.out.println();
        }
    }

    public static String solution(String p) {
        System.out.printf("input\t:\t%s\n",p);
        if(inspec(p)) return p;
        String answer = logic(p);
        return answer;
    }

    public static String[] separate(String string){
        int open = 0 , close = 0;
        int i = 0;
        for (i = 0; i < string.length(); i++) {
            if(open + close != 0 && open == close) break;
            char c = string.charAt(i);
            if(c == '(')open++;
            else if(c==')')close++;
        }
        String[] result = {
                string.substring(0,i), string.substring(i)
        };
        return result;
    }

    public static boolean inspec(String string){
        Stack<Character> stack = new Stack<>();
        for (Character c :string.toCharArray()){
            if(c == ')'){
                if(stack.isEmpty() || stack.pop() != '(') return false;
            }else stack.add(c);
        }
        return stack.isEmpty();
    }

    public static String logic(String string){
        if("".equals(string)) return "";
        String[] strings = separate(string);
        String u = strings[0];
        String v = strings[1];
        System.out.printf("u\t: %s\t,v\t: %s\n",u,v);
        if(inspec(u)) u += logic(v);
        else {
            StringBuilder tmp = new StringBuilder();
            tmp.append('(');
            tmp.append(logic(v));
            tmp.append(')');
            u = u.substring(1,u.length()-1);
            for (int i = 0; i < u.length(); i++) {
                char c = u.charAt(i);
                if(c == '(') tmp.append(')');
                else if(c == ')') tmp.append('(');
            }
            return tmp.toString();
        }
        return u;
    }
}
