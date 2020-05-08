import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[] dp = new int[M+1];
        Arrays.fill(dp, 0);
        for(int i = 1; i <= C; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            for(int m = M; m > 0; m--) {
                if (m - x >= 0) {
                    dp[m] = Math.max(dp[m - x] + y, dp[m]);
                }
            }
        }
        System.out.println(dp[M]);
    }
}
