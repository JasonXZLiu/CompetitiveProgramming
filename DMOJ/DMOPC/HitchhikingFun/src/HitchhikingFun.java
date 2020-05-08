import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class HitchhikingFun {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        ArrayList<E>[] adj = new ArrayList[N+1];
        for(int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<E>();
        }
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken()), z = Integer.parseInt(st.nextToken());
            adj[x].add(new E(y, z, 1)); adj[y].add(new E(x, z, 1));
        }
        int[] dis = new int[N+1];
        int[] blah = new int[N+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        PriorityQueue<E> Q = new PriorityQueue<>();
        Q.add(new E(1, 0, 0)); dis[1] = 0; blah[1] = 0;
        while(!Q.isEmpty()) {
            E cur = Q.poll();
            if(cur.w > dis[cur.v]) continue;
            for(E e: adj[cur.v]) {
                if (dis[e.v] > dis[cur.v] + e.w) {
                    dis[e.v] = dis[cur.v] + e.w;
                    blah[e.v] = blah[cur.v] + e.n;
                    Q.add(new E(e.v, dis[e.v], blah[e.v]));
                }
                else if(dis[e.v] == dis[cur.v] + e.w && blah[e.v] > blah[cur.v] + e.n){
                    blah[e.v] = blah[cur.v] + e.n;
                    Q.add(new E(e.v, dis[e.v], blah[e.v]));
                }
            }
        }
        if(dis[N] == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(dis[N] + " " + blah[N]);
    }

    static class E implements Comparable<E>{
        int v, w, n;
        E(int v0, int w0, int n0) {v = v0; w = w0; n = n0;}

        public int compareTo(E x) {
            if(x.w > w) return -1;
            else if (x.w < w) return 1;
            else {
                if(x.n > n) return -1;
                else return 1;
            }
        }
    }
}