import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 12/29/2017.
 */
public class MinAbsoluteDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] adj = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) adj[i] = Long.parseLong(st.nextToken());
        Arrays.sort(adj);
        long MIN = Long.MAX_VALUE;
        for(int i = 1; i < N; i++) {
            MIN = Math.min(Math.abs(adj[i]-adj[i-1]), MIN);
        }
        System.out.println(MIN);
    }
}
