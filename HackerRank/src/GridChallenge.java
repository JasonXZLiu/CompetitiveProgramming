import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 12/29/2017.
 */
public class GridChallenge {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            String[][] adj = new String[N][N];
            for(int i = 0; i < N; i++) {
                String S = br.readLine();
                for(int j = 0; j < N; j++) {
                    adj[i][j] = S.substring(j, j+1);
                }
                Arrays.sort(adj[i]);
            }
            boolean b = true;
            for(int j = 1; j < N; j++) {
                for(int i = 0; i < N; i++) {
                    if(adj[j-1][i].compareTo(adj[j][i]) > 0) {
                        b = false;
                        break;
                    }
                }
                if(!b) break;
            }
            System.out.println((b) ? "YES": "NO");
        }
    }
}
