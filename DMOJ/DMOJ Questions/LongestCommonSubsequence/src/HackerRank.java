import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class HackerRank {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
        int[] row = new int[N]; int[] col = new int[M];
        int[][] dp = new int[M+1][N+1]; int MAX = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) row[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) col[i] = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= M; i++) {
            for(int j = 1; j <= N; j++) {
                if(row[j-1] == col[i-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        for(int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        int temp = dp[M][N]; Stack<Integer> Q = new Stack<>();
        int j = N;
        while(j >= 1) {
            if(dp[M][j] != temp && dp[M][j] != 0) {
                temp = dp[M][j];
//                System.out.println(j + " " + dp[M][j] + " " + row[j-1]);
                Q.add(row[j]);
            }
            j--;
        }
        while(!Q.isEmpty()) System.out.print(Q.pop()+" ");
    }
}
