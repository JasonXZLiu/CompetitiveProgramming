import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by jason_001 on 12/2/2017.
 */
public class Main {
    public static ArrayList<Integer>[] adj;
    public static int N, R;
    public static int[] rabbitDis;

    public static void bfs(int[] boop) {
        Queue<Integer> Q = new LinkedList<>();
        rabbitDis = new int[N+1];
        Arrays.fill(rabbitDis, -1);
        for (int r: boop) {
            Q.add(r); rabbitDis[r] = 0;
        }
        int count = 0;
        while(!Q.isEmpty()) {
            count++;
            int cur = Q.poll();
            for(int x: adj[cur]) {
                if(rabbitDis[x] == -1) {
                    rabbitDis[x] = count;
                    Q.add(x);
                }
            }
        }
    }

    public static int carrotBFS(int s, int y) {
        Queue<Integer> Q = new LinkedList<>();
        int MIN = Integer.MAX_VALUE;
        boolean[] vis = new boolean[N+1];
        vis[s] = true; Q.add(s);
        MIN = Math.min(MIN, rabbitDis[s]);
        while(!Q.isEmpty()) {
            int cur = Q.poll();
            for(int x: adj[cur]) {
                if(!vis[x]) {
                    MIN = Math.min(MIN, rabbitDis[x]);
                    vis[x] = true;
                    Q.add(x);
                }
            }
            if(vis[y]) return MIN;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); R = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); int b = Integer.parseInt(st.nextToken());
            adj[a].add(b); adj[b].add(a);
        }
        int[] boop = new int[R];
        for(int i = 0; i < R; i++) {
            int s = Integer.parseInt(br.readLine());
            boop[i] = s;
        }
        bfs(boop);
        st = new StringTokenizer(br.readLine());
        System.out.println(carrotBFS(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
    }
}
