import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = 0; t < 5; t++) {
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            ArrayList<Integer>[] adj = new ArrayList[N+1];
            Queue<E> Q = new LinkedList<>();
            for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
            for(int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken()); int Y = Integer.parseInt(st.nextToken());
                adj[X].add(Y); adj[Y].add(X);
                Q.add(new E(X, Y));
            }
            int ans = 0;
            while(!Q.isEmpty()) {
                E e = Q.poll();
                Integer boop = e.y;
                adj[e.x].remove(boop);
                int count = 1;
                Queue<Integer> q = new LinkedList<>();
                boolean[] vis = new boolean[N+1];
                q.add(e.x); vis[e.x] = true;
                while(!q.isEmpty()) {
                    int cur = q.poll();
                    for(int x: adj[cur]) {
                        if(!vis[x]) {
                            vis[x] = true;
                            count++;
                            q.add(x);
                        }
                    }
                }
                adj[e.x].add(e.y);
                if(count != N) ans++;
            }
            System.out.println(ans);
        }
    }

    static class E {
        public int x, y;
        E(int x0, int y0) {x = x0; y = y0;}
    }
}
