import java.util.Stack;

public class StackCalculation {

	public static char[] operator = {'(',')','-','+','*','/'};
	public static void main(String[] args) {


//		String str = "9+1*21-1";
		String str = "(9+1)*(21-1)";
		System.out.println("str : " + str);

		String postNum = toPostNum(str);

		System.out.println("postNum : " + postNum);
		
		int val = calculateByPostNum(postNum);
		
		System.out.println("val : " + val);
	}
	
	
//	 후위 표기식을 계산
	public static int calculateByPostNum(String postNum)
	{
		int solve = 0;
		Stack<String> stack = new Stack<>();
		String[] postNumSplit = postNum.split(" ");
		for(int strIndex = 0 ; strIndex < postNumSplit.length ; strIndex++)
		{
			boolean isOperator = false;
			for(int i = 0 ; i < operator.length; i++)
			{
				if(postNumSplit[strIndex].equals(Character.toString(operator[i])))
				{
					isOperator = true;
					break;
				}
			}
			if(!isOperator)
			{
				stack.push(postNumSplit[strIndex]);
			}
			else
			{
				int tmp = 0;
				int b = Integer.parseInt(stack.pop());
				int a = Integer.parseInt(stack.pop());
				switch(postNumSplit[strIndex])
				{
				case "*":
					tmp = a * b;
					break;
				case "/":
					tmp = a / b;
					break;
				case "+":
					tmp = a + b;
					break;
				case "-":
					tmp = a - b;
					break;
				}
				stack.push(Integer.toString(tmp));
			}
		}
		
		solve = Integer.parseInt(stack.pop());
		
		
		return solve;
	}
	
	
//	  중위 표기식을 후위 표기식으로 표현
	public static String toPostNum(String str)
	{
		String postNum = "";
		Stack<String> stack = new Stack<>();
		for(int strIndex = 0 ; strIndex < str.length() ; strIndex++)
		{
			String num = "";
			outer:for(int i = strIndex ; i < str.length(); i++)	//피연산자의 자릿수 검사
			{
				for(int j = 0 ; j < operator.length ; j++)
				{
					if(str.charAt(i) == operator[j])
					{
						break outer;
					}
				}
				num += str.charAt(i);
				strIndex = i;
			}//for i : outer
			
			if(str.charAt(strIndex) == '(')
				stack.push(Character.toString(str.charAt(strIndex)));
			else if(str.charAt(strIndex) == ')')
			{
				String tmp = "";
				while(!stack.isEmpty() && !stack.peek().equals("("))
				{
					tmp += stack.pop() + " ";
				}
				postNum += tmp;
				stack.pop();
			}
			else if(num.equals(""))	
			{
				String tmp = "";
				while(!stack.isEmpty() && priority(stack.peek()) >= priority(Character.toString(str.charAt(strIndex))))
				{
					tmp += stack.pop() + " ";
				}
				stack.push(Character.toString(str.charAt(strIndex)));
				postNum += tmp;
			}
			else // 피연산자 출력문에 입력
			{
				postNum += num + " ";
			}
			if(strIndex == str.length() -1)
			{
				String tmp = "";
				while(!stack.isEmpty())
				{
					tmp += stack.pop() + " ";
				}
				postNum += tmp;
			}
		}//for strIndex
		
		return postNum;
	}
	
	
	// 연산자의 우선순위를 정해주는 함수
	public static int priority(String str)
	{
		int priority = 0;
		switch(str)
		{
		case "*":
		case "/":
			priority = 2;
			break;
		case "+":
		case "-":
			priority = 1;
			break;
		}
		return priority;
	}

}
