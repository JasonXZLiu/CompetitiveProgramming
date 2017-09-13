import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner s = new Scanner(System.in);
        int row = s.nextInt();
        int col = s.nextInt();
        int[][] a = new int[row][col];
        int tempRow;
        int tempCol;
        int tempValue;
        boolean stop = true;
        while(stop) {
            tempRow = s.nextInt();
            tempCol = s.nextInt();
            tempValue = s.nextInt();
            if (tempRow == 0 && tempCol == 0 && tempValue == 0) {
                stop = false;
            } else {
                a[tempRow-1][tempCol-1] = tempValue;
            }
        }

//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                System.out.print(a[i][j] + " ");
//            }
//            System.out.println("");
//        }

        // create prefix sum
        boolean evenI = false;
        int[][] sum = new int[row][col];
        for (int i = 0; i < row; i ++) {
            evenI = !evenI;
            boolean evenJ = false;
            for (int j = 0; j < col; j++) {
                evenJ = !evenJ;
                if (evenJ == evenI) {
                    a[i][j] = -a[i][j];
                }
                if (i == 0) {
                    if (j == 0) {
                        sum[0][0] = a[0][0];
                    } else {
                        sum[0][j] = a[0][j] + sum[0][j-1];
                    }
                } else if (j == 0) {
                    sum[i][0] = a[i][0] + sum[i - 1][0];
                } else {
                    sum[i][j] = sum[i-1][j] + sum[i][j-1] + a[i][j] - sum[i-1][j-1];
                }
            }
        }

//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                System.out.print(a[i][j] + " ");
//            }
//            System.out.println("");
//        }
//
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                System.out.print(sum[i][j] + " ");
//            }
//            System.out.println("");
//        }

        // calculate queries
        int startRow;
        int startCol;
        int finishRow;
        int finishCol;
        int answer;
        stop = true;
        while (stop) {
            startRow = s.nextInt() - 1;
            startCol = s.nextInt() - 1;
            finishRow = s.nextInt() - 1;
            finishCol = s.nextInt() - 1;
            if (startRow != -1 || startCol != -1 || finishCol != -1 || finishRow != -1) {
                if (startRow == 0) {
                    if(startCol == 0) {
                        answer = sum[finishRow][finishCol];
                    } else {
                        answer = sum[finishRow][finishCol] - sum[finishRow][startCol - 1];
                    }
                } else if (startCol == 0) {
                    answer = sum[finishRow][finishCol] - sum[startRow-1][finishCol];
                } else {
//                    System.out.println(sum[finishRow][finishCol]);
//                    System.out.println(sum[finishRow][startCol - 1]);
//                    System.out.println(sum[startRow - 1][finishCol]);
//                    System.out.println(sum[startRow-1][startCol-1]);
                    answer = sum[finishRow][finishCol] - sum[finishRow][startCol - 1] - sum[startRow-1][finishCol] + sum[startRow - 1][startCol - 1];
                }
                if ((startCol + startRow) % 2 == 0) {
//                    System.out.println(answer);
                    answer = -answer;
                }
                System.out.println(answer);
            } else {
                stop = false;
            }
        }
    }
}
