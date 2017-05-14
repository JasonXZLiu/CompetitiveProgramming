import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        byte[][] board = new byte[size][size];
        int c = s.nextInt();
        int r1;
        int c1;
        int r2;
        int c2;
        for (int i = 0; i < c; i++) {
            r1 = s.nextInt();
            c1 = s.nextInt();
            c2 = s.nextInt() + c1 - 1;
            r2 = s.nextInt() + r1 - 1;
            // update differential array
            if (c2 == size - 1) {
                board[r1][c1] += 1;
                board[r1][c2] -= 1;
                board[r2][c1] -= 1;
                board[r2][c2] += 1;
            } else {
                board[r1][c1] += 1;
                board[r1][c2+1] -= 1;
                board[r2+1][c1] -= 1;
                board[r2+1][c2+1] += 1;
            }
        }
        byte[][] sum = new byte[size][size];
        int count = 0;
        for (int i = 0; i < size; i ++) {
            for (int j = 0; j < size; j++) {
                if (i == 0) {
                    if (j == 0) {
                        sum[0][0] = board[0][0];
                    } else {
                        sum[0][j] = (byte) (board[0][j] + sum[0][j-1]);
                    }
                } else if (j == 0) {
                    sum[i][0] = (byte) (board[i][0] + sum[i - 1][0]);
                } else {
                    sum[i][j] = (byte) (sum[i-1][j] + sum[i][j-1] + board[i][j] - sum[i-1][j-1]);
                }
                if (sum[i][j] % 2 == 1) {
                    count += 1;
                }
            }
        }
        System.out.println(count);
    }
}
