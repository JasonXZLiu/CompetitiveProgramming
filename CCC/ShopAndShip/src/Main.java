import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); int T = Integer.parseInt(br.readLine());
        ArrayList<E>[] adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); int y = Integer.parseInt(st.nextToken()); int z = Integer.parseInt(st.nextToken());
            adj[x].add(new E(y, z)); adj[y].add(new E(x, z));
        }
        int P = Integer.parseInt(br.readLine());
        int city[] = new int[P+1];
        int price[] = new int[P+1];
        for (int i = 0; i < P; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            city[i] = Integer.parseInt(st.nextToken()); price[i] = Integer.parseInt(st.nextToken());
        }
        int D = Integer.parseInt(br.readLine());
        int[] dis = new int[N+1];
        PriorityQueue<E> Q = new PriorityQueue<>();
        Arrays.fill(dis, Integer.MAX_VALUE); dis[D] = 0;
        Q.add(new E(D, 0));
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
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < P; i++) {
            if(dis[city[i]] != Integer.MAX_VALUE)
                ans = Math.min(ans, price[i] + dis[city[i]]);
        }
        System.out.println(ans);
    }

    static class E implements Comparable<E> {
        int v, w;

        public E(int v0, int w0) {
            v = v0; w = w0;
        }

        public int compareTo(E x) {
            return Integer.compare(x.w, w);
        }
    }
}
