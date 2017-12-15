import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static int N, R, C, count;
    public static int[] ans;
    public static int[][] adj;
    public static boolean[][] vis;
    public static Queue<E> q;

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        R = Integer.parseInt(br.readLine()); C = Integer.parseInt(br.readLine());
        adj = new int[R+2][C+2]; vis = new boolean[R+2][C+2]; ans = new int[625];
        for(int i = 1; i <= R; i++) {
            String tmp = br.readLine();
            for(int j = 1; j <= C; j++) {
                String s = tmp.substring(j-1, j);
                switch(s) {
                    case ".":
                        adj[i][j] = 0;
                        vis[i][j] = true;
                        break;
                    default:
                        adj[i][j] = -1;
                        break;
                }
            }
        }
        more();
        Arrays.sort(ans);
        int roomCnt = 0; int total = 0;
        int i = 624;
        while(N - total > 0 && ans[i] != 0) {
//            System.out.println(ans[i]);
            if(total + ans[i] <= N) {
                total += ans[i];
                roomCnt++;
            } else {
                break;
            }
            i--;
        }
        if(roomCnt == 1) System.out.println(roomCnt + " room, " + (N - total) + " square metre(s) left over");
        else System.out.println(roomCnt + " rooms, " + (N - total) + " square metre(s) left over");
    }

    public static boolean more() {
        int tmp = 0;
        for(int i = 1; i <= R; i++) {
            for(int j = 1; j <= C; j++) {
                count = 1;
                if(vis[i][j]) {
                    traverse(i, j);
                    ans[tmp] = count;
                    tmp++;
//                    System.out.println(count);
                }
            }
        }
        return false;
    }

    public static void traverse(int i, int j) {
        vis[i][j] = false;
        if (i > 0 && i <= R && j > 0 && j <= C) {
            if (vis[i + 1][j] && adj[i + 1][j] != -1) {traverse(i+1, j); count++;}
            if (vis[i - 1][j] && adj[i - 1][j] != -1) {traverse(i-1, j); count++;}
            if (vis[i][j + 1] && adj[i][j + 1] != -1) {traverse(i, j+1); count++;}
            if (vis[i][j - 1] && adj[i][j - 1] != -1) {traverse(i, j-1); count++;}
        }
    }

    static class E {
        public int x, y;
        E(int x0, int y0) {x = x0; y = y0;}
    }
}
