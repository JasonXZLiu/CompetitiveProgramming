import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by jason_001 on 12/28/2017.
 */
public class BreadthFirstSearch {
    public static int V;
    public static ArrayList<Integer>[] adj;

    public static int bfs(int s, int e) {
        int[] dis = new int[V+1];
        Queue<Integer> Q = new LinkedList<>();
        Arrays.fill(dis, -1);
        dis[s] = 0; Q.add(s);
        while(!Q.isEmpty()) {
            int cur = Q.poll();
            for(int x: adj[cur]) {
                if(dis[x] == -1) {
                    dis[x] = dis[cur] +1;
                    Q.add(x);
                }
            }
            if(dis[e] != -1) return dis[e];
        }
        return dis[e];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken()); int E = Integer.parseInt(st.nextToken());
            adj = new ArrayList[V+1];
            for(int i = 1; i <= V; i++) adj[i] = new ArrayList<>();
            for(int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken()); int Y = Integer.parseInt(st.nextToken());
                adj[X].add(Y); adj[Y].add(X);
            }
            int S = Integer.parseInt(br.readLine());
            for(int i = 1; i <= V; i++) {
                if(i != S) {
                    int dis = bfs(S, i);
                    if (dis != -1) System.out.print((dis * 6) + " ");
                    else System.out.print(-1 + " ");
                }
            }
            System.out.println();
        }
    }

}
