import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int[] p;

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), cnt = 0;
        ArrayList<Integer> E = new ArrayList<>();
        p = new int[N+1];
        for(int i = 1; i <= N; i++)
            p[i] = i;
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()); int B = Integer.parseInt(st.nextToken());
            int fA = Find(A), fB = Find(B);
            if(fA != fB) {
                Union(fA, fB); cnt++; E.add(i);
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
        if(x != p[x]) p[x] = Find(p[x]);
        return p[x];
    }

    static void Union(int u, int v) {
        p[u] = v;
    }
}
