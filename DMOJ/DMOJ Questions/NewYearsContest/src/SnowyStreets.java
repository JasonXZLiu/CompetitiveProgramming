import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 1/1/2018.
 */
public class SnowyStreets {
    public static long[][] adj, board;
    public static long K;
    public static int R, C;

    public static boolean traversal(int sX, int sY, int eX, int eY) {
        if(board[sX][sY] >= K) return false;
        boolean[][] vis = new boolean[R+2][C+2];
        Stack<E> Q = new Stack<>();
        Q.add(new E(sX, sY));
        while(!Q.isEmpty()) {
            E cur = Q.pop();
            int x = cur.x;
            int y = cur.y;
            if(x+1 <= R) {
                if(board[x+1][y] < K && !vis[x+1][y]) {
                    vis[x+1][y] = true;
                    Q.add(new E(x+1, y));
                }
            }
            if(y+1 <= C) {
                if(board[x][y+1] < K && !vis[x][y+1]) {
                    vis[x][y+1] = true;
                    Q.add(new E(x, y+1));
                }
            }
            if(vis[eX][eY]) return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken()); K = Long.parseLong(st.nextToken()); int Q = Integer.parseInt(st.nextToken());
        adj = new long[R+2][C+2]; board = new long[R+2][C+2]; boolean change = false;
        for(int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            if(A == 1) {
                change = true;
                int X1 = Integer.parseInt(st.nextToken()); int Y1 = Integer.parseInt(st.nextToken());
                int X2 = Integer.parseInt(st.nextToken()) + 1; int Y2 = Integer.parseInt(st.nextToken()) + 1;
                long B = Long.parseLong(st.nextToken());
                adj[X1][Y1] += B;
                adj[X2][Y1] -= B;
                adj[X1][Y2] -= B;
                adj[X2][Y2] += B;
            }
            else {
                if(change) {
                    for (int i = 1; i <= R; i++) board[i][0] = adj[i][0] + board[i - 1][0];
                    for (int i = 1; i <= C; i++) board[0][i] = adj[0][i] + board[0][i - 1];
                    for (int i = 1; i <= R; i++) {
                        for (int j = 1; j <= C; j++) {
                            board[i][j] = adj[i][j] + board[i - 1][j] + board[i][j - 1] - board[i - 1][j - 1];
                        }
                    }
                    change = false;
                }
                int X1 = Integer.parseInt(st.nextToken()); int Y1 = Integer.parseInt(st.nextToken());
                int X2 = Integer.parseInt(st.nextToken()); int Y2 = Integer.parseInt(st.nextToken());
                if(traversal(X1, Y1, X2, Y2)) System.out.println("yes");
                else System.out.println("no");
            }
        }
    }

    static class E {
        public int x, y;
        E(int x0, int y0) {x = x0; y = y0;}
    }
}
