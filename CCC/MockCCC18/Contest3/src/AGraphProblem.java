import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 2/5/2018.
 */
public class AGraphProblem {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] adj = new long[N]; long sum = 0; boolean b = true;
        long MAX = Long.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            long I = Long.parseLong(br.readLine());
            adj[i] = I;
            sum += I;
            MAX = Math.max(MAX, I);
        }
        sum -= MAX;
        for(int i = 0; i < N; i++) {
            if(adj[i] > sum) b = false;
        }
        if((sum+MAX) % 2 == 1) b = false;
        if(N == 1) b = false;
        if(N == 2 && adj[0] != adj[1]) b = false;
        System.out.println(b ? "YES": "NO");
    }
}
