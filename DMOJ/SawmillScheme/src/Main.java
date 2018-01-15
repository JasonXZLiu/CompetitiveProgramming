import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] adj = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
            adj[A].add(B);
        }
        double[] dp = new double[N+1];
        dp[1] = 1;
        DecimalFormat df = new DecimalFormat("#.############");
        for(int i = 1; i <= N; i++) {
            if(adj[i].size() == 0) {
                System.out.println(df.format((double) Math.round(dp[i] * 1000000000) / 1000000000));
                continue;
            }
            int size = adj[i].size();
            double ans = dp[i] / size;
            for(int x: adj[i]) {
                dp[x] += ans;
            }
        }
    }
}
