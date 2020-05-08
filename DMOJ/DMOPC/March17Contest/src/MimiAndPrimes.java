import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 3/13/2018.
 */
public class MimiAndPrimes {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] primes = new boolean[301];
        primes[0] = true; primes[1] = true;
        for(int i = 2; i <= 300; i++) {
            for(int j = i * 2; j <= 300; j += i) {
                primes[j] = true;
            }
        }
        ArrayList<Integer> pList = new ArrayList<>();
        for(int i = 0; i < 301; i++) {
            if(!primes[i]) {
                pList.add(i);
            }
        }
        ArrayList<Integer> factors = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        long M = Long.parseLong(st.nextToken());
        for(Integer x: pList) {
            if(!factors.contains(x) && M % x == 0) factors.add(x);
        }
        if(factors.size() != 0) {
            for (int i = 1; i < N; i++) {
                M = Integer.parseInt(st.nextToken());
                ArrayList<Integer> remove = new ArrayList<>();
                for (Integer x : factors) {
                    if (M % x != 0) remove.add(x);
                }
                for(Integer x: remove) factors.remove(x);
                if (factors.size() == 0) break;
            }
        }
        if(factors.size() == 0) System.out.println("DNE");
        else {
            Collections.sort(factors);
            System.out.println(factors.get(factors.size()-1));
        }
    }
}
