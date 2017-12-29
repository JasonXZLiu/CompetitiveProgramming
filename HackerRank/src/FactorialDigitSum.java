import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by jason_001 on 12/29/2017.
 */
public class FactorialDigitSum {

    public static int digitSum(String S) {
        int num = 0;
        for(int i = 0; i < S.length(); i++) {
            num += Integer.parseInt(S.substring(i, i+1));
        }
        return num;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[1001];
        BigInteger factorial = new BigInteger("1");
        for(Integer i = 1; i <= 1001; i++) {
            factorial = factorial.multiply(new BigInteger(i.toString()));
//            System.out.println(factorial.toString());
            arr[i] = digitSum(factorial.toString());
        }
        arr[0] = 1;
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(arr[N]);
        }
    }
}
