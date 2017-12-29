package ProjectEuler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jason_001 on 12/28/2017.
 */
public class MultiplesOf3And5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            long tot = 0;
            long N = Long.parseLong(br.readLine()) - 1;
            long mul3 = N / 3;
            long mul5 = N / 5;
            long mul15 = N / 15;
            tot += 3 * (mul3 * (1 + mul3)) / 2;
            tot += 5 * (mul5 * (1 + mul5)) / 2;
            tot -= 15 * (mul15 * (1 + mul15)) / 2;
            System.out.println(tot);
        }
    }

}
