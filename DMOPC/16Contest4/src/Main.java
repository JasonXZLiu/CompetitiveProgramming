import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] pow = new long[64];
        pow[0] = 1;
        for(int i = 1; i < 64; i++) pow[i] = pow[i-1]*2;
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            long A = Long.parseLong(br.readLine());
            boolean b = false;
            for(long x: pow)
                if(A == x) b = true;
            if(b) System.out.println("T");
            else System.out.println("F");
        }
    }
}
