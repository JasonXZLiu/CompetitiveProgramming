import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static ArrayList<Integer>[] adj;
    public static int N, ans = Integer.MAX_VALUE;
    public static boolean[] s;
    public static int[] dis;

    static void dfs(int v, int x) {
        dis[v] = x;
        s[v] = true;
        for (int w : adj[v]) {
            if(dis[w] == -1) {
                dfs(w, x + 1);
            } else if (s[w]) {
                ans = Math.min(ans, x);
                return;
            }
        }
        s[v] = false;
    }

    static void dfs(int u) {
        boolean[] vis = new boolean[101];
        Stack<Integer> S = new Stack<>();
        S.push(u);
        while(!S.isEmpty()) {
            int cur = S.pop();
            for(int x: adj[cur]) {
                if(!vis[x]) {
                    vis[x] = true;
                    dis = new int[101];
                    s = new boolean[101];
                    Arrays.fill(dis, -1);
                    dfs(x, 1);
                    S.push(x);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = 0; t < 5; t++) {
            ans = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            adj = new ArrayList[101];
            for(int i = 1; i <= 100; i++) adj[i] = new ArrayList<>();
            for(int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken()); int B = Integer.parseInt(st.nextToken());
                adj[A].add(B);
            }
            dis = new int[101];
            s = new boolean[101];
            Arrays.fill(dis, -1);
            dfs(1, 1); dfs(1);
            System.out.println(ans);
        }
    }
}
