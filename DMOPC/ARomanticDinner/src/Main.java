import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()), U = Integer.parseInt(st.nextToken()), R = Integer.parseInt(st.nextToken());
        int[][][] ans = new int[M+1][U+1][R+1];
        for(int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            for(int j = 1; j <= M; j++) {
                for(int k = 1; k <= U; k++) {
                    if (j - t >= 0 && k - f >= 0) {
                        ans[j][k][i] = Math.max(ans[j][k][i - 1], ans[j - t][k-f][i - 1] + v);
                    } else ans[j][k][i] = ans[j][k][i-1];
                }
            }
        }
        System.out.println(ans[M][U][R]);
    }
}
