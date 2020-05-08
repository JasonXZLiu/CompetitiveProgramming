import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] adj = new int[N];
        for(int i = 0; i < N; i++) {
            adj[i] = Integer.parseInt(br.readLine());
        }
        int incl = adj[0];
        int excl = 0;
        int excl_new;
        for (int i = 1; i < adj.length; i++)
        {
            excl_new = Math.max(incl, excl);
            incl = excl + adj[i];
            excl = excl_new;
        }
        System.out.println(Math.max(incl, excl));
    }
}
