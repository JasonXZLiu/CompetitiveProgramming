import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), T = Integer.parseInt(st.nextToken());
        ArrayList<E>[] adj = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for(int t = 0; t < N; t++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int sumS = 0, sumT = 0;
            for(int i = 0; i < L; i++) {
                sumT += Integer.parseInt(st.nextToken());
                sumS += Integer.parseInt(st.nextToken());
//                System.out.println(sumT + " " + sumS);
                adj[t+1].add(new E(sumT, sumS));
            }
        }
        int bi = 0;
        int[][] dp = new int[T+1][2];
        for(int i = 1; i <= N; i++) {
            for(E x: adj[i]) {
                for(int j = 1; j <= T; j++) {
                    if(j - x.a >= 0) {
                        dp[j][bi] = Math.max(dp[j][bi ^ 1], Math.max(dp[j- x.a][bi ^ 1] + x.b, dp[j][bi]));
                    }
                    else dp[j][bi] = Math.max(dp[j][bi^1], dp[j][bi]);
                }
            }
            bi ^= 1;
        }
        System.out.println(dp[T][bi^1]);
    }

    static class E {
        public int a, b;

        E(int a0, int b0) {a = a0; b = b0;}
    }
}
