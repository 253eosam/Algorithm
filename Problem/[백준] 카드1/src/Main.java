import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		LinkedList<Integer> linked = new LinkedList<Integer>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i = 1 ; i <= N ; i++) linked.add(i);
		while(true) {
			bw.append(linked.pollFirst()+" ");
			if(linked.isEmpty()) break;
			int tmp = linked.pollFirst();
			linked.add(tmp);
		}
		bw.close();
	}

}
