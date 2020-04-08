import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	public static final int MAX_SIZE = 9;
	public static final int HEIGHT = 100;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// ������ Ű�� �ٸ��Ƿ� set.size()�� ������ 9���� �����.
		Set<Integer> set = new TreeSet<>();	//������ ���� set -> hashset ���ľȵ�..
		int sum = 0;	//������ Ű�� ��� ��ģ ��
		for(int i = 0 ; i < MAX_SIZE; i++)
		{
			int tmp = Integer.parseInt(br.readLine());
			set.add(tmp);
			sum += tmp;
		}
		
		int twoSumHeight = sum - HEIGHT;
		int one, two;
		for(int h : set)
		{
			one = twoSumHeight - h;
			if(set.contains(one))
			{
				two = h;
				set.remove(one);
				set.remove(two);
				break;
			}
		}
		
		for(int h : set)
			bw.write(h+"\n");
		
//		System.out.println();
		bw.flush();
		bw.close();
		
		
	}

}
