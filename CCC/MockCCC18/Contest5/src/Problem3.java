import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 2/12/2018.
 */
public class Problem3 {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        boolean[][] adj = new boolean[N+1][N+1];
        E[] flight = new E[M+1];
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken()), Y = Integer.parseInt(st.nextToken());
            adj[X][Y] = true;
            flight[i] = new E(X, Y);
        }
        for(int i = 1; i <= M; i++) {
            adj[flight[i].X][flight[i].Y] = false;
            Queue<Integer> Q = new LinkedList<>();
            boolean[] vis = new boolean[N+1];
            boolean b = false;
            Q.add(1); vis[1] = true;
            while(!Q.isEmpty()) {
                int cur = Q.poll();
                for(int j = 1; j <= N; j++) {
                    if(adj[cur][j]) {
                        if(!vis[j]) {
                            vis[j] = true;
                            Q.add(j);
                        }
                    }
                }
                if(vis[N]) b = true;
            }
            adj[flight[i].X][flight[i].Y] = true;
            if(b) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    static class E {
        public int X, Y;

        E (int x0, int y0) {X = x0; Y = y0;}
    }
}
