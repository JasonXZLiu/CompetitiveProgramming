import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(System.in);
        int F = in.nextInt() - 1;
        int G = in.nextInt();
        int[][] points = new int[4][4];
        for (int i = 0; i < G; i++) {
            int t1 = in.nextInt() - 1;
            int t2 = in.nextInt() - 1;
            int p1 = in.nextInt();
            int p2 = in.nextInt();
            if(p1 > p2) {
                points[t1][t2] +=3;
                points[t2][t1] = -1;
            } else if (p2 > p1) {
                points[t1][t2] = -1;
                points[t2][t1] +=3;
            } else {
                points[t2][t1] += 1;
                points[t1][t2] += 1;
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(j == F) {
                    if (points[i][F] == 0) {
                        points[F][i] += 3;
                        points[i][F] = -1;
                    }
                }
            }
        }
        int[] totalPoints = new int[4];
        int blahMax = -10000, maxTeam = 0;
        int blahMin = 10000, minTeam = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                totalPoints[i] += points[i][j];
            }
            if(blahMax == Math.max(blahMax, totalPoints[i])) {
                blahMax = Math.max(blahMax, totalPoints[i]);
                maxTeam = i;
            }
            if(blahMin == Math.max(blahMin, totalPoints[i])) {
                blahMin = Math.max(blahMin, totalPoints[i]);
                minTeam = i;
            }
        }
        for (int i = 0; i < 4; i++) {
            System.out.print(totalPoints[i] + " ");
        }
        System.out.println();
        System.out.println(maxTeam);
        System.out.println(minTeam);
        Queue<Integer> q = new LinkedList<>();
        q.add(maxTeam);
        int cnt = 0;
        if(maxTeam != F) {
            while(!q.isEmpty()) {
                int C = q.remove();
                for (int j = 0; j < 4; j++) {
                    if(points[j][C] == 0) {
                        points[j][C] += 3;
                        points[C][j] = -1;
                    }
                }
            }
        } else {
            System.out.println(F);
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(points[i][j] + " ");
            }
            System.out.println();
        }
    }
}
