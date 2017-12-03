import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken()); int R = Integer.parseInt(st.nextToken()); int D = Integer.parseInt(st.nextToken());
        ArrayList<E>[] adj = new ArrayList[C+1];
        for (int i = 1; i <= C; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); int y = Integer.parseInt(st.nextToken()); int z = Integer.parseInt(st.nextToken());
            adj[x].add(new E(y, z)); adj[y].add(new E(x, z));
        }
        int[] dis = new int[C+1];
        PriorityQueue<E> Q = new PriorityQueue<>();
        Arrays.fill(dis, Integer.MIN_VALUE); Q.add(new E(1, 0)); dis[1] = 0;
        while(!Q.isEmpty()) {
            E cur = Q.poll();
            if(cur.w > dis[cur.v]) continue;
            for(E e: adj[cur.v]) {
                if (dis[e.v] < e.w) {
                    dis[e.v] = e.w;
                    Q.add(new E(e.v, dis[e.v]));
                }
            }
        }
        int MIN = Integer.MAX_VALUE;
        for (int i = 0; i < D; i++) {
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
