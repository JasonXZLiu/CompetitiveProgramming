import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long[] adj = new long[N+2], dp = new long[N+2];
        for(int i = 1; i <= N; i++) {
            adj[i] = Long.parseLong(br.readLine());
        }
        dp[1] = adj[1]; dp[2] = Math.max(adj[1], adj[2]);
        for(int i = 3; i <= N+1; i++) {
            dp[i] = Math.max(adj[i], dp[i-2] + adj[i-1]);
        }
        if(K > N + 1) System.out.println(-1);
        else if(K <= 2) System.out.println(Math.max(dp[1], dp[2]));
        else System.out.println(dp[K]);
    }
}
