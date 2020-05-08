import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static Integer[][] lca;
    public static Integer[] depth;

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        ArrayList<E>[] adj = new ArrayList[N];
        for(int i = 0;  i< N; i++) adj[i] = new ArrayList <E>();
        for(Integer i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Integer X = Integer.parseInt(st.nextToken()), Y = Integer.parseInt(st.nextToken()), Z = Integer.parseInt(st.nextToken());
            adj[X].add(new E(Y, Z));
            adj[Y].add(new E(X, Z));
        }
        Stack<E> S = new Stack<>();
        S.add(new E(0, 0));
        Integer[] dis = new Integer[N];
        Arrays.fill(dis, -1);
        depth = new Integer[N];
        dis[0] = 0; depth[0] = 0;
        Integer maxDepth = 0;
        while(!S.isEmpty()) {
            E cur = S.pop();
            for(E x: adj[cur.v]) {
                if(dis[x.v] == -1) {
                    dis[x.v] = dis[cur.v] + x.w;
                    depth[x.v] = cur.w + 1;
                    S.add(new E(x.v, cur.w + 1));
                }
            }
            maxDepth = Math.max(maxDepth, cur.w);
        }
        lca = new Integer[maxDepth+1][N];
        Arrays.fill(lca[0], Integer.MIN_VALUE);
        lca[0][0] = -1;
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        while(!stack.isEmpty()) {
            Integer cur = stack.pop();
            for(E x: adj[cur]) {
                if(lca[0][x.v] == Integer.MIN_VALUE) {
                    lca[0][x.v] = cur;
                    stack.add(x.v);
                }
            }
        }
        for(Integer i = 1; i <= maxDepth; i++) {
            for(Integer j = N-1; j >= 0; j--) {
                if(lca[i-1][j] != -1) lca[i][j] = lca[i-1][lca[i-1][j]];
                else lca[i][j] = -1;
            }
        }
        Integer Q = Integer.parseInt(br.readLine());
        for(Integer q = 0; q < Q; q++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Integer X = Integer.parseInt(st.nextToken()), Y = Integer.parseInt(st.nextToken());
            int temp = LCA(X, Y), sub = 0;
            if(temp != -1) sub = dis[LCA(X, Y)];
            System.out.println(dis[X] + dis[Y] - 2 * sub);
        }
    }

    public static Integer LCA(Integer u, Integer v) {
        if(u.equals(v)) return u;
        else if(depth[u].equals(depth[v])) {
            LCA(lca[depth[u]][u], lca[depth[v]][v]);
        } else if(depth[u] > depth[v]) {
            LCA(lca[depth[u]][u], v);
        } else {
            LCA(u, lca[depth[v]][v]);
        }
        return u;
    }

    static class E {
        public Integer v, w;

        E(Integer v0, Integer w0) {v = v0; w = w0;}
    }
}
