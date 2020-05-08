import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        ArrayList<E>[] adj = new ArrayList[N+1];
        for(int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<E>();
        }
        for(int i = 1; i <= M; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st1.nextToken()), y = Integer.parseInt(st1.nextToken()), z = Integer.parseInt(st1.nextToken());
            adj[x].add(new E(y, z)); adj[y].add(new E(x, z));
        }
        int[] dis = new int[N+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        PriorityQueue<E> Q = new PriorityQueue<>();
        Q.add(new E(0, 0)); dis[0] = 0;
        while(!Q.isEmpty()) {
            E cur = Q.poll();
            if(cur.w > dis[cur.v]) continue;
            for(E e: adj[cur.v]) {
                if (dis[e.v] > dis[cur.v] + e.w) {
                    dis[e.v] = dis[cur.v] + e.w;
                    Q.add(new E(e.v, dis[e.v]));
                }
            }
        }
        int[] back = new int[N+1];
        Arrays.fill(back, Integer.MAX_VALUE);
        Q = new PriorityQueue<>();
        Q.add(new E(N-1, 0)); back[N-1] = 0;
        while(!Q.isEmpty()) {
            E cur = Q.poll();
            if(cur.w > back[cur.v]) continue;
            for(E e: adj[cur.v]) {
                if (back[e.v] > back[cur.v] + e.w) {
                    back[e.v] = back[cur.v] + e.w;
                    Q.add(new E(e.v, back[e.v]));
                }
            }
        }
        int MAX = Integer.MIN_VALUE;
        for(int i = 1; i < N; i++) {
            MAX = Math.max(MAX, back[i] + dis[i]);
        }
        System.out.println(MAX);
    }

    static class E implements Comparable<E>{
        public int v, w;
        E (int v0, int w0) {this.v = v0; this.w = w0;}

        public int compareTo(E x) { return Integer.compare(w, x.w); }
    }
}
