import java.util.Scanner;
public class Main {
    static int n = 0;
    static int[][] adj = new int[1002][1002];
    static int[] vis = new int[1002]; static boolean cycle = false;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                adj[i][j] = s.nextInt();
        for (int i = 1; i <= n; i++)
            if(vis[i] ==0) dfs(i);
        if(cycle) System.out.println("NO");
        else System.out.println("YES");
    }
    static void dfs(int u) {
        vis[u] = 1;
        for(int v = 1; v <= n; v++) {
            if(adj[u][v] == 1) {
                if (vis[v] == 0) {dfs(v);}
                else if(vis[v] == 1) { cycle = true; return; }
            }
        }
        vis[u] = 2;
    }
}
