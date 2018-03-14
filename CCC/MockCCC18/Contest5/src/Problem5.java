import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 2/12/2018.
 */
public class Problem5 {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] adj = new int[N+2][N+2];
        boolean[][] vis = new boolean[N+2][N+2];
        Queue<E> Q = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            String S = br.readLine();
            for(int j = 1; j <= N; j++) {
                switch(S.substring(j-1, j)) {
                    case "C":
                        adj[i][j] = 1;
                        Q.add(new E(i, j, 1));
                        vis[i][j] = true;
                        break;
                    case "A":
                        adj[i][j] = 2;
                        break;
                    case "L":
                        adj[i][j] = 3;
                        break;
                    default:
                        adj[i][j] = 4;
                        break;
                }
            }
        }
        int count = 0;
        while(!Q.isEmpty()) {
            E cur = Q.poll();
            if(cur.val == 4) {
                count++;
            }
            if(cur.x <= N && cur.y <= N && cur.x >= 1 && cur.y >= 1 && cur.val != 4) {
                if(adj[cur.x+1][cur.y] == cur.val + 1 && !vis[cur.x+1][cur.y]) {
                    vis[cur.x+1][cur.y] = true;
                    Q.add(new E(cur.x+1, cur.y, cur.val + 1));
                }
                else if(adj[cur.x][cur.y+1] == cur.val + 1 && !vis[cur.x][cur.y+1]) {
                    vis[cur.x][cur.y+1] = true;
                    Q.add(new E(cur.x, cur.y+1, cur.val + 1));
                }
                else if(adj[cur.x-1][cur.y] == cur.val + 1 && !vis[cur.x-1][cur.y]) {
                    vis[cur.x-1][cur.y] = true;
                    Q.add(new E(cur.x-1, cur.y, cur.val + 1));
                }
                else if(adj[cur.x][cur.y-1] == cur.val + 1 && !vis[cur.x][cur.y-1]) {
                    vis[cur.x][cur.y-1] = true;
                    Q.add(new E(cur.x, cur.y-1, cur.val + 1));
                }
                else if(adj[cur.x+1][cur.y+1] == cur.val + 1 && !vis[cur.x+1][cur.y+1]) {
                    vis[cur.x+1][cur.y+1] = true;
                    Q.add(new E(cur.x+1, cur.y+1, cur.val + 1));
                }
                else if(adj[cur.x+1][cur.y-1] == cur.val + 1 && !vis[cur.x+1][cur.y-1]) {
                    vis[cur.x+1][cur.y-1] = true;
                    Q.add(new E(cur.x+1, cur.y-1, cur.val + 1));
                }
                else if(adj[cur.x-1][cur.y-1] == cur.val + 1 && !vis[cur.x-1][cur.y-1]) {
                    vis[cur.x-1][cur.y-1] = true;
                    Q.add(new E(cur.x-1, cur.y-1, cur.val + 1));
                }
                else if(adj[cur.x-1][cur.y+1] == cur.val + 1 && !vis[cur.x-1][cur.y+1]) {
                    vis[cur.x-1][cur.y+1] = true;
                    Q.add(new E(cur.x-1, cur.y+1, cur.val + 1));
                }
            }
        }
        System.out.println(count);
    }

    static class E {
        public int x, y, val;

        E(int x0, int y0, int val0) {x = x0; y = y0; val = val0;}
    }
}
