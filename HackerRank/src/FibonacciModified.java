import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 12/28/2017.
 */
public class FibonacciModified {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger B1 = new BigInteger(st.nextToken()); BigInteger B2 = new BigInteger(st.nextToken()); int N = Integer.parseInt(st.nextToken());
        BigInteger B3 = new BigInteger("0");
        for(int i = 0; i < N-2; i++) {
            B3 = B1.add(B2.multiply(B2));
            B1 = B2; B2 = B3;
        }
        System.out.println(B3);
    }
}
