import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] fib = new boolean[N+1];
        int n3 = 0, n2 = 1, n1 = 0;
        while(n3 <= N) {
            n3 = n1 + n2;
            n1 = n2; n2 = n3;
            if(n3 <= N) fib[n3] = true;
//            System.out.println(n3);
        }
        String S = br.readLine(); boolean b = false;
        for(int i = 1; i <= N; i++) {
            if((S.substring(i-1, i).equals("A") && fib[i]) || (!(fib[i]) && !(S.substring(i-1, i).equals("A"))));
            else {
                b = true;
                break;
            }
        }
        if(b) System.out.println("Bruno, GO TO SLEEP");
        else System.out.println("That's quite the observation!");
    }
}
