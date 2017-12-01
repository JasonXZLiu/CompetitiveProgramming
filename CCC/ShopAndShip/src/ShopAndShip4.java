import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 11/30/2017.
 */
public class ShopAndShip4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); int T = Integer.parseInt(br.readLine());
        int[][] adj = new int[N+1][N+1];
        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); int y = Integer.parseInt(st.nextToken()); int z = Integer.parseInt(st.nextToken());
            adj[x][y] = z; adj[y][x] = z;
        }
        int P = Integer.parseInt(br.readLine());
        int[] city = new int[N+1]; int[] prices = new int[N+1];
        for (int i = 0; i < P; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            city[i] = Integer.parseInt(st.nextToken());
            prices[i] = Integer.parseInt(st.nextToken());
        }
        int D = Integer.parseInt(br.readLine());
        int[] dis = new int[N+1];
        boolean[] vis = new boolean[N+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[D] = 0;
        for (int i = 1; i <= N; i++) {
            int value = Integer.MAX_VALUE;
            int todo = Integer.MAX_VALUE;
            for(int j = 1; j <= N; j++) {
                if(!vis[j] && value > dis[j]) {
                    value = dis[j];
                    todo = j;
                }
            }
            if(value != Integer.MAX_VALUE) {
                vis[todo] = true;
                for(int j = 1; j <= N; j++) {
                    if(!vis[j] && adj[todo][j] != 0 && dis[j] > dis[todo] + adj[todo][j]) {
                        dis[j] = dis[todo] + adj[todo][j];
                    }
                }
            }
        }
        int cost = Integer.MAX_VALUE;
        for(int i = 0; i < P; i++) {
            if(dis[city[i]] != Integer.MAX_VALUE) cost = Math.min(cost, dis[city[i]] + prices[i]);
        }
        System.out.println(cost);
    }
}
