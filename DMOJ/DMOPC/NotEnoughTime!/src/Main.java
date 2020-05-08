import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), T = Integer.parseInt(st.nextToken());
        int bi = 0;
        long[][] ans = new long[T+1][2];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int k = 0; k < 3; k++) {
                int v = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                for(int j = 1; j <= T; j++) {
                    if(j - v >= 0) {
                        ans[j][bi] = Math.max(ans[j][bi ^ 1], Math.max(ans[j-v][bi ^ 1] + p, ans[j][bi]));
                    }
                    else ans[j][bi] = Math.max(ans[j][bi^1], ans[j][bi]);
                }
            }
            bi = bi ^ 1;
        }
        System.out.println(ans[T][bi^1]);
    }
}
