package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 1/3/2018.
 */
public class MergingCommunities {
    public static int[] p, size;

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), Q = Integer.parseInt(st.nextToken());
        p = new int[N+1]; size = new int[N+1];
        for(int i = 1; i < N+1; i++) {
            p[i] = i; size[i] = 1;
        }
        for(int t = 0; t < Q; t++) {
            st = new StringTokenizer(br.readLine());
            String O = st.nextToken();
            if(O.equals("M")) {
                union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            } else {
                System.out.println(size[find(Integer.parseInt(st.nextToken()))]);
            }
        }
    }
}
