import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.TreeSet;

/**
 * Created by jason_001 on 1/8/2018.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<Integer> S = new TreeSet<>();
        int N = Integer.parseInt(br.readLine());
        for(int i = 1; i <= N; i++) {
            S.add(i);
        }
        int K = Integer.parseInt(br.readLine()); int count = 0;
        int i = 0;
        while(i < K) {
            i++;
            int A = Integer.parseInt(br.readLine());
            if(S.contains(A)) {
//                System.out.println(A);
                S.remove(A);
                count++;
            }
            else if(S.floor(A) != null) {
//                System.out.println(S.floor(A));
                S.remove(S.lower(A));
                count++;
            } else {
                break;
            }
        }
        System.out.println(count);
    }
}
