import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by jason_001 on 1/1/2018.
 */
public class ThePolarExpress {

    public static int check(String lstr) {
        int cnt = 0; int tot = 0;
        while(cnt < lstr.length()) {
            tot += Integer.parseInt(lstr.substring(cnt, cnt+1)); cnt++;
        }
        return tot;
    }

    public static int check(long L, int tot) {
        while(L % 10 == 0) {
            L /= 10;
            tot -= 9;
        }
        return ++tot;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Long L = Long.parseLong(st.nextToken()), R = Long.parseLong(st.nextToken());
        int tot = check(L.toString());
        boolean[] sum = new boolean[10000];
        int cnt = 1;
        L++; sum[tot] = true;
        while(L <= R) {
            if(L % 10 == 0) tot = check(L, tot);
            else tot += 1;
            if(!sum[tot]) {
//                System.out.println(L + " " + tot);
                sum[tot] = true;
                cnt++;
            }
            L++;
        }
        System.out.println(cnt);
    }
}