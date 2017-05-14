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

        // create prefix sum
        int[][] sum = new int[row][col];
        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < col; j++) {
                if ((i + j) % 2 == 0) {
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

        // calculate queries
        int startRow;
        int startCol;
        int finishRow;
        int finishCol;
        stop = true;
        int answer;
        do {
            startRow = s.nextInt() - 1;
            startCol = s.nextInt() - 1;
            finishRow = s.nextInt() - 1;
            finishCol = s.nextInt() - 1;
            if (startRow == 0) {
                if(startCol == 0) {
                    answer = sum[finishRow][finishCol];
                } else {
                    answer = sum[finishRow][finishCol] - sum[startRow][finishCol - 1] - sum[finishRow - 1][startCol];
                }
            } else if (startCol == 0) {
                answer = sum[finishRow][finishCol] - sum[startRow][finishCol - 1] - sum[finishRow - 1][startCol];
            } else if (finishRow == 0) {
                if(finishCol == 0) {
                    answer = sum[finishRow][finishCol] - sum[startRow][finishCol - 1] + sum[startRow - 1][startCol - 1];
                } else {
                    answer = sum[finishRow][finishCol] - sum[finishRow - 1][startCol] + sum[startRow - 1][startCol - 1];
                }
            } else if (finishCol == 0) {
                answer = sum[finishRow][finishCol] - sum[finishRow - 1][startCol] + sum[startRow - 1][startCol - 1];
            } else {
                answer = sum[finishRow][finishCol] - sum[startRow][finishCol - 1] - sum[finishRow - 1][startCol] + sum[startRow - 1][startCol - 1];
            }
            if ((finishCol + finishRow) % 2 == 1) {
                answer = -answer;
            }
            System.out.println(answer);
        } while (startRow != 0 && startCol != 0 && finishCol != 0 && finishRow != 0);
    }
}
