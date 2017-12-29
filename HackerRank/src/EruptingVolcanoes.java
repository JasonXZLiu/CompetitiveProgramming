import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 12/29/2017.
 */
public class EruptingVolcanoes {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), M = Integer.parseInt(br.readLine());
        int[][] adj = new int[N+2][N+2]; // borders are all 0
        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken()); int Y = Integer.parseInt(st.nextToken()); int Z = Integer.parseInt(st.nextToken());
            for(int j = Z-1; j >= 0; j--) {
                if(X-j <= 0 && Y-j <= 0) {
                    adj[0][0] += 1;
                    if(Y+j+1 <= N) adj[0][Y+j+1] -= 1;
                    if(X+j+1 <= N) adj[X+j+1][0] -= 1;
                    if(X+j+1 <= N && Y+j+1 <= N) adj[X+j+1][Y+j+1] += 1;
                }
                else if(X-j <= 0) {
                    adj[0][Y-j] += 1;
                    if(Y+j+1 <= N) adj[0][Y+j+1] -= 1;
                    if(X+j+1 <= N) adj[X+j+1][Y-j] -= 1;
                    if(X+j+1 <= N && Y+j+1 <= N) adj[X+j+1][Y+j+1] += 1;
                } else if(Y-j <= 0) {
                    adj[X-j][0] += 1;
                    if(Y+j+1 <= N) adj[X-j][Y+j+1] -= 1;
                    if(X+j+1 <= N) adj[X+j+1][0] -= 1;
                    if(X+j+1 <= N && Y+j+1 <= N) adj[X+j+1][Y+j+1] += 1;
                } else {
                    adj[X-j][Y-j] += 1;
                    if(Y+j+1 <= N) adj[X-j][Y+j+1] -= 1;
                    if(X+j+1 <= N) adj[X+j+1][Y-j] -= 1;
                    if(X+j+1 <= N && Y+j+1 <= N) adj[X+j+1][Y+j+1] += 1;
                }
            }
        }
        int MAX = Integer.MIN_VALUE;
        for(int i = 1; i < N; i++) adj[i][0] = adj[i-1][0] + adj[i][0];
        for(int i = 1; i < N; i++) adj[0][i] = adj[0][i-1] + adj[0][i];
        for(int i = 1; i < N; i++) {
            for(int j = 1; j < N; j++) {
                adj[i][j] = adj[i][j] + adj[i-1][j] + adj[i][j-1] - adj[i-1][j-1];
                MAX = Math.max(adj[i][j], MAX);
            }
        }
        System.out.println(MAX);
    }
}
