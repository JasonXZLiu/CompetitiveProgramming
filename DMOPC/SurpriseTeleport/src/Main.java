import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken()); int C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int sX = Integer.parseInt(st.nextToken())+1; int sY = Integer.parseInt(st.nextToken())+1;
        st = new StringTokenizer(br.readLine());
        int eX = Integer.parseInt(st.nextToken())+1; int eY = Integer.parseInt(st.nextToken())+1;
        int[][] adj = new int[R+2][C+2];
        for(int i = 1; i <= R; i++) {
            Arrays.fill(adj[i], -1);
            String s = br.readLine();
            for(int j = 1; j <= C; j++) {
                String tmp = s.substring(j-1, j);
                switch(tmp) {
                    case "O":
                        adj[i][j] = 0;
                        break;
                    default:
                        adj[i][j] = -1;
                        break;
                }
            }
        }
        int N = Integer.parseInt(br.readLine());
        E[] end = new E[N+1];
        end[0] = new E(eX, eY);
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            end[i] = new E(Integer.parseInt(st.nextToken())+1, Integer.parseInt(st.nextToken())+1);
        }
        boolean b = true;
        int[][] dis = new int[R+2][C+2];
        Queue<E> Q = new LinkedList<>();
        Q.add(new E(sX, sY)); dis[sX][sY] = 1;
        while(!Q.isEmpty() && b) {
            E cur = Q.poll();
            int i = cur.x;
            int j = cur.y;
            if (i > 0 && i < R + 1 && j > 0 && j < C + 1) {
                if (dis[i + 1][j] == 0 && adj[i + 1][j] != -1) {
                    dis[i + 1][j] = dis[i][j] + 1;
                    Q.add(new E(i + 1, j));
                }
                if (dis[i - 1][j] == 0 && adj[i - 1][j] != -1) {
                    dis[i - 1][j] = dis[i][j] + 1;
                    Q.add(new E(i - 1, j));
                }
                if (dis[i][j + 1] == 0 && adj[i][j + 1] != -1) {
                    dis[i][j + 1] = dis[i][j] + 1;
                    Q.add(new E(i, j + 1));
                }
                if (dis[i][j - 1] == 0 && adj[i][j - 1] != -1) {
                    dis[i][j - 1] = dis[i][j] + 1;
                    Q.add(new E(i, j - 1));
                }
            }
            if(dis[eX][eY] != 0) break;
        }
//        for(int i = 1; i <= R; i++) {
//            for (int j = 1; j <= C; j++) {
//                System.out.print(adj[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println("dis");
//        for(int i = 1; i <= R; i++) {
//            for (int j = 1; j <= C; j++) {
//                System.out.print(dis[i][j]);
//            }
//            System.out.println();
//        }
        int MAX = Integer.MIN_VALUE;
        for(int i = 1; i <= N; i++) {
            E cur = end[i];
            if(dis[cur.x][cur.y] != 0) MAX = Math.max(MAX, dis[eX][eY] - dis[cur.x][cur.y]);
        }
        System.out.println(MAX);
    }

    static class E {
        public int x, y;

        E(int x0, int y0) {x = x0; y = y0;}
    }
}
