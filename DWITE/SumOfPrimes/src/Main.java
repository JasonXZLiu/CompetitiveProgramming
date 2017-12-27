import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] adj = new long[100001];
        long total = 2;  Integer n = 3; adj[0] = 0; adj[1] = 0; adj[2]=2;
        while (n <= 100000) {
            if (isPrime(n)) total += n;
            adj[n] = total;
            n += 2;
        }
        for(int i = 0; i < 5; i++) {
            int N = Integer.parseInt(br.readLine());
            if(adj[N] == 0 && !(N<=1)) System.out.println(adj[N-1]);
            else System.out.println(adj[N]);
        }
    }

    static boolean isPrime(int n) {
        if (n%2==0) return false;
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }
}


