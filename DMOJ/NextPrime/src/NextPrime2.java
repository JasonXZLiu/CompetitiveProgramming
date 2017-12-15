import java.util.Scanner;

/**
 * Created by jason_001 on 12/10/2017.
 */
public class NextPrime2 {
    public static void main(String[] args) {
        // write your code here
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        while(true) {
            if(check(N)) break;
            else N++;
        }
        System.out.println(N);
    }

    public static boolean check(long N) {
        if(N == 1 || N == 0) return false;
        for(int i = 2; i <= Math.sqrt(N); i++) {
            if(N % i == 0) {
                return false;
            }
        }
        return true;
    }
}
