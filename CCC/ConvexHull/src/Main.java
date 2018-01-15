import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        ArrayList<E>[] adj = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken());
            adj[a].add(new E(b, c, d)); adj[b].add(new E(a, c, d));
        }
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken()), E = Integer.parseInt(st.nextToken());
        long[][] dp = new long[N+1][K+1];
        for(int i = 1; i <= N; i++) Arrays.fill(dp[i], 1555555555);
        for(int i = 1; i <= K; i++) dp[S][i] = 0;
        boolean[] vis = new boolean[N+1];
        Queue<Integer> Q = new LinkedList<>();
        Q.add(S);
        while(!Q.isEmpty()) {
            int cur = Q.poll();
            vis[cur] = false;
            for(E x: adj[cur]) {
                for(int i = 1; i <= K-x.d; i++) {
                    if(dp[x.v][i+x.d] > dp[cur][i] + x.c) {
                        dp[x.v][i+x.d] = dp[cur][i] + x.c;
                        if(!vis[x.v]) {
                            Q.add(x.v);
                            vis[x.v] = true;
                        }
                    }
                }
            }
        }
//        for(int i = 1; i <= N; i++) {
//            for(int j = 1; j <= K; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
        if(dp[E][K] == 1555555555) System.out.println(-1);
        else System.out.println(dp[E][K]);
    }

    static class E {
        public int v, c, d;

        E(int v0, int c0, int d0) {v = v0; c = c0; d = d0;}
    }
}
