import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static ArrayList<Integer>[] adj;
    public static int N;

    static boolean dfs(int s, int e) {
        Stack<Integer> S = new Stack<>();
        boolean[] vis = new boolean[N+1];
        S.push(s);
        vis[s] = true;
        while(!S.isEmpty()) {
            int cur = S.pop();
            for(int i: adj[cur]) {
                if(!vis[i]) {
                    vis[i] = true;
                    S.push(i);
                }
            }
            if(vis[e]) return true;
        }
        return false;
    }


    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()); int B = Integer.parseInt(st.nextToken());
            adj[A].add(B);
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken()); int E = Integer.parseInt(st.nextToken());
        if(dfs(S, E)) System.out.println("Tangled");
        else System.out.println("Not Tangled");
//        long start = System.currentTimeMillis();
//        System.err.println("Loop time: " + (System.currentTimeMillis() - start));
    }
}
