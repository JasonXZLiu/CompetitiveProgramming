import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int B;
    public static ArrayList<Integer>[] adj;

    public static boolean bfs(int s, int e) {
        Queue<Integer> Q = new LinkedList<>();
        boolean[] vis = new boolean[B+1];
        vis[s] = true; Q.add(s);
        while(!Q.isEmpty()) {
            Integer cur = Q.poll();
            for(int x: adj[cur]) {
                if(!vis[x]) {
                    vis[x] = true;
                    Q.add(x);
                }
            }
            if(vis[e]) return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken()); int Q = Integer.parseInt(st.nextToken());
        Beacon[] tree = new Beacon[B+1];
        for(int i = 1; i <= B; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); int y = Integer.parseInt(st.nextToken()); int r = Integer.parseInt(st.nextToken());
            tree[i] = new Beacon(x, y, r);
        }
        adj = new ArrayList[B+1];
        for(int i = 1; i <= B; i++) adj[i] = new ArrayList<>();
        for(int i = 1; i <= B; i++) {
            for(int j = 1; j <= B; j++) {
//                System.out.println(i + " " + j);
                if(tree[i].w >= Math.sqrt((tree[i].x-tree[j].x)*(tree[i].x-tree[j].x)+(tree[i].y-tree[j].y)*(tree[i].y-tree[j].y))) {
                    adj[i].add(j);
                }
            }
        }
        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken()); int Y = Integer.parseInt(st.nextToken());
            if(bfs(X, Y)) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    static class Beacon {
        public int x, y, w;

        public Beacon(int x, int y, int r) {this.x = x; this.y = y; w = r;}
    }
}