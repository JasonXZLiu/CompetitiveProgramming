import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static BufferedReader br;
    public static ArrayList<Integer>[] adj;
    public static int N, M;

    public static int bfs() throws IOException {
        int[] dis = new int[N+1];
        Arrays.fill(dis, -1);
        Queue<Integer> Q = new LinkedList<>();
        int W = Integer.parseInt(br.readLine());
        Q.add(1);
        dis[1]= 0;
        for (int i = 1; i <= W; i++) {
            int a = Integer.parseInt(br.readLine());
            dis[a] = 0;
            Q.add(a);
        }
        int count = 0;
        while(!Q.isEmpty()) {
            count++;
            int cur = Q.poll();
            for(int x: adj[cur]) {
                if(dis[x] == -1) {
                    dis[x] = count;
                    Q.add(x);
                }
            }
        }
        return dis[N];
    }

    public static int length(int s) {
        Queue<Integer> Q = new LinkedList<>();
        int[] dis = new int[N+1];
        Arrays.fill(dis, -1);
        dis[s] = 0; Q.add(s);
        int count = 0;
        while(!Q.isEmpty()) {
            count++;
            int cur = Q.poll();
            for(int x: adj[cur]) {
                if(dis[x] == -1) {
                    dis[x] = count;
                    Q.add(x);
                }
            }
            if(dis[N] != -1) return dis[N];
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
	// write your code here
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); int y = Integer.parseInt(st.nextToken());
            adj[x].add(y); adj[y].add(x);
        }
        int tmp = length(1);
        if(bfs() + 3 >= tmp && tmp != -1) {
            System.out.println(tmp);
        } else {
           System.out.println("sacrifice bobhob314");
        }
    }
}
