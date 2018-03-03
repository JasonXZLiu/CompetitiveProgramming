import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * solved after ccc
 */
public class S4 {
    public static HashMap<Integer, Long> dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new HashMap<>();
        dp.put(1,(long) 1); dp.put(2, (long) 1);
        System.out.println(rec(N));
    }

    public static long rec(int N) {
        if(dp.containsKey(N)) return dp.get(N);
        long sum = 0; long x = N;
        while(x >= 2) {
            int w = (int) (N/x), y = N/(w+1);
            sum += (x-y) * rec(w);
            x = y;
        }
        dp.put(N, sum);
        return dp.get(N);
    }
}
