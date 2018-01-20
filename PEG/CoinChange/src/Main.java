import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine()), N = Integer.parseInt(br.readLine());
        int[] adj = new int[X + 1]; Arrays.fill(adj, Integer.MIN_VALUE);
        int[] coins = new int[N + 1];
        for(int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
            adj[coins[i]] = 1;
        }
        Arrays.sort(coins);
        for(int i = 0; i <= X; i++) {
            if(adj[i] != Integer.MIN_VALUE) {
                for(int j = N; j >= 1; j--) {
                    if(coins[j] + i <= X) {
                        if (adj[coins[j] + i] != Integer.MIN_VALUE) adj[coins[j] + i] = Math.min(adj[coins[j] + i], adj[i] + 1);
                        else adj[coins[j] + i] = adj[i] + 1;
                    }
                }
            }
        }
        System.out.println(adj[X]);
    }
}
