import javafx.scene.layout.Priority;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by jason_001 on 12/28/2017.
 */
public class Prims {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
        long[] dis = new long[N+1]; int[] pre = new int[N+1];
        PriorityQueue<E> q = new PriorityQueue<>();
        Arrays.fill(dis, Integer.MAX_VALUE);
        q.add(new E(S, 0)); dis[S] = 0;
        while(!q.isEmpty()) {
            E cur = q.poll();
            if(cur.w < dis[cur.v]) continue;
            for(E e: adj[cur.v]) {
                if (dis[e.v] > e.w) {
                    if(pre[cur.v] != e.v) {
                        dis[e.v] = e.w;
//                    System.out.println(pre[cur.v] + "-" + e.v);
                        pre[e.v] = cur.v;
                        q.add(new E(e.v, dis[e.v]));
                    }
                }
            }
        }
        long total = 0;
        for(int i = 1; i <= N; i++) {
            total += dis[i];
//            System.out.println(pre[i] + " " + dis[i]);
        }
        System.out.println(total);
    }

    static class E implements Comparable<E> {
        public int v;
        public long w;

        E(int v0, long w0) {v = v0; w = w0;}

        @Override
        public int compareTo(E o) {
            return Long.compare(w, o.w);
        }
    }
}
