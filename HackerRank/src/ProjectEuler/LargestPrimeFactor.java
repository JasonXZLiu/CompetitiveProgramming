package ProjectEuler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jason_001 on 12/28/2017.
 */
public class LargestPrimeFactor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            long N = Long.parseLong(br.readLine());
            int i = 2; long MAX = 0;
            while(N > 1 && i <= Math.sqrt(N)) {
                while(N % i == 0) {
                    N /= i; MAX = i;
                }
                if(i == 2) i++;
                else i += 2;
            }
            if(MAX < N) MAX = N;
            System.out.println(MAX);
        }
    }
}
