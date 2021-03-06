import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] board = new int[8][8];
    static LinkedList<Integer> a = new LinkedList<>();

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken()) - 1;
        int y1 = Integer.parseInt(st.nextToken()) - 1;
        st = new StringTokenizer(br.readLine());
        int x2 = Integer.parseInt(st.nextToken()) - 1;
        int y2 = Integer.parseInt(st.nextToken()) - 1;
        int count = 0;
        a.add(x1);
        a.add(y1);
        if(x1 == x2 && y1 == y2) {
            System.out.println(0);
        } else {
            while (board[x2][y2] == 0) {
                count++;
                int x = a.getFirst();
                int y = a.get(1);
                check(x, y, count);
            }
            System.out.println(board[x2][y2]);
        }
    }

    public static void whyNot(int x, int y, int count) {
        if(board[x][y] == 0) {
            board[x][y] = count;
            a.addLast(x);
            a.addLast(y);
        }
    }

    public static void check(int x1, int y1, int count) {
        int size = a.size();
        while(size > 0) {
            if(x1 - 1 >= 0 && y1 - 2 >= 0 && x1 - 1 < 8 && y1 - 2 < 8) {
                whyNot(x1 -1, y1 - 2, count);
            }
            if(x1 - 1 >= 0 && y1 + 2 >= 0 && x1 - 1 < 8 && y1 + 2 < 8) {
                whyNot(x1 -1, y1 + 2, count);
            }
            if(x1 - 2 >= 0 && y1 - 1 >= 0 && x1 - 2 < 8 && y1 - 1 < 8) {
                whyNot(x1 - 2, y1 - 1, count);
            }
            if(x1 - 2 >= 0 && y1 + 1 >= 0 && x1 - 2 < 8 && y1 + 1 < 8) {
                whyNot(x1 - 2, y1 + 1, count);
            }
            if(x1 + 1 >= 0 && y1 - 2 >= 0 && x1 + 1 < 8 && y1 - 2 < 8) {
                whyNot(x1 +1, y1 - 2, count);
            }
            if(x1 + 1 >= 0 && y1 + 2 >= 0 && x1 + 1 < 8 && y1 + 2 < 8) {
                whyNot(x1 +1, y1 + 2, count);
            }
            if(x1 + 2 >= 0 && y1 - 1 >= 0 && x1 + 2 < 8 && y1 - 1 < 8) {
                whyNot(x1 +2, y1 - 1, count);
            }
            if(x1 + 2 >= 0 && y1 + 1 >= 0 && x1 + 2 < 8 && y1 + 1 < 8) {
                whyNot(x1 +2, y1 + 1, count);
            }
            size -= 2;
            x1 = a.remove();
            y1 = a.remove();
        }
    }
}
