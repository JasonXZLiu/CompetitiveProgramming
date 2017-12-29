import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 12/29/2017.
 */
public class SnakesAndLadders {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            int[][] board = new int[101][101];
            for(int i = 1; i <= 100; i++) {
                int j = 1;
                while(j + i <= 100 && j <= 6) {
                    board[i][j+i] = 1;
                    j++;
                }
            }
            int N = Integer.parseInt(br.readLine());
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken()); int B = Integer.parseInt(st.nextToken());
                Arrays.fill(board[A], 0);
                board[A][B] = 2;
            }
            int M = Integer.parseInt(br.readLine());
            for(int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken()); int B = Integer.parseInt(st.nextToken());
                Arrays.fill(board[A], 0);
                board[A][B] = 2;
            }
            Queue<Integer> Q = new LinkedList<>();
            int[] ladder = new int[101];
            int[] dis = new int[101];
            boolean[] vis = new boolean[101];
            vis[1] = true; Q.add(1);
            while(!Q.isEmpty()) {
                int cur = Q.poll();
                for(int i = 0; i < 101; i++) {
                    if(board[cur][i] != 0 && !vis[i]) {
                        vis[i] = true; Q.add(i);
                        if(board[cur][i] == 1) {
                            ladder[i] = ladder[i-1];
                            dis[i] = dis[cur] + 1;
                        }
                        else if(board[cur][i] == 2) {
                            ladder[i] = ladder[i-1] + 1;
                            dis[i] = dis[cur];
                        }
                    }
                }
                if(vis[100]) {
                    break;
                }
            }
            if(vis[100]) System.out.println(dis[100]);
            else System.out.println(-1);
        }
    }
}
