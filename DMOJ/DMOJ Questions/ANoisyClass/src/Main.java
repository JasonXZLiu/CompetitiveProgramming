import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N;
    public static ArrayList<Integer>[] adj;
    public static boolean[] vis;
    public static Set<Integer> S = new HashSet<>();

    public static boolean check(int v, boolean[] visited, Set<Integer> S) {
        if(!visited[v]) {
            visited[v] = true;
            S.add(v);
            for(int i : adj[v]) {
                if(!visited[i]) {
                    if(check(i, visited, S))
                        return true;
                }
                else if(S.contains(i))
                    return true;
            }
        }
        S.remove(v);
        return false;
    }

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); int K = Integer.parseInt(br.readLine());
        adj = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for(int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
            adj[A].add(B);
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
        if(check(A, vis, S)) System.out.println("N");
        else System.out.println("Y");
        vis = new boolean[N+1];
        Arrays.fill(vis, false);
    }
}
