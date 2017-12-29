import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 12/29/2017.
 */
public class LargestProductInASeries {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); int K = Integer.parseInt(st.nextToken());
            String S = br.readLine();
            long MAX = Long.MIN_VALUE;
            for(int i = 0; i <= N-K; i++) {
                long ans = 1;
                for(int j = i; j < K+i; j++) {
//                    System.out.print(S.substring(j, j+1));
                    ans *= Integer.parseInt(S.substring(j, j+1));
                }
                MAX = Math.max(MAX, ans);
//                System.out.println();
            }
            System.out.println(MAX);
        }
    }
}
