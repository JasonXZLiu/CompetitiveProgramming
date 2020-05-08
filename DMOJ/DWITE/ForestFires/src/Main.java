import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by jason_001 on 12/23/2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = 0; t < 5; t++) {
            int[][] forest = new int[12][12];
            int count = 0;
            Queue<E> Q = new LinkedList<>();
            for(int i = 1; i <= 10; i++) {
                String s = br.readLine();
                for(int j = 1; j <= 10; j++) {
                    String boop = s.substring(j-1, j);
                    if(boop.equals("F")) {
                        forest[i][j] = 2;
                        Q.add(new E(i, j));
                    } else if (boop.equals("T")) {
                        count++;
                        forest[i][j] = 1;
                    }
                }
            }
            int countFire =0;
            boolean[][] vis = new boolean[12][12];
            int[][] dis = new int[12][12]; int MAX = Integer.MIN_VALUE;
            while(!Q.isEmpty()) {
                E cur = Q.remove();
                int i = cur.x;
                int j = cur.y;
                if(i > 0 && i <= 10 && j > 0 && j <= 10) {
                    if (!vis[i][j-1] && forest[i][j - 1] == 1) {
                        countFire++; vis[i][j-1] = true;
                        dis[i][j-1] = dis[i][j] +1;
                        forest[i][j - 1] = 2;
                        Q.add(new E(i, j - 1));
                    }
                    if (!vis[i][j+1] && forest[i][j + 1] == 1) {
                        countFire++; vis[i][j+1] = true;
                        dis[i][j+1] =dis[i][j] +1;
                        forest[i][j+1] = 2;
                        Q.add(new E(i, j + 1));
                    }
                    if (!vis[i+1][j] && forest[i + 1][j] == 1) {
                        countFire++; vis[i+1][j] = true;
                        dis[i+1][j] = dis[i][j] +1;
                        forest[i + 1][j] = 2;
                        Q.add(new E(i + 1, j));
                    }
                    if (!vis[i-1][j] && forest[i - 1][j] == 1) {
                        countFire++; vis[i-1][j] = true;
                        dis[i-1][j] = dis[i][j] +1;
                        forest[i - 1][j] = 2;
                        Q.add(new E(i - 1, j));
                    }
                }
                MAX = Math.max(MAX, dis[i][j]);
//                for(int k = 1; k <= 10; k++) {
//                    for(int l = 1; l <= 10; l++) {
//                        System.out.print(dis[k][l]);
//                    }
//                    System.out.println();
//                }
            }
            if(count != countFire) System.out.println(-1);
            else System.out.println(MAX);
            if(t != 5) br.readLine();
        }
    }

    static class E {
        public int x, y;
        E(int x, int y) {this.x = x; this.y = y;}
    }
}
