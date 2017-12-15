import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        E[] adj = new E[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken(); int R = Integer.parseInt(st.nextToken()); int S = Integer.parseInt(st.nextToken()); int D = Integer.parseInt(st.nextToken());
            adj[i] = new E(i+1, 2*R+3*S+D, a);
        }
        Arrays.sort(adj);
        if(N > 0) System.out.println(adj[N-1].name);
        if(!(N-2 < 0)) System.out.println(adj[N-2].name);
    }

    static class E implements Comparable<E>{
        public int idx, rate;
        public String name;

        E(int i0, int r0, String n0) {idx = i0; rate = r0; name = n0;}

        @Override
        public int compareTo(E o) {
            if(rate > o.rate) return 1;
            else if (rate < o.rate) return -1;
            else {
                return o.name.compareTo(name);
            }
        }
    }
}
