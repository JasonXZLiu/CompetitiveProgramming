import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by jason_001 on 12/23/2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = 0; t < 5; t++) {
            HashMap<String, Integer> map = new HashMap<>();
            int N = Integer.parseInt(br.readLine());
            ArrayList<E>[] adj = new ArrayList[N+1];
            for(int i = 0; i <= N; i++) adj[i] = new ArrayList<>();
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String A = st.nextToken(); int X, Y;
                if(map.containsKey(A)) {
                    X = map.get(A);
                } else {
                    map.put(A, map.size());
                    X = map.get(A);
                }
                String B = st.nextToken();
                if(map.containsKey(B)) {
                    Y = map.get(B);
                } else {
                    map.put(B, map.size());
                    Y = map.get(B);
                }
                adj[X].add(new E(Y, Integer.parseInt(st.nextToken())));
            }
            int X = map.get("YYZ"); int Y = map.get("SEA");
            int[] dis = new int[N+1];
            Arrays.fill(dis, Integer.MAX_VALUE);
            PriorityQueue<E> Q = new PriorityQueue<>();
            Q.add(new E(X, 0)); dis[X] = 0;
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
            System.out.println(dis[Y]);
        }
    }

    static class E implements Comparable<E>{
        public int v, w;
        E(int v0, int w0) {v = v0; w = w0;}

        @Override
        public int compareTo(E o) {
            return 0;
        }
    }
}
