import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N;
    public static ArrayList<Integer>[] adj;

    static int dfs(int s, int e) {
        int count = 0; boolean b = false;
        Stack<Integer> S = new Stack<>();
        int[] vis = new int[N+1];
        Arrays.fill(vis, -1); S.push(s); vis[s] = 0;
        while(!S.isEmpty()) {
            int cur = S.pop();
            for(int i: adj[cur]) {
                if(vis[i] == -1) {
                    vis[i] = vis[cur] + 1;
                    S.push(i);
                }
            }
        }
        return vis[e]-1;
    }

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        adj = new ArrayList[N+1]; map.put(-1, -1);
        for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()); int B = Integer.parseInt(st.nextToken());
            int a, b;
            if(map.containsKey(A)) a = map.get(A);
            else {
                map.put(A, map.size());
                a = map.get(A);
            }
            if(map.containsKey(B)) b = map.get(B);
            else {
                map.put(B, map.size());
                b = map.get(B);
            }
            adj[a].add(b);
        }
        String s = br.readLine();
        while(!s.equals("0 0")) {
            StringTokenizer st = new StringTokenizer(s);
            int S = Integer.parseInt(st.nextToken()); int E = Integer.parseInt(st.nextToken());
            if(map.containsKey(S) && map.containsKey(E)) {
                int boop = dfs(map.get(S), map.get(E));
                if (boop < 0) System.out.println("No");
                else System.out.println("Yes " + boop);
            } else {
                System.out.println("No");
            }
            s = br.readLine();
        }
    }
}
