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
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken()); int B = Integer.parseInt(st.nextToken()); int q = Integer.parseInt(st.nextToken());
        ArrayList<E>[] adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); int y = Integer.parseInt(st.nextToken()); int z = Integer.parseInt(st.nextToken());
            adj[x].add(new E(y, z)); adj[y].add(new E(x, z));
        }
        int[] dis = new int[N+1];
        PriorityQueue<E> Q = new PriorityQueue<>();
        Arrays.fill(dis, Integer.MAX_VALUE); Q.add(new E(B, 0)); dis[B] = 0;
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
        for (int i = 0; i < q; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if(dis[tmp] != Integer.MAX_VALUE) {
                System.out.println(dis[tmp]);
            } else {
                System.out.println(-1);
            }
        }
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
