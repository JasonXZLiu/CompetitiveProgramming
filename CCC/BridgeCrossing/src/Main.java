import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine()); int N = Integer.parseInt(br.readLine());
        int[] adj = new int[N]; String[] names = new String[N];
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            int x = Integer.parseInt(br.readLine());
            names[i] = s; adj[i] = x;
        }

        int [] dp = new int [N+1];
        int [] start = new int [N+1];
        for(int i = 0 ; i < N+1; i++) {
            dp[i] = 1000000;
            start[i] = -1;
        }
        dp[0] = 0;
        start[0] = 0;
        for(int i = 0 ; i < N+1; i++) {
            int cur = 0;
            for(int j = 1 ; j <= M && i + j - 1 < N; j++) {
                cur = Math.max(cur, adj[i + j - 1]);
                if (dp[i] + cur < dp[i + j]) {
                    dp[i + j] = dp[i] + cur;
                    start[i + j] = j;
                }
            }
        }
        System.out.println("Total Time: " + dp[N]);

        int [] lines = new int [N+1];
        int k = N;
        int x = 0;
        while (start[k] != 0) {
            lines[x++] = start[k];
            k = k - start[k];
        }
        int idx = 0;
        for(int i = x - 1 ; i >= 0 ; i--) {
            for(int j = 0 ; j < lines[i] ; j++) System.out.print(names[idx++] + " ");
            System.out.println();
        }
    }
}
