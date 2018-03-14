import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 1/1/2018.
 */
public class MimiAndChristmasCake {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] primes = new boolean[100001];
        Arrays.fill(primes, true);
        primes[0] = false; primes[1] = false;
        for(int i = 2; i <= 100000; i++) {
            int cnt = 2;
            if(primes[i]) {
                while(cnt * i <= 100000) {
                    primes[cnt * i] = false;
                    cnt++;
                }
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            int S = Integer.parseInt(st.nextToken());
            if(primes[S]) {
//                System.out.println(S);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
