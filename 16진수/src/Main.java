import java.util.HashMap;
import java.util.Map;

public class Main {
	public static Map<String,String> m = new HashMap<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[] arr = new char[] {'0','F','9','7','A','3'};
		
		bitHexToBinary();
		
		String str= "";
		for(char tmp : arr)	//hashMap으로 16진수를 2진수로 바꾸고 빈공간을 0으로 채운다
		{
			str += new String(String.format("%04d",Integer.parseInt(m.get(String.valueOf(tmp)))));
		}
		System.out.println();
		System.out.println("str : " + str);
		
		// 7bit으로 쪼개면서 2진수를 10진수로 바꾸는 과정 
		for(int i = 0 ; i + 7 < str.length() ; i+=7)
		{
			String tmp = str.substring(i,i+7);
			int num = 0;
			num = binaryBitToNum(tmp);
			System.out.println(tmp + " -> " + num);
			if(i+7+7 > str.length())
			{
				tmp = str.substring(i+7,str.length());
				num = binaryBitToNum(tmp);
				System.out.println(tmp + " -> " + num);
			}
		}
		
	}
	public static int binaryBitToNum(String str)
	{
		int num = 0;
		for(int j = 0 ; j < str.length() ; j++)
		{
			if(str.charAt(str.length()-j-1) == '1')
				num += Math.pow(2, j);
		}
		return num;
	}
	public static void bitHexToBinary()
	{
		for(int i = 0 ; i < 16 ; i++)
			m.put(Integer.toHexString(i).toUpperCase(), Integer.toBinaryString(i));
	}
}
