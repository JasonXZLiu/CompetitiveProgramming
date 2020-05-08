import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), T = Integer.parseInt(st.nextToken());
        ArrayList<E>[] map = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) map[i] = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken()), A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
            map[x].add(new E(y, A, B));
        }
        double[][] dp = new double[2002][2002];
        dp[0][1] = 1.0;
        for(int t = 0; t <= T; t++) {
            for(int i = 1; i <= N; i++) {
                if(!(t == 1 && i==1) && t > 0) dp[t][i] += dp[t-1][i];
                if(i == N) continue;
                for(E e: map[i]) {
                    int j = e.v, lo = e.x, hi = e.y;
                    double p = dp[t][i] / (double) (hi - lo + 1) / (double) map[i].size();
                    if(t + lo > T || t + lo > T) continue;
                    dp[t + lo][j] += p; dp[Math.min(t + hi + 1, T + 1)][j] -= p;
                }
            }
        }
        double num = 0.0; double den = 0.0;
        for(int t =0; t <= T; t++) {
            num += dp[t][N] * t; den += dp[t][N];
        }
        System.out.printf("%.10f", num / den);
    }

    static class E {
        public int v, x, y;

        E(int v0, int x0, int y0) {v = v0; x = x0; y = y0;}
    }
}
