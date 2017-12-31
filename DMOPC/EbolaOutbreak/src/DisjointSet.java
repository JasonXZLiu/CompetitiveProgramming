import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 12/30/2017.
 */
public class DisjointSet {
    public static int[] c;

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), cnt = 0;
        ArrayList<Integer> E = new ArrayList<>();
        c = new int[N+1];
        for(int i = 1; i <= N; i++) c[i] = i;
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
            for(int j = 1; j < A; j++) {
                Union(X, Integer.parseInt(st.nextToken()));
                cnt++; E.add(j);
            }
            if(cnt == N - 1) break;
        }
        if(cnt == N-1) {
            for(int u: E) {
                System.out.println(u);
            }
        } else System.out.println("Disconnected Graph");
    }

    static int Find(int x) {
        if(x != c[x]) c[x] = Find(c[x]);
        return c[x];
    }

    static void Union(int u, int v) {
        c[u] = v;
    }
}
