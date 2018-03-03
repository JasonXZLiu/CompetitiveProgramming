import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static boolean[] vis;
    public static ArrayList<Integer>[] adj;
    public static int[][] dp; // 300 is 0
    public static int[] left, right, color;

    public static void update(int v) {
        if(adj[v].size() == 0) {
            dp[v][300] = 1;
            dp[v][300+color[v]] = 0;
            left[v] = Math.min(0, color[v]);
            right[v] = Math.max(0, color[v]);
        } else if (adj[v].size() == 1) {
            dp[v][300] = 1;
            int x = adj[v].get(0);
            for(int i = 300+left[x]; i <= 300+right[x]; i++) {
                dp[v][i+color[v]] = Math.min(dp[v][i+color[v]], dp[x][i]);
                left[v] = Math.min(left[v], i+color[v]-300);
                right[v] = Math.max(right[v], i+color[v]-300);
            }
        } else {
            dp[v][300] = 1;
            int x = adj[v].get(0); int y = adj[v].get(1);
            for(int i = left[x]; i <= right[x]; i++) {
                for(int j = left[y]; j <= right[y]; j++) {
                    dp[v][300+i+j+color[v]] = Math.min(dp[v][300+i+j+color[v]], dp[x][i+300]+dp[y][300+j]);
                }
            }
            left[v] = left[x] + left[y];
            right[v] = right[x] + right[y] + 1;
        }
    }

    public static void dfs(int v) {
        vis[v] = true;
        for(int x: adj[v]) {
            if(!vis[x]) {
                dfs(x);
            }
        }
        update(v);
    }

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), D = Integer.parseInt(st.nextToken());
        color = new int[N];
        adj = new ArrayList[N];
        for(int i = 0; i < N; i++) adj[i] = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int I = Integer.parseInt(st.nextToken());
            if(Integer.parseInt(st.nextToken()) == 0) {
                color[I] = -1;
            } else color[I] = 1;
            int C = Integer.parseInt(st.nextToken());
            for(int j = 0; j < C; j++) adj[I].add(Integer.parseInt(br.readLine()));
        }
        dp = new int[N][602]; // 300 is 0
        for(int i = 0; i < N; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        left = new int[N]; right = new int[N]; vis = new boolean[N];
        dfs(0);
        if(dp[0][D+300] != Integer.MAX_VALUE) System.out.println(dp[0][D+300]);
        else System.out.println(-1);
    }
}
