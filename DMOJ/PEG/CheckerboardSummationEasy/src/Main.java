import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {
        // write your code here
        FastReader s = new FastReader();
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
                    answer = sum[finishRow][finishCol] - sum[finishRow][startCol - 1] - sum[startRow-1][finishCol] + sum[startRow - 1][startCol - 1];
                }
                if ((startCol + startRow) % 2 == 0) {
                    answer = -answer;
                }
                System.out.println(answer);
            } else {
                stop = false;
            }
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}