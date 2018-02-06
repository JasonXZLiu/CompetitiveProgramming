import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 2/5/2018.
 */
public class AMedianProblem {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] adj = new int[N];
        for(int i = 0; i < N; i++) {
            int[] tmp = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                tmp[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(tmp);
            adj[i] = tmp[N / 2];
        }
        Arrays.sort(adj);
        System.out.println(adj[N / 2]);
    }
}
