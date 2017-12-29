import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 12/29/2017.
 */
public class MarcsCakewalk {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] adj = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) adj[i] = Long.parseLong(st.nextToken());
        Arrays.sort(adj);
        long total = 0;
        for(int i = N-1; i >= 0; i--) {
            total += adj[i] * Math.pow(2, (N-i-1));
        }
        System.out.println(total);
    }
}
