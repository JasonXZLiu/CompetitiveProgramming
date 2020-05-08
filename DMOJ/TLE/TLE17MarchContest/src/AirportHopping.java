import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 3/30/2018.
 */
public class AirportHopping {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
        E[] adj = new E[M];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            adj[i] = new E(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
    }

    static class E {
        public int A, B, C;

        E(int a, int b, int c) {A = a; B = b; C =c;}
    }
}
