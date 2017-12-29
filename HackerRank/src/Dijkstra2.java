import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 12/28/2017.
 */
public class Dijkstra2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
            ArrayList<E>[] adj = new ArrayList[N+1];
            for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken()); int Y = Integer.parseInt(st.nextToken()); int Z = Integer.parseInt(st.nextToken());
                adj[X].add(new E(Y, Z)); adj[Y].add(new E(X, Z));
            }
            int S = Integer.parseInt(br.readLine());
            long[] dis = new long[N+1];
            Arrays.fill(dis, Integer.MAX_VALUE);
            PriorityQueue<E> Q = new PriorityQueue<>();
            Q.add(new E(S, 0)); dis[S] = 0;
            while(!Q.isEmpty()) {
                E cur = Q.poll();
                if(cur.w > dis[cur.v]) continue;
                for(E e: adj[cur.v]) {
                    if(dis[e.v] > dis[cur.v] + e.w) {
                        dis[e.v] = dis[cur.v] + e.w;
                        Q.add(new E(e.v, dis[e.v]));
                    }
                }
            }
            for(int i = 1; i <= N; i++) {
                if(i != S) System.out.print(((dis[i] == Integer.MAX_VALUE) ? -1 : dis[i]) + " ");
            }
            System.out.println();
        }
    }

    static class E implements Comparable<E> {
        public int v;
        public long w;

        E(int v0, long w0) {v = v0; w = w0;}

        @Override
        public int compareTo(E o) {
            return 0;
        }
    }
}
