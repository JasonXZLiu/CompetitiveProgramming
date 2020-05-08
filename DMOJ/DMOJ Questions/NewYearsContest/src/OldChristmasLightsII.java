import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.*;

/**
 * Created by jason_001 on 1/1/2018.
 */
public class OldChristmasLightsII {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), Q = Integer.parseInt(st.nextToken());
        long[] c = new long[N+1]; ArrayList<Integer>[] adj = new ArrayList[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
            c[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < N -1; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken()); int Y = Integer.parseInt(st.nextToken());
            adj[X].add(Y); adj[Y].add(X);
        }
        for(int t = 0; t < Q; t++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            boolean[] vis = new boolean[N + 1];
            int[] pre = new int[N + 1];
            Queue<Integer> q = new LinkedList<>();
            q.add(S);
            vis[S] = true;
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int e : adj[cur]) {
                    if (!vis[e]) {
                        if (pre[cur] != e) {
                            vis[e] = true;
                            pre[e] = cur;
                            q.add(e);
                        }
                    }
                }
                if (vis[E]) break;
            }
            ArrayList<Integer> arr = new ArrayList<>();
            long MIN = Long.MAX_VALUE;
            arr.add(E);
            while (E != S) {
                E = pre[E];
                for (int y : arr) {
                    if (E != y) MIN = Math.min(Math.abs(c[E] - c[y]), MIN);
                }
                arr.add(E);
            }
            System.out.println(MIN);
        }
    }
}