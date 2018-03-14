import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] ns = new long[N+1];
        for (int i = 1; i <= N; i++)
            ns[i] = Long.parseLong(br.readLine());
        Arrays.sort(ns);
        long[] ps = new long[N+1];
        for (int i = 1; i <= N; i++) {
            ps[i] = ps[i-1] + ns[i];
        }
        if (ns[N] > ps[N-1]) {
            System.out.println(ps[N-1]);
        } else {
            System.out.println(ps[N] / 2);
        }
    }
}
