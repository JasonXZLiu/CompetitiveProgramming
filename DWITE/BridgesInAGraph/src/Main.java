import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 12/24/2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = 0; t < 5; t++) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<Integer>[] adj = new ArrayList[N+1];
            for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
            int M = Integer.parseInt(br.readLine());
            for(int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken()); int B = Integer.parseInt(st.nextToken());
                adj[A].add(B); adj[B].add(A);
            }
            Queue<E> Q = new LinkedList<>();
            int count = 0;
            for(int i = 1; i <= N; i++) {
                if (adj[i].size() == 1) {
                    E e;
                    if(i < adj[i].get(0)) e = new E(i, adj[i].get(0));
                    else e = new E(adj[i].get(0), i);
                    if(!Q.contains(e)) {
                        Q.add(e);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    static class E {
        public int x, y;
        E(int x0, int y0) {x = x0; y = y0;}
    }
}
