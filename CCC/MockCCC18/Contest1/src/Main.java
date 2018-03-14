import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken()), T = Integer.parseInt(st.nextToken());
        E[] edge = new E[M+1]; long[] x = new long[M], y = new long[M];
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
            long C = Long.parseLong(st.nextToken()), D = Long.parseLong(st.nextToken());
            edge[i] = new E(A, B, C, D);
            x[i-1] = C; y[i-1] = D;
        }
        Arrays.sort(x); Arrays.sort(y);
        int boop = 1; int xcnt = 0, ycnt = 0;
        int Tdis = 0; boolean change = false;
        while(boop <= K) {
            if(boop == x[xcnt]) {
                change = true;
                xcnt++;
                if(xcnt == M) xcnt = M-1;
            }
            if(boop == y[ycnt]) {
                change = true;
                ycnt++;
                if(ycnt == M) ycnt = M-1;
            }
            if(change) {
                ArrayList<Integer>[] adj = new ArrayList[N+1];
                for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
                for(int i = 1; i <= M; i++) {
                    if(edge[i].c <= boop && edge[i].d >= boop) {
                        adj[edge[i].x].add(edge[i].y);
                    }
                }
                boolean[] dis = new boolean[N+1];
                Queue<Integer> Q = new LinkedList<>();
                dis[S] = true; Q.add(S);
                while(!Q.isEmpty()) {
                    int cur = Q.poll();
                    for(int j: adj[cur]) {
                        if(!dis[j]) {
                            dis[j] = true;
                            Q.add(j);
                        }
                    }
                }
                if(dis[T]) Tdis++;
            }
            boop++;
        }
        System.out.println(Tdis);
    }

    static class E {
        public int x, y;
        public long c, d;

        E(int x0, int y0, long c0, long d0) {x = x0; y = y0; c = c0; d = d0;}
    }
}
