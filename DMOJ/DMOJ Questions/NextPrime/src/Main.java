import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(System.in);
        long N = in.nextLong();
        boolean b = false;
        while(!b) {
            long boop = Long.MAX_VALUE;
            for(int i = 2; i <= Math.sqrt(N); i++) {
                if(N % i == 0) {
                    boop = i;
                    break;
                }
            }
            if(N % boop == 0 || N == 1) {
                b = false;
            } else {
                b = true;
            }
            N++;
        }
        System.out.println(--N);
    }
}
