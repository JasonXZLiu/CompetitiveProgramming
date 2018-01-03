package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 1/3/2018.
 */
public class ComponentsInAGraph {
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
        int N = Integer.parseInt(st.nextToken());
        p = new int[2*N+1]; size = new int[2*N+1];
        for(int i = 1; i <= 2*N; i++) {
            p[i] = i; size[i] = 1;
        }
        for(int t = 0; t < N; t++) {
            st = new StringTokenizer(br.readLine());
            union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int MIN = Integer.MAX_VALUE; int MAX = Integer.MIN_VALUE;
        for(int i = 0; i < 2*N; i++) {
            int tmp = size[find(i)];
            if(tmp > MAX) MAX = tmp;
            else if(tmp < MIN && tmp != 1) MIN = tmp;
        }
        System.out.print(MIN + " " + MAX);
    }
}
