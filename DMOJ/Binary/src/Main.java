import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            int B = Integer.parseInt(br.readLine());
            int foop = 0; int foo = B;
            while(foo / 16 > 0) {
                foo = foo / 16;
                foop++;
            }
            foop = (foop + 1) * 4;
            int[] boop = new int[foop];
            int j = 0;
            while(B > 0) {
                if (B % 2 != 0) boop[j] = 1;
                else boop[j] = 0;
                B = B >> 1;
                j++;
            }
            for(int blah = foop - 1; blah >= 0; blah--) {
                if((blah+1) % 4 == 0 && blah != foop-1) System.out.print(" ");
                System.out.print(boop[blah]);
            }
            System.out.println();
        }
    }
}
