import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 12/5/2017.
 */
public class TruckingTroubles1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken()); int Q = Integer.parseInt(st.nextToken());
        ArrayList<E>[] adj = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); int y = Integer.parseInt(st.nextToken()); int z= Integer.parseInt(st.nextToken());
            adj[x].add(new E(y, z)); adj[y].add(new E(x, z));
        }
        int[] dis = new int[N+1];
        PriorityQueue<E> q = new PriorityQueue<>();
        q.add(new E(1, 0)); dis[1] = 0;
        while(!q.isEmpty()) {
            E cur = q.poll();
            if(cur.w > dis[cur.v]) continue;
            for(E e: adj[cur.v]) {
                if (dis[e.v] < e.w) {
                    dis[e.v] = e.w;
                    q.add(new E(e.v, dis[e.v]));
                }
            }
        }
        int MIN = Integer.MAX_VALUE;
        for (int i = 0; i < Q; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if(dis[tmp] != Integer.MIN_VALUE) {
                MIN = Math.min(dis[tmp], MIN);
            }
        }
        System.out.println(MIN);
    }

    static class E implements Comparable<E> {
        public int v, w;

        E(int v0, int w0) {v = v0; w = w0;}

        @Override
        public int compareTo(E o) {
            return 0;
        }
    }
}

