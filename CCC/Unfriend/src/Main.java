import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[] friends = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            int a = s.nextInt();
            if (a != N) {
                friends[a - 1]++;
            }
        }
        int total = -1;
        for (int i = 0; i < N - 1; i++) {
            int a = friends[i];
            total = total * (a + 2) / (a + 1);
        }
        System.out.println(-total);
    }
}


