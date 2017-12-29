package ProjectEuler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * Created by jason_001 on 12/28/2017.
 */
public class EvenFibonacciNumbers {
    public static long[][] ans;

    public static void fibonacci() {
        int i = 0;
        long stop = (long) (4 * Math.pow(10, 16));
        long tot = 2, n3 = 0, n2 = 2, n1 = 0;
        while(n3 <= stop) {
            n3 = 4*n2 + n1;
            n1 = n2; n2 = n3;
            tot += n3;
            ans[i][0] = n3;
            ans[i][1] = tot;
            i++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ans = new long[30][2];
        fibonacci();
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            long N = Long.parseLong(br.readLine());
            for(int i = 0; i < 30; i++) {
                if(ans[i][0] > N) {
                    System.out.println(ans[i-1][1]);
                    break;
                }
            }
        }
    }

}
