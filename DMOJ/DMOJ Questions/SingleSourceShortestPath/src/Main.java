import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(), M = in.nextInt();
        ArrayList<E>[] adj = new ArrayList[N+1];
        for(int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<E>();
        }
        for(int i = 1; i <= M; i++) {
            int x = in.nextInt(), y = in.nextInt(), z = in.nextInt();
            adj[x].add(new E(y, z)); adj[y].add(new E(x, z));
        }
        int[] dis = new int[N+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        PriorityQueue<E> Q = new PriorityQueue<>();
        Q.add(new E(1, 0)); dis[1] = 0;
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
        for(int i = 1; i <= N; i++)
            if(dis[i] != Integer.MAX_VALUE) System.out.println(dis[i]);
            else System.out.println(-1);
    }

    static class E implements Comparable<E>{
        int v, w;
        E(int v0, int w0) {v = v0; w = w0;}

        public int compareTo(E x) { return Integer.compare(w, x.w); }
    }
}
