import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 3/30/2018.
 */
public class CountlessCalculatorComputations {
    public static long Y, Z;

    public static void checkNum(double mid, double low, double high) {
        Double temp = mid;
        for(int i = 1; i < Y; i++) temp = Math.pow(mid, temp);
        double ans = Math.round((Z - temp) * 100000)/ 100000;
        if(temp.isInfinite() || ans < 0) checkNum((low + (mid - low) / 2), low, mid);
        else if(ans > 0) checkNum((high - (high - mid) / 2), mid, high);
        else System.out.println(mid);
    }

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Y = Long.parseLong(st.nextToken()); Z = Long.parseLong(st.nextToken());
            checkNum(Math.sqrt(Z), 0, Z);
        }
    }
}
