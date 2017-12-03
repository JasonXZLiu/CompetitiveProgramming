import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 12/2/2017.
 */
public class WhoIsTaller3 {
    public static ArrayList<Integer>[] adj;
    public static int N, M;

    public static boolean bfs(int s, int e) {
        Queue<Integer> Q = new LinkedList<>();
        boolean[] vis = new boolean[N+1];
        vis[s] = true; Q.add(s);
        while(!Q.isEmpty()) {
            int cur = Q.poll();
            for(int x: adj[cur]) {
                if(!vis[x]) {
                    vis[x] = true;
                    Q.add(x);
                }
            }
            if(vis[e]) return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken()); int q = Integer.parseInt(st.nextToken());
            adj[p].add(q);
        }
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken()); int e = Integer.parseInt(st.nextToken());
        if(bfs(s, e)) System.out.println("yes");
        else if (bfs(e, s)) System.out.println("no");
        else System.out.println("unknown");
    }
}
