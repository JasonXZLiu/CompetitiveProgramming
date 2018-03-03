import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 2/14/2018.
 */
public class S3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[][] graph = new int[N+2][M+2];
        E start = new E(0, 0);
        Queue<E> Q = new LinkedList<>();
        Queue<E> cam = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            String S = br.readLine();
            for(int j = 1; j <= M; j++) {
                switch (S.substring(j-1, j)) {
                    case "W":
                        graph[i][j] = -1; break;
                    case "S":
                        start = new E(i, j);
                        Q.add(new E(start.x, start.y));
                        break;
                    case "L":
                        graph[i][j] = 3; break;
                    case "R":
                        graph[i][j] = 4; break;
                    case "U":
                        graph[i][j] = 5; break;
                    case "D":
                        graph[i][j] = 6; break;
                    case "C":
                        cam.add(new E(i, j));
                    default:
                        break;
                }
            }
        }
        int[][] dis = new int[N+2][M+2];
        for(int i = 1; i <= N; i++) Arrays.fill(dis[i], -1);
        dis[start.x][start.y] = 0;
        while(!cam.isEmpty()) {
            E c = cam.poll();
            graph[c.x][c.y] = -2;
            for(int i = c.x; i <= N; i++) {
                if(graph[i][c.y] == -1) break;
                if(graph[i][c.y] == 0) dis[i][c.y] = -2;
            }
            for(int i = c.x; i >= 1; i--) {
                if(graph[i][c.y] == -1) break;
                if(graph[i][c.y] == 0) dis[i][c.y] = -2;
            }
            for(int i = c.y; i <= M; i++) {
                if(graph[c.x][i] == -1) break;
                if(graph[c.x][i] == 0) dis[c.x][i] = -2;
            }
            for(int i = c.y; i >= 1; i--) {
                if(graph[c.x][i] == -1) break;
                if(graph[c.x][i] == 0) dis[c.x][i] = -2;
            }
        }
        while(!Q.isEmpty()) {
            E cur = Q.poll();
            if(cur.x >= 1 && cur.x <= N && cur.y >= 1 && cur.y <= M && dis[cur.x][cur.y] >= 0) {
                if(graph[cur.x][cur.y] == 0) {
                    if(graph[cur.x-1][cur.y] >= 0 && dis[cur.x-1][cur.y] == -1) {
                        dis[cur.x-1][cur.y] = dis[cur.x][cur.y] + 1;
                        Q.add(new E(cur.x-1, cur.y));
                    }
                    if(graph[cur.x+1][cur.y] >= 0 && dis[cur.x+1][cur.y] == -1) {
                        dis[cur.x+1][cur.y] = dis[cur.x][cur.y] + 1;
                        Q.add(new E(cur.x+1, cur.y));
                    }
                    if(graph[cur.x][cur.y-1] >= 0 && dis[cur.x][cur.y-1] == -1) {
                        dis[cur.x][cur.y-1] = dis[cur.x][cur.y] + 1;
                        Q.add(new E(cur.x, cur.y- 1));
                    }
                    if(graph[cur.x][cur.y+1] >= 0 && dis[cur.x][cur.y+1] == -1) {
                        dis[cur.x][cur.y+1] = dis[cur.x][cur.y] + 1;
                        Q.add(new E(cur.x, cur.y+1));
                    }
                } else if(graph[cur.x][cur.y] == 3) {
                    if(graph[cur.x][cur.y-1] >= 0 && dis[cur.x][cur.y-1] == -1) {
                        dis[cur.x][cur.y-1] = dis[cur.x][cur.y];
                        Q.add(new E(cur.x, cur.y-1));
                    }
                } else if(graph[cur.x][cur.y] == 4) {
                    if(graph[cur.x][cur.y+1] >= 0 && dis[cur.x][cur.y+1] == -1) {
                        dis[cur.x][cur.y+1] = dis[cur.x][cur.y];
                        Q.add(new E(cur.x, cur.y+1));
                    }
                } else if(graph[cur.x][cur.y] == 5) {
                    if(graph[cur.x-1][cur.y] >= 0 && dis[cur.x-1][cur.y] == -1) {
                        dis[cur.x - 1][cur.y] = dis[cur.x][cur.y];
                        Q.add(new E(cur.x - 1, cur.y));
                    }
                } else if(graph[cur.x][cur.y] == 6) {
                    if(graph[cur.x+1][cur.y] >= 0 && dis[cur.x+1][cur.y] == -1) {
                        dis[cur.x+1][cur.y] = dis[cur.x][cur.y];
                        Q.add(new E(cur.x + 1, cur.y));
                    }
                }
            }
        }
        graph[start.x][start.y] = 2;
        for(int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if(graph[i][j] == 0) {
                    if(dis[i][j] < 0) System.out.println(-1);
                    else System.out.println(dis[i][j]);
                }
            }
        }
    }


    static class E {
        public int x, y;
        E(int x0, int y0) {x = x0; y = y0;}
    }
}