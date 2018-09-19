import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jason_001 on 12/15/2017.
 */
public class CountingBits {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] ans = new int[num+1];
        int tmp = 2; int add = 0;
        for(int i = 0; i <= num; i++) {
            if(i == tmp) {
                tmp = tmp << 1;
                add = 1;
            } else if (i % 2 == 0);
            else add++;
            ans[i] = add;
        }
        for(int i = 0; i <= num; i++) System.out.print(ans[i] + " ");
    }
}
