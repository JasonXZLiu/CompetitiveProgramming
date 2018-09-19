package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 3/5/2018.
 */
public class CastleOnTheGrid {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] adj = new int[N+2][N+2];
        for(int i = 1; i <= N; i++) {
            String S = br.readLine();
            for(int j = 1; j <= N; j++) {
                switch(S.substring(j-1, j)) {
                    case "X":
                        adj[i][j] = -1;
                        break;
                }
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        E start = new E(Integer.parseInt(st.nextToken())+1, Integer.parseInt(st.nextToken())+1);
        E end = new E(Integer.parseInt(st.nextToken())+1, Integer.parseInt(st.nextToken())+1);
        int[][] dis = new int[N+2][N+2];
        for(int i = 0; i <= N+1; i++) Arrays.fill(dis[i], -1);
        Queue<E> Q = new LinkedList<>();
        Q.add(start); dis[start.x][start.y] = 0;
        while(!Q.isEmpty()) {
            E cur = Q.poll();
            int tmp = 1; boolean b = false;
            while(cur.y+tmp <= N && adj[cur.x][cur.y+tmp] != -1 && dis[cur.x][cur.y+tmp] == -1) {
                dis[cur.x][cur.y+tmp] = dis[cur.x][cur.y] + 1;
                tmp ++; b = true;
            }
            if(b) Q.add(new E(cur.x, cur.y+tmp));
            tmp = 1; b = false;
            while(cur.y-tmp >= 1 && adj[cur.x][cur.y-tmp] != -1 && dis[cur.x][cur.y-tmp] == -1) {
                dis[cur.x][cur.y-tmp] = dis[cur.x][cur.y] + 1;
                tmp ++; b = true;
            }
            if(b) Q.add(new E(cur.x, cur.y-tmp));
            tmp = 1; b = false;
            while(cur.x+tmp <= N && adj[cur.x+tmp][cur.y] != -1 && dis[cur.x+tmp][cur.y] == -1) {
                dis[cur.x+tmp][cur.y] = dis[cur.x][cur.y] + 1;
                tmp ++; b = true;
            }
            if(b) Q.add(new E(cur.x+tmp, cur.y));
            tmp = 1; b = false;
            while(cur.x-tmp >= 1 && adj[cur.x-tmp][cur.y] != -1 && dis[cur.x-tmp][cur.y] == -1) {
                dis[cur.x-tmp][cur.y] = dis[cur.x][cur.y] + 1;
                tmp ++; b = true;
            }
            if(b) Q.add(new E(cur.x-tmp, cur.y));
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    System.out.print(dis[i][j] + " ");
                }
                System.out.println();
            }
            if(dis[end.x][end.y] != -1) break;
        }
        System.out.println(dis[end.x][end.y]);
    }

    static class E {
        public int x, y;
        E(int x0, int y0) {x = x0; y = y0;}
    }
}
