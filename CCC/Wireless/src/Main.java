import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine()), N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[][] board = new int[N + 2][M + 2];
        for (int k = 0; k < K; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken()), Y = Integer.parseInt(st.nextToken()), R = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
            for (int i = Math.max(1, X - R); i <= Math.min(N, X + R); i++) {
                int D = (int) Math.sqrt(R * R - (i - X) * (i - X));
                board[i][Math.max(1, Y - D)] += B;
                board[i][Math.min(M+1, Y + D + 1)] -= B;
            }
        }
        int max = Integer.MIN_VALUE; int count = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                board[i][j] = board[i][j] + board[i][j - 1];
//                System.out.print(board[i][j] + " ");
                if (board[i][j] > max) {
                    max = board[i][j]; count = 1;
                }
                else if(board[i][j] == max) {
                    count++;
                }
            }
//            System.out.println();
        }
        System.out.println(max + "\n" + count);
    }
}
