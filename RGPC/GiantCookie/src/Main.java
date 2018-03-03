import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        if(N % M == 0) System.out.println("yes " + (N / M));
        else {
            long MIN = Long.MAX_VALUE;
            for(int i = M; i < N; i++) {
                if(N % i == 0) {
                    MIN = i - M;
                    break;
                }
            }
            MIN = Math.min(MIN, N - M);
            System.out.println("no " + MIN);
        }

    }
}
