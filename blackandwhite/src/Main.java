import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner s = new Scanner(System.in);
        boolean debug = true;
        int size = s.nextInt();
        boolean[][] board = new boolean[size][size];
        int c = s.nextInt();
        int r1;
        int c1;
        int c2;
        for (int i = 0; i < c; i++) {
            r1 = s.nextInt();
            c1 = s.nextInt();
            c2 = s.nextInt() + c1 - 1;
            // update differential array
            if (s.nextInt() + r1 - 1 == size - 1 && c2 == size - 1) {
                board[r1][c1] = !board[r1][c1];
            } else if (s.nextInt() + r1 - 1 == size - 1) {
                board[r1][c1] = !board[r1][c1];
                board[r1][c2+1] = !board[r1][c2+1];
            } else if (c2 == size - 1) {
                board[r1][c1] = !board[r1][c1];
                board[s.nextInt() + r1 - 1+1][c1] = !board[s.nextInt() + r1 - 1+1][c1];
            } else {
//                if (debug) {
//                    System.out.println(r1);
//                    System.out.println(c1);
//                    System.out.println(s.nextInt() + r1 - 1);
//                    System.out.println(c2);
//                }
                board[r1][c1] = !board[r1][c1];
                board[s.nextInt() + r1 - 1+1][c1] = !board[s.nextInt() + r1 - 1+1][c1];
                board[r1][c2+1] = !board[r1][c2+1];
                board[s.nextInt() + r1 - 1+1][c2+1] = !board[s.nextInt() + r1 - 1+1][c2+1];
            }
        }

//        if (debug) {
//            for (int i = 0; i < size; i++) {
//                for (int j = 0; j < size; j++) {
//                    System.out.print(board[i][j] + " ");
//                }
//                System.out.println("");
//            }
//        System.out.println("Sum");
//        }

        boolean[][] sum = new boolean[size][size];
        int count = 0;
        for (int i = 0; i < size; i ++) {
            for (int j = 0; j < size; j++) {
                if (i == 0) {
                    if (j == 0) {
                        sum[0][0] = board[0][0];
                    } else {
                        sum[0][j] = board[0][j] ^ sum[0][j-1];
                    }
                } else if (j == 0) {
                    sum[i][0] = board[i][0] ^ sum[i - 1][0];
                } else {
                    sum[i][j] = sum[i-1][j] ^ sum[i][j-1] ^ board[i][j] ^ sum[i-1][j-1];
                }
                if (sum[i][j]) {
                    count += 1;
                }
            }
        }
//        if (debug) {
//            for (int i = 0; i < size; i++) {
//                for (int j = 0; j < size; j++) {
//                    System.out.print(sum[i][j] + " ");
//                }
//                System.out.println("");
//            }
//        }
        System.out.println(count);
    }
}
