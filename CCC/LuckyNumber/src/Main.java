import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jason_001 on 12/23/2017.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            String A = br.readLine();
            Long a = Long.parseLong(A.substring(0, 1));
            while(A.length() > 1) {
                a = Long.parseLong(A.substring(0, 1));
                for(int j = 1; j < A.length(); j++) {
                    a += Integer.parseInt(A.substring(j, j+1));
                }
                A = a.toString();
//                System.out.println(A);
            }
            System.out.println(a);
        }
    }
}
