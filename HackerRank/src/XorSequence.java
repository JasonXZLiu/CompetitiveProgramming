import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 12/28/2017.
 */
public class XorSequence {

    public static long check(long N) {
        long A = N % 8;
        if(A == 0 || A == 1) return N;
        else if (A == 2 || A == 3) return 2;
        else if (A == 4 || A == 5) return N + 2;
        else return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long B = Long.parseLong(st.nextToken()); long A = Long.parseLong(st.nextToken());
            System.out.println(check(A)^check(B-1));
        }
    }
}
