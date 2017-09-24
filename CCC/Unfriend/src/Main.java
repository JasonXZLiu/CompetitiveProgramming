import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        Graph g = new Graph(N);
        for (int i = 0; i < N - 1; i++) {
            int a = s.nextInt();

            friends[a - 1]++;
            adjm[i][a-1]++;
        }
        int total = 1;
        for (int i = 0; i < N - 1; i++) {
            int a = friends[i];
            total = total * (a + 2) / (a + 1);
            for(int j = 0; j < N; j++) {
                if(adjm[i][j] != 0) {
                    total = total / ((friends[j] + 2) / (friends[j] + 1));
                }
            }
        }
        System.out.println(total);
    }

    static class Graph {
        private Friend[] friends;

        Graph(int i) {
            this.friends = new Friend[i];
        }
    }

    static class Friend {
        public int invitedNum;
        public ArrayList<Friend> invited;
    }
}