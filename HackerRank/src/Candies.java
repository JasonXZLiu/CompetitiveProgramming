import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jason_001 on 12/28/2017.
 */
public class Candies {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] adj = new int[N+1]; int[] cad = new int[N+1]; int tot = 0;
        adj[0] = Integer.MIN_VALUE;
        cad[1] = 1; int s = 1; boolean b = false;
        for(int i = 1; i <= N; i++) adj[i] = Integer.parseInt(br.readLine());
        for(int i = 1; i <= N; i++) {
            if(adj[i] > adj[i-1]) cad[i] = cad[i-1] + 1;
            else if(adj[i] <= adj[i-1]) {
                if(cad[i-1]-1 < 1) {
                    cad[i] = cad[i-1]-1;
                    s = i-1; b = true;
                } else {
                    cad[i] = 1;
                }
            }
            if(b) {
                for(int j = s; j <= i; j++) {
                    cad[j]++;
                }
                b = false;
            }
        }
        for(int i = 1; i <= N; i++) {
            System.out.print(cad[i] + " ");
            tot += cad[i];
        }
        System.out.println();
        System.out.println(tot);
    }
}
