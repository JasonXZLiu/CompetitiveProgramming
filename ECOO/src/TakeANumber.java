import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TakeANumber {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();
        int T = 0; int serve = 0;
        while(!S.equals("EOF")) {
            if(N == 1000) N = 1;
            if(S.equals("TAKE")) {
                T++; N++;
            } else if (S.equals("SERVE")) {
                serve++;
            } else {
                System.out.println(T + " " + (T - serve) + " " + N);
                T = 0; serve = 0;
            }
            S = br.readLine();
        }
    }
}
