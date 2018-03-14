import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 3/13/2018.
 */
public class XORBridges {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        boolean[][] adj = new boolean[N+1][N+1];
        long[] boop = new long[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            boop[i] = Long.parseLong(st.nextToken());
            for(int j = 1; j <= i; j++) {
                if((boop[i] ^ boop[j]) <= M) adj[i][j] = true;
            }
        }
        int[] query = new int[2];
        for(int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            query[0] = Integer.parseInt(st.nextToken()); query[1] = Integer.parseInt(st.nextToken());
            Arrays.sort(query);
            if(adj[query[1]][query[0]]) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
