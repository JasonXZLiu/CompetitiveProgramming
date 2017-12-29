import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jason_001 on 12/29/2017.
 */
public class SummationOfPrimes {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        boolean[] primes = new boolean[1000001];
        long[] sum = new long[1000001];
        primes[0] = true; primes[1] = true;
        for(int i = 2; i < 1000001; i++) {
            for(int j = i*2; j < 1000001; j += i) {
                primes[j] = true;
            }
        }
        for(int i = 1; i < 1000001; i++) {
            if(!primes[i]) {
                sum[i] = sum[i-1] + i;
            }
            else sum[i] = sum[i-1];
        }
        for(int t = 0; t < T; t++) {
            System.out.println(sum[Integer.parseInt(br.readLine())]);
        }
    }
}
