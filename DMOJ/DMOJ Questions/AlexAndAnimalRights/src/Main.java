import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int R, C, count, ans;
    public static int[][] adj;
    public static boolean[][] vis;

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());
        adj = new int[R + 2][C + 2]; vis = new boolean[R + 2][C + 2];
        for (int i = 1; i <= R; i++) {
            String tmp = br.readLine();
            for (int j = 1; j <= C; j++) {
                String s = tmp.substring(j - 1, j);
                switch (s) {
                    case ".":
                        adj[i][j] = 0;
                        vis[i][j] = true;
                        break;
                    case "M":
                        adj[i][j] = 2;
                        vis[i][j] = true;
                        break;
                    default:
                        adj[i][j] = -1;
                        break;
                }
            }
        }
        ans = 0;
        more();
        System.out.println(ans);
    }

    public static boolean more() {
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                count = 1;
                if (vis[i][j]) {
                    traverse(i, j);
                    if(count != 1) {
                        ans++;
                    }
                }
            }
        }
        return false;
    }

    public static void traverse(int i, int j) {
        if(adj[i][j] == 2) count++;
        vis[i][j] = false;
        if (i > 0 && i <= R && j > 0 && j <= C) {
            if (vis[i + 1][j] && adj[i + 1][j] != -1) {
                traverse(i + 1, j);
            }
            if (vis[i - 1][j] && adj[i - 1][j] != -1) {
                traverse(i - 1, j);
            }
            if (vis[i][j + 1] && adj[i][j + 1] != -1) {
                traverse(i, j + 1);
            }
            if (vis[i][j - 1] && adj[i][j - 1] != -1) {
                traverse(i, j - 1);
            }
        }
    }
}