import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static int[] H;
    public static int N;

    public static int boop (int mid) {
        int best = N;
        int D = 2 * mid;

        int i = 0;
        while(i < N && H[i] <= H[0] + D) {
            int count = 1;
            int end = H[i];
            int j = i+1;
            while(j < N && H[i] > H[j] + D - 1000000) {
                if(H[j] > end) {
                    end = H[j] + D; count++;
                }
                j++;
            }
            best = Math.min(best, count);
            i++;
        }

        return best;
    }

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        H = new int[N];
        for(int i = 0; i < N; i++) H[i] = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        Arrays.sort(H);
        int low = -1;
        int high = 1000000;
        while(high > low + 1) {
            int mid = (low + high) / 2;
            if(boop(mid) > K) low = mid;
            else high = mid;
        }
        System.out.println(high);
    }
}
