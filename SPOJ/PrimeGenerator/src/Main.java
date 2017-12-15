import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken()); int E = Integer.parseInt(st.nextToken());
            for(Integer i = S; i <= E; i++) {
                String tmp = i.toString();
                BigInteger B = new BigInteger(tmp);
                if(B.isProbablePrime(i)) System.out.println(B);
            }
            System.out.println();
        }
    }
}
