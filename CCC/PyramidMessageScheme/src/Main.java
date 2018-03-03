import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            String[] str = new String[1001];
            String[] hold = new String[1001];
            for(int i = 0; i < N; i++) hold[i] = br.readLine();
            str[0] = hold[N-1];
            int P = 0; int MAX = Integer.MIN_VALUE;
            for(int i = 0; i < N; i++) {
                int lookup = 0;
                while(lookup <= P && !hold[i].equals(str[lookup])) lookup++;
                str[lookup] = hold[i];
                P = lookup;
                MAX = Math.max(MAX, P);
            }
            System.out.println(N * 10 - (2 * MAX * 10));
        }
    }
}
