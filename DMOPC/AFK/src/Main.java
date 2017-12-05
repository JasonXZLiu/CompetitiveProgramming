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
        int N = Integer.parseInt(br.readLine());
        for(int t = 0; t < N; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int C = Integer.parseInt(st.nextToken()); int R = Integer.parseInt(st.nextToken());
            boolean[][] vis = new boolean[R+2][C+2];
            int[][] dis = new int[R+2][C+2];
            int[][] adj = new int[R+2][C+2];
            E s = null, e = null;
            for (int i = 1; i <= R; i++) {
                String str = br.readLine();
                for (int j = 1; j <= C; j++) {
                    String tmp = str.substring(j-1, j);
                    if(tmp.equals("C")) {
                        vis[i][j] = true; adj[i][j] = 1;
                        s = new E(i, j);
                    } else if (tmp.equals("W")) {
                        adj[i][j] = 2;
                        e = new E(i, j);
                    } else if(tmp.equals("X")){
                        adj[i][j] = -1; vis[i][j] = true;
                    }
                }
            }
            Queue<E> Q = new LinkedList<>();
            Q.add(s);
            while(!Q.isEmpty()) {
                E cur = Q.poll();
                int i = cur.x;
                int j = cur.y;
                if(i > 0 && i <= R && j > 0 && j <= C) {
                    if (!vis[i + 1][j] && adj[i + 1][j] != -1) {
                        vis[i + 1][j] = true;
                        dis[i + 1][j] = dis[i][j] + 1;
                        Q.add(new E(i + 1, j));
                        if (adj[i + 1][j] == 2) {
                            Q = new LinkedList<>();
                            break;
                        }
                    }
                    if (!vis[i - 1][j] && adj[i - 1][j] != -1) {
                        vis[i - 1][j] = true;
                        dis[i - 1][j] = dis[i][j] + 1;
                        Q.add(new E(i - 1, j));
                        if (adj[i - 1][j] == 2) {
                            Q = new LinkedList<>();
                            break;
                        }
                    }
                    if (!vis[i][j + 1] && adj[i][j + 1] != -1) {
                        vis[i][j + 1] = true;
                        dis[i][j + 1] = dis[i][j] + 1;
                        Q.add(new E(i, j + 1));
                        if (adj[i][j + 1] == 2) {
                            Q = new LinkedList<>();
                            break;
                        }
                    }
                    if (!vis[i][j - 1] && adj[i][j - 1] != -1) {
                        vis[i][j - 1] = true;
                        dis[i][j - 1] = dis[i][j] + 1;
                        Q.add(new E(i, j - 1));
                        if (adj[i][j - 1] == 2) {
                            Q = new LinkedList<>();
                            break;
                        }
                    }
                }
            }
            if(dis[e.x][e.y] < 60 && dis[e.x][e.y] > 0) System.out.println(dis[e.x][e.y]);
            else System.out.println("#notworth");
        }
    }

    static class E {
        public int x, y;

        E(int x0, int y0) {x = x0; y = y0;}
    }
}
