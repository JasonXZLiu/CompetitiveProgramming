import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static int[][] adj;
    public static int N, count = 0;

    static int dfs(int s) {
        Stack<Integer> S = new Stack<>();
        int[] vis = new int[N+1];
        Arrays.fill(vis, -1);
        S.push(s);
        vis[s] = 0;
        while(!S.isEmpty()) {
            int cur = S.pop();
            for(int i = 0; i < 101; i++) {
                if(adj[cur][i] == 1) {
                    if(vis[i] == -1) {
                        vis[i] = vis[cur] + 1;
                        count = vis[i];
                        S.push(i);
                    } else {
                        count++;
                        return count;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = 0; t < 5; t++) {
            N = Integer.parseInt(br.readLine());
            adj = new int[101][101];
            for(int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                adj[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }
            System.out.println(dfs(1));
            count = 0;
        }
    }
}
