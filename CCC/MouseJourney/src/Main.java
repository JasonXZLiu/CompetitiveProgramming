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
        int R = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
        int[][] adj = new int[R + 1][C + 1];
        int cat = Integer.parseInt(br.readLine());
        for (int i = 0; i < cat; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken()), Y = Integer.parseInt(st.nextToken());
            adj[X][Y] = -1;
        }
        adj[1][1] = 1;
        for(int i = 1; i <= R; i++) {
            for(int j = 1; j <= C; j++) {
                if(adj[i][j] == 0) {
                    adj[i][j] = Math.max(0, adj[i-1][j]) + Math.max(0, adj[i][j-1]);
                }
            }
        }
//        for(int i = 1; i <= R; i++) {
//            for (int j = 1; j <= C; j++) {
//                System.out.print(adj[i][j]);
//            }
//            System.out.println();
//        }
        System.out.println(adj[R][C]);
    }
}
