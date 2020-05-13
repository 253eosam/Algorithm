import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static int M;
	public static int N;
	public static int[] col;
	public static int[] row;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		while (true) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			if (M == 0 && N == 0)
				break;
			row = new int[M + 1];
			for (int i = 1; i <= M; i++) {
				col = new int[N + 1];
				st=new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					col[j] = Integer.parseInt(st.nextToken());
					if (j >= 2) {
						col[j] = Math.max(col[j - 2] + col[j], col[j - 1]);
					}
				}
				row[i] = col[N];
				if (i >= 2) {
					row[i] = Math.max(row[i - 2] + row[i], row[i - 1]);
				}
			}
			bw.append(row[M]+"\n");
		}
		bw.close();
	}
}
