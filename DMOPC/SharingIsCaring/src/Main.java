import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
        ArrayList<E>[] adj = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()); int B = Integer.parseInt(st.nextToken());
            String S = br.readLine();
            adj[B].add(new E(A, S));
        }
        int X = Integer.parseInt(br.readLine());
        for(E x: adj[X]) {
            System.out.println(x.n);
        }
    }

    static class E {
        public int v;
        public String n;
        E(int v0, String n0) {v = v0; n = n0;}
    }
}
