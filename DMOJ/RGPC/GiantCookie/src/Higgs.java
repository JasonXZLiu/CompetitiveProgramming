import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Higgs {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), T = Integer.parseInt(st.nextToken());
        int[] org = new int[N]; int[] pre = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int A = Integer.parseInt(st.nextToken());
            org[i] = A;
        }
        int[] primes = new int[T + 1];
        primes[0] = -1; primes[1] =  -1;
        for(int i = 2; i <= Math.sqrt(T); i++) {
            int j = i * 2;
            while(j <= T) {
                primes[j] = -1; j += i;
            }
        }
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken())-1;
            int B = Integer.parseInt(st.nextToken())-1;
            int C = Integer.parseInt(st.nextToken());
            if(primes[t] == -1) {
                pre[A] += C;
                if(B + 1 < N) pre[B+1] -= C;
            } else {
                int sum = 0;
                for(int i = 1; i < N; i++) {
                    pre[i] += pre[i-1];
                    org[i] += pre[i];
                    if(i >= A && i <= B) sum += org[i];
                }
                Arrays.fill(pre, 0);
                primes[t] = sum + C;
            }
        }
        int MIN = Integer.MAX_VALUE;
        for(int t = 2; t <= T; t++)
            if(primes[t] != -1) {
                MIN = Math.min(MIN, primes[t] * t);
            }
        System.out.println(MIN);
    }
}
