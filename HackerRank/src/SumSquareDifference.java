import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jason_001 on 12/29/2017.
 */
public class SumSquareDifference {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            long N = Long.parseLong(br.readLine());
            long sumOfSquares = (N * (N+1) * (2*N + 1)) / 6;
            long squareOfSum = (N * (N+1)) / 2 * (N * (N+1)) / 2;
            System.out.println(Math.abs(sumOfSquares - squareOfSum));
        }
    }
}
