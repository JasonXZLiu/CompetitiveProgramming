import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static long[] dis;
    static ArrayList<E>[] adj;

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N]; dis = new long[N];
        for(int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken()), w = Integer.parseInt(st.nextToken());
            adj[u].add(new E(v, w, 0)); adj[v].add(new E(u, w, 0));
        }
        int Q = Integer.parseInt(br.readLine());
        E[] query = new E[Q];
        long[] ans = new long[Q];
        for(int i = 0; i < Q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
            if(u < v) query[i] = new E(u, v, i);
            else query[i] = new E(v, u, i);
        }
        Arrays.sort(query);
        int pre = -1;
        for(int i =0; i < Q; i++) {
            if(query[i].a != pre) {
                bfs(query[i].a);
            }
            pre = query[i].a;
            ans[query[i].c] = dis[query[i].b];
        }
        for(int i =0; i<Q; i++) {
            System.out.println(ans[i]);
        }
    }

    public static void bfs(int st) {
        boolean[] vis = new boolean[N];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(st); vis[st] = true; dis[st] = 0;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(E t: adj[cur]) {
                if(!vis[t.a]) {
                    vis[t.a] = true; queue.add(t.a); dis[t.a] = t.b + dis[cur];
                }
            }
        }
    }

    static class E implements Comparable<E> {
        int a, b, c;
        E(int a0, int b0, int c0) {a = a0; b = b0; c = c0;}
        public int compareTo(E x) {
            if(a!=x.a) return Integer.compare(a, x.a);
            return Integer.compare(b, x.b);
        }
    }
}
