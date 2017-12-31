import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 12/30/2017.
 */
public class DisjointSet {
    public static int[] c, rank;

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), cnt = 0;
        c = new int[N+1]; rank = new int[N+1];
        for(int i = 1; i <= N; i++) c[i] = i;
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
            for(int j = 1; j < A; j++) {
                int B = Integer.parseInt(st.nextToken());
//                System.out.println(X + " " + B + " " + Find(X) + ":" + Find(B));
                if (Find(X) != Find(B)) Union(X, B);
                cnt++;
            }
            if(cnt == N - 1) break;
        }
        Queue<Integer> Q = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
//            System.out.println(i + "->" + Find(i));
            if(Find(1) == Find(i)) Q.add(i);
        }
        System.out.println(Q.size());
        while(!Q.isEmpty()) System.out.print(Q.poll() + " ");
    }

    static int Find(int x) {
        if(x != c[x]) c[x] = Find(c[x]);
        return c[x];
    }

    static void Union( int x, int y ) {
        c[Find(x)] = Find(y);
    }
}
