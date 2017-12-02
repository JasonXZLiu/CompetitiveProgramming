import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken());
        int[][] adj = new int[n+2][m+2];
        int[][] dis = new int[n+2][m+2];
        boolean[][] vis = new boolean[n+2][m+2];
        int X = 0, Y = 0;
        Queue<E> q = new LinkedList();
        for (int i = 1; i <= n; i++) {
            String a = br.readLine();
            for(int j = 1; j <= m; j++) {
                String s = a.substring(j-1, j);
                if(s.equals(".")) {
                    adj[i][j] = 1;
                } else if (s.equals("s")) {
                    q.add(new E(i, j));
                    adj[i][j] = 0;
                    vis[i][j] = true;
                } else if (s.equals("e")) {
                    adj[i][j] = 2;
                    X = i;
                    Y = j;
                } else {
                    adj[i][j] = -1;
                }
            }
        }
        while(!q.isEmpty()) {
            E cur = q.poll();
            int i = cur.x;
            int j = cur.y;
            if(i > 0 && i <= n && j > 0 && j <= m) {
                if (!vis[i + 1][j] && adj[i + 1][j] != -1) {
                    vis[i + 1][j] = true;
                    dis[i+1][j] = dis[i][j] +1;
                    q.add(new E(i + 1, j));
                    if (adj[i + 1][j] == 2) {
                        q = new LinkedList<>();
                        break;
                    }
                }
                if (!vis[i - 1][j] && adj[i - 1][j] != -1) {
                    vis[i - 1][j] = true;
                    dis[i-1][j] = dis[i][j] +1;
                    q.add(new E(i - 1, j));
                    if (adj[i - 1][j] == 2) {
                        q = new LinkedList<>();
                        break;
                    }
                }
                if (!vis[i][j + 1] && adj[i][j + 1] != -1) {
                    vis[i][j + 1] = true;
                    dis[i][j+1] = dis[i][j] +1;
                    q.add(new E(i, j + 1));
                    if (adj[i][j + 1] == 2) {
                        q = new LinkedList<>();
                        break;
                    }
                }
                if (!vis[i][j - 1] && adj[i][j - 1] != -1) {
                    vis[i][j - 1] = true;
                    dis[i][j-1] = dis[i][j] +1;
                    q.add(new E(i, j - 1));
                    if (adj[i][j - 1] == 2) {
                        q = new LinkedList<>();
                        break;
                    }
                }
            }
        }
        System.out.println(dis[X][Y]-1);
    }

    static class E {
        public int x, y;

        E (int x0, int y0) {x = x0; y = y0;}
    }
}
