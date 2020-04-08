import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int[] arr;
	public static int stoi(String str) { return Integer.parseInt(str); }
    public static void main(String[] args) throws IOException {
        String[] tmp = br.readLine().split(" ");
        int n = stoi(tmp[0]);
        int d = stoi(tmp[1]);
        int k = stoi(tmp[2]);
        int c = stoi(tmp[3]);
        arr = new int[d + 1];

        int[] list = new int[n];
        for (int i = 0; i < n; ++i) list[i] = stoi(br.readLine());

        arr[c]++;

        int len = 1;
        for (int i = 0; i < k; i++) if (arr[list[i]]++ == 0) len++;
        int maximum = len;

        for (int i = k; i < n + k; i++) {
            if(--arr[list[i - k]] == 0) len--;
            if(arr[list[i % n]]++ == 0) len++;
            maximum = Math.max(maximum, len);
        }

        System.out.println(maximum);
    }
}
