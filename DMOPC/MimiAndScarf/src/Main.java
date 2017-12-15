import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N, K, MAX, count;
    public static int[] P;
    public static ArrayList<Integer>[] adj;
    public static boolean[] vis;

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());
        P = new int[N+1]; MAX = Integer.MIN_VALUE; adj = new ArrayList[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            int x = Integer.parseInt(st.nextToken());
            P[i] = x; MAX = Math.max(MAX, x);
        }
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for(int i = 1; i <= N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); int y = Integer.parseInt(st.nextToken());
            adj[x].add(y); adj[y].add(x);
        }
        int i = 1;
        while(!iTried(i)) {
            i++;
        }
        System.out.println(count);
    }

    public static boolean iTried(int boop) {
        vis = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>(); q.add(boop);
        int[] countColor = new int[MAX+1]; count = 1;
        while(!q.isEmpty()) {
            int cur = q.poll();
            if(1 + countColor[P[cur]] < K) {
                for(int x: adj[cur]) {
                    if(!vis[x]) {
                        vis[x] = true;
                        count++;
                        q.add(x);
                        countColor[P[cur]]++;
                    }
                }
            }
        }
        if(count != 0) return true;
        return false;
    }
}
