import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 11/30/2017.
 */
class ShopAndShip3 {

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
        int[] city = new int[N+1]; int[] price = new int[N+1];
        for(int i = 1; i <= P; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            city[i] = Integer.parseInt(st.nextToken());
            price[i] = Integer.parseInt(st.nextToken());
        }
        int D = Integer.parseInt(br.readLine());
        int dis[] = new int[N+1];
        boolean vis[] = new boolean[N+1];
        Arrays.fill(dis, Integer.MAX_VALUE); dis[D] = 0;
        for(int t = 1; t <= N; t++) {
            int MIN = Integer.MAX_VALUE, idx = -1;
            for (int i = 0; i <= N; i++) {
                if(!vis[i] && dis[i] < MIN) {
                    MIN = dis[i]; idx = i;
                }
            }
            if(idx == -1) break;
            vis[idx] = true;
            for(int v = 1; v <= N; v++) {
                if (adj[idx][v] > 0 && dis[v] > dis[idx] + adj[idx][v])
                    dis[v] = dis[idx] + adj[idx][v];
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= P; i++) {
            if(dis[city[i]] != Integer.MAX_VALUE)
                ans = Math.min(ans, price[i] + dis[city[i]]);
        }
        System.out.println(ans);
    }
}
