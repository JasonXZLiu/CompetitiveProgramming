import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastReader s = new FastReader();
        int size = s.nextInt();
        boolean[][] board = new boolean[size][size];
        int c = s.nextInt();
        int r1;
        int c1;
        int r2;
        int c2;
        for (int i = 0; i < c; i++) {
            r1 = s.nextInt();
            c1 = s.nextInt();
            r2 = s.nextInt() + r1 - 1;
            c2 = s.nextInt() + c1 - 1;
            if (r2 == size - 1 && c2 == size - 1) {
                board[r1][c1] = !board[r1][c1];
            } else if (r2 == size - 1) {
                board[r1][c1] = !board[r1][c1];
                board[r1][c2+1] = !board[r1][c2+1];
            } else if (c2 == size - 1) {
                board[r1][c1] = !board[r1][c1];
                board[r2+1][c1] = !board[r2+1][c1];
            } else {
                board[r1][c1] = !board[r1][c1];
                board[r2+1][c1] = !board[r2+1][c1];
                board[r1][c2+1] = !board[r1][c2+1];
                board[r2+1][c2+1] = !board[r2+1][c2+1];
            }
        }
        int count = 0;
        for (int i = 0; i < size; i ++) {
            for (int j = 0; j < size; j++) {
                if (i == 0) {
                    if (j == 0) {
                        board[0][0] = board[0][0];
                    } else {
                        board[0][j] = board[0][j] ^ board[0][j-1];
                    }
                } else if (j == 0) {
                    board[i][0] = board[i][0] ^ board[i - 1][0];
                } else {
                    board[i][j] = board[i-1][j] ^ board[i][j-1] ^ board[i][j] ^ board[i-1][j-1];
                }
                if (board[i][j]) {
                    count += 1;
                }
            }
        }
        System.out.println(count);
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
                catch (IOException e)
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
