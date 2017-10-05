import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] floor;
    static int F, r , c, cnt = 0;
    static Queue<Integer> q;

    public static void room() {
        Queue<Integer> toVisit = new LinkedList<>();
        while(!q.isEmpty()) {
            int tmp = q.remove();
            int b = tmp % r;
            int a = tmp - r;
            if(floor[a][b] == 1) {
                toVisit.add(a * r + b);
                while(!toVisit.isEmpty()) {
                    int tmp2 = toVisit.remove();
                    int y = tmp2 % r;
                    int x = tmp2 - r;
                    if(x+1 > 0 && x+1 < c) {
                        if (floor[x + 1][y] == 1) {
                            toVisit.add((x + 1) * r + y);
                            q.remove((x + 1) * r + y);
                            cnt++;
                        }
                    }
                    if(y+1 > 0 && y+1 < r) {
                        if (floor[x][y + 1] == 1) {
                            toVisit.add(x * r + (y + 1));
                            q.remove(x * r + (y + 1));
                            cnt++;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(System.in);
        F = in.nextInt();
        r = in.nextInt();
        c = in.nextInt();
        floor = new int[r][c];
        q = new LinkedList<>();
        for(int i = 0; i < r; i++) {
            String tmp = in.next();
            for (int j = 0; j < c; j++) {
                if(tmp.substring(j, j+1).equals("."))  {
                    q.add(i * r + j);
                    floor[i][j]++;
                }
            }
        }
        room();
        System.out.println(cnt);
    }
}
