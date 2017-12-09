import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int t = 0; t < N; t++) {
            int X = Integer.parseInt(br.readLine()); int Y = Integer.parseInt(br.readLine());
            int[][] adj = new int[X+2][Y+2];
            for(int i = 1; i <= X; i++) {
                Arrays.fill(adj[i], -1);
                String s = br.readLine();
                for(int j = 1; j <= Y; j++) {
                    String tmp = s.substring(j-1, j);
                    switch(tmp) {
                        case "-":
                            adj[i][j] = 0;
                            break;
                        case "|":
                            adj[i][j] = 1;
                            break;
                        case "+":
                            adj[i][j] = 2;
                            break;
                        default:
                            adj[i][j] = -1;
                            break;
                    }
                }
            }
            int[][] dis = new int[X+2][Y+2];
            Queue<E> Q = new LinkedList<>();
            Q.add(new E(1, 1)); dis[1][1] = 1;
            while(!Q.isEmpty()) {
                E cur = Q.poll();
                int i = cur.x; int j = cur.y;
                if(i > 0 && i < X+1 && j > 0 && j < Y+1) {
                    if(dis[i+1][j] == 0 && (adj[i][j] == 1 || adj[i][j] == 2) && adj[i+1][j] != -1) {
                        dis[i+1][j] = dis[i][j] + 1;
                        Q.add(new E(i+1, j));
                    }
                    if(dis[i-1][j] == 0 && (adj[i][j] == 1 || adj[i][j] == 2) && adj[i-1][j] != -1) {
                        dis[i-1][j] = dis[i][j] + 1;
                        Q.add(new E(i-1, j));
                    }
                    if(dis[i][j+1] == 0 && (adj[i][j] == 0 || adj[i][j] == 2) && adj[i][j+1] != -1) {
                        dis[i][j+1] = dis[i][j] + 1;
                        Q.add(new E(i, j+1));
                    }
                    if(dis[i][j-1] == 0 && (adj[i][j] == 0 || adj[i][j] == 2) && adj[i][j-1] != -1) {
                        dis[i][j-1] = dis[i][j] + 1;
                        Q.add(new E(i, j-1));
                    }
                }
                if(dis[X][Y] != 0) break;
            }
//            for(int i = 1; i <= X; i++) {
//                for (int j = 1; j <= Y; j++) {
//                    System.out.print(adj[i][j]);
//                }
//                System.out.println();
//            }
//            for(int i = 1; i <= X; i++) {
//                for (int j = 1; j <= Y; j++) {
//                    System.out.print(dis[i][j]);
//                }
//                System.out.println();
//            }
            if(dis[X][Y] != 0) System.out.println(dis[X][Y]);
            else System.out.println(-1);
        }
    }

    static class E {
        public int x, y;

        E(int x0, int y0) {x = x0; y = y0;}
    }
}
