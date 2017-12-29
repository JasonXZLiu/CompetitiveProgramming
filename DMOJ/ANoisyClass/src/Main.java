import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N, edgeTo[];
    public static ArrayList<Integer>[] adj;
    public static boolean[] onStack, marked;
    public static Stack<Integer> cycle;

    public static void dfs(int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : adj[v]) {
            if (cycle != null) return;
            else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(w);
            }
            else if (onStack[w]) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); int M = Integer.parseInt(br.readLine());
        adj = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken()); int Y = Integer.parseInt(st.nextToken());
            adj[X].add(Y);
        }
        onStack = new boolean[N+1]; marked = new boolean[N+1];
        edgeTo = new int[N+1];
        dfs(1);
        if(cycle == null) System.out.println("Y");
        else System.out.println("N");
    }
}
