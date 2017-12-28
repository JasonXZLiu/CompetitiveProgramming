import javafx.scene.layout.Priority;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by jason_001 on 12/28/2017.
 */
public class Kruskal {
    public static int N;
    public static ArrayList<Edge>[] adj;
    public static boolean[] vis;
    public static boolean cycle;

    public static void dfs(int cur, int u) {
        vis[cur] = true;

        for (Edge e : adj[cur]) {
            if(!vis[e.v]) {
                vis[e.v] = true;
                dfs(e.v,cur);
            } else if (cur != u) {
                cycle = true;
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
        PriorityQueue<E> Q = new PriorityQueue<>();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            Q.add(new E(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        vis = new boolean[N+1];
        adj = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        int edge = 0; long wt = 0;
        while(edge != N -1 && !Q.isEmpty()) {
            E e = Q.poll();
//            System.out.println(e.x + " " + e.y + " " + e.w);
            adj[e.x].add(new Edge(e.y, e.w));
            adj[e.y].add(new Edge(e.x, e.w));
            dfs(e.x, e.x);
            if(!cycle) {
                adj[e.x].remove(new Edge(e.y, e.w));
                adj[e.y].remove(new Edge(e.x, e.w));
            } else {
                wt += e.w;
                edge++;
//                System.out.println(edge);
            }
            cycle = false;
        }
        System.out.println(wt);
    }

    static class Edge {
        public int v, w;

        Edge(int v0, int w0) {v = v0; w = w0;}
    }

    static class E implements Comparable<E> {
        public int x, y, w;

        E(int x0, int y0, int w0) {x = x0; y = y0; w = w0;}

        @Override
        public int compareTo(E o) {
            if(o.w > w) return -1;
            else if(o.w < w) return 1;
            else {
                if(o.x + o.y > x + y) return -1;
                else if(o.x + o.y < x + y) return 1;
                else return 0;
            }
        }
    }
}
