import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class NaiveWay {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        City[] cities = new City[N+1];
        int[][] adj = new int[N+1][N+1];
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); int y = Integer.parseInt(st.nextToken());
            cities[i] = new City(x, y);
        }
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= i; j++) {
                int tmp = (cities[i].x-cities[j].x)*(cities[i].x-cities[j].x)+(cities[i].y-cities[j].y)*(cities[i].y-cities[j].y);
                adj[i][j] = tmp; adj[j][i] = tmp;
            }
        }
        int X = Integer.parseInt(br.readLine());
        int dis[] = new int[N+1];
        boolean vis[] = new boolean[N+1];
        Arrays.fill(dis, Integer.MAX_VALUE); dis[X] = 0;
        for(int t = 1; t <= N; t++) {
            int MIN = Integer.MAX_VALUE, idx = -1;
            for (int i = 1; i <= N; i++) {
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
        Arrays.sort(dis);
        int query = Integer.parseInt(br.readLine());
        for(int i = 0; i < query; i++) {
            int q = Integer.parseInt(br.readLine());
            System.out.println(binarySearch(dis, 0, N, q));
        }
    }

    public static int binarySearch(int dis[], int l, int r, int q) {
        if (r>=l) {
            int mid = l + (r - l)/2;
            if (dis[mid] == q)
                return mid + check(dis, mid, q);
            if (dis[mid] > q && dis[mid-1] < q) {
                return mid + check(dis, mid, q);
            } else if (dis[mid] > q) {
                return binarySearch(dis, l, mid - 1, q);
            }
            return binarySearch(dis, mid+1, r, q);
        }
        return -1;
    }

    public static int check(int dis[], int mid, int q) {
        int cnt = 0;
        while(dis[mid] == q) {
            cnt++; mid++;
        }
        return cnt;
    }

    static class City {
        public int x, y;

        City(int x0, int y0) {x = x0; y = y0;}
    }
}
