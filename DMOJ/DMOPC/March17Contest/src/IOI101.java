import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOI101 {
    static String abc = "Ol2EASG7Bg";

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine(); String ans = "";
        for(int i = 0; i < S.length(); i++) {
            try {
                int N = Integer.parseInt(S.substring(i, i+1));
                ans += abc.substring(N, N+1);
            } catch (NumberFormatException e) {
                ans += S.substring(i, i+1);

            }
        }
        System.out.println(ans);
    }
}
