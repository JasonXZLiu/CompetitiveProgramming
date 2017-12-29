package ProjectEuler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by jason_001 on 12/29/2017.
 */
public class LargeSum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BigInteger sum = new BigInteger("0");
        for(int i = 0; i < N; i++) {
            String S = br.readLine();
            BigInteger A = new BigInteger(S);
            sum = sum.add(A);
        }
        System.out.println(sum.toString().substring(0, 10));
    }
}
