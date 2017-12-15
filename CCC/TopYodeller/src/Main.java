import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
        E[] adj = new E[N];
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
            int x = Integer.parseInt(st.nextToken());
            adj[j] = new E(j+1, x, Integer.MIN_VALUE);
        }
        for (int i = 1; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                adj[j].value += Integer.parseInt(st.nextToken());
            }
            Arrays.sort(adj);
            for (int j = 0; j < N; j++) {
                adj[j].wr = Math.max(adj[j].wr, j);
            }
        }
        System.out.println("Yodeller " + adj[N-1].idx + " is the TopYodeller: score " + adj[N-1].value + ", worst rank " + (adj[N-1].wr+1));
    }

    static class E implements Comparable<E> {
        public int idx, value, wr;

        E(int idx0, int val0, int wr0) {idx = idx0; value = val0; wr = wr0;}

        @Override
        public int compareTo(E o) {
            if(value > o.value) return 1;
            else return -1;
        }
    }
}
