import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 1/7/2018.
 */
public class JourneyToTheMoon {
    public static int[] p, size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); int P = Integer.parseInt(st.nextToken());
        p = new int[N]; size = new int[N];
        for(int i = 0; i < N; i++) {
            size[i] = 1;
            p[i] = i;
        }
        for(int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        boolean[] vis = new boolean[N];
        long res = 0; long sum = 0;
        for(int i = 0; i < N; i++) {
            int x = find(i);
            if(!vis[x]) {
                res += sum * size[x];
                sum += size[x];
                vis[x] = true;
            }
        }
        System.out.println(res);
    }

    static int find(int x) {
        if(x != p[x]) p[x] = find(p[x]);
        return p[x];
    }

    static void union(int u, int v) {
        int rU = find(u); int rV = find(v);
        if(rU == rV) return;
        if(size[rU] > size[rV]) {
            p[rV] = rU;
            size[rU] += size[rV];
        } else {
            p[rU] = rV;
            size[rV] += size[rU];
        }
    }
}
