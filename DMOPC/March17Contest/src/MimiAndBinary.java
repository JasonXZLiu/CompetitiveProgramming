import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 3/13/2018.
 */
public class MimiAndBinary {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int[] s0 = new int[S.length()+1];
        int[] s1 = new int[S.length()+1];
        int count0 = 0; int count1 = 0;
        for(int i = 1; i <= S.length(); i++) {
            if(S.substring(i-1, i).equals("0")) {
                count0++; s0[i] = count0; s1[i] = s1[i-1];
            } else {
                count1++; s1[i] = count1; s0[i] = s0[i-1];
            }
        }
        int N = Integer.parseInt(br.readLine());
        for (int t = 0; t < N; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken()), Y = Integer.parseInt(st.nextToken()), Z = Integer.parseInt(st.nextToken());
            int ans = -1;
            if(Z == 0) {
                for(int i = X; i <= S.length() && ans == -1; i++) {
//                    System.out.print(s0[i]);
                    if(s0[i] - s0[X-1] == Y) ans = i;
                }
            } else {
                for(int i = X; i < S.length() && ans == -1; i++) {
//                    System.out.print(s1[i]);
                    if(s1[i] - s1[X-1] == Y) ans = i;
                }
            }
//            System.out.println();
            if(ans != -1) System.out.println(ans);
            else System.out.println(-1);
        }
    }
}
