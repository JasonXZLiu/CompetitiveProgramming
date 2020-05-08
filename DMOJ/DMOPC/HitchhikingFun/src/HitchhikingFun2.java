import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 12/4/2017.
 */
public class HitchhikingFun2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
        ArrayList<E>[] adj = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); int y = Integer.parseInt(st.nextToken()); int z = Integer.parseInt(st.nextToken());
            adj[x].add(new E(y, z, 1)); adj[y].add(new E(x, z, 1));
        }
        int[] dis = new int[N+1]; int[] bis = new int[N+1];
        PriorityQueue<E> Q = new PriorityQueue<>();
        Arrays.fill(dis, Integer.MAX_VALUE); Q.add(new E(1, 0, 1)); dis[1] = 0; bis[1] = 0;
        while(!Q.isEmpty()) {
            E cur = Q.poll();
            if(cur.w > dis[cur.v]) continue;
            for(E e: adj[cur.v]) {
                if(dis[e.v] > dis[cur.v] + e.w) {
                    dis[e.v] = dis[cur.v] + e.w;
                    bis[e.v] = bis[cur.v] + e.n;
                    Q.add(new E(e.v, dis[e.v], bis[e.v]));
                }
                else if (dis[e.v] == dis[cur.v] + e.w && bis[e.v] > bis[cur.v] + e.n) {
                    bis[e.v] = bis[cur.v] + e.n;
                    Q.add(new E(e.v, dis[e.v], bis[e.v]));
                }
            }
        }
        if(dis[N] != Integer.MAX_VALUE) System.out.println(dis[N] + " " + bis[N]);
        else System.out.println(-1);
    }

    static class E implements Comparable<E> {
        public int v, w, n;

        E(int v0, int w0, int n0) {v = v0; w = w0; n = n0;}

        @Override
        public int compareTo(E o) {
            if(o.w > w) return -1;
            else if(o.v < w) return 1;
            else {
                if(o.n > n) return -1;
                else return 1;
            }
        }
    }
}
