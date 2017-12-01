import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(System.in);
        int S = in.nextInt();
        int D = in.nextInt();
        String[] header = {"Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat"};
        for(int i = 0; i < 7; i++) {
            System.out.print(header[i] + " ");
        }
        System.out.println();
        int cnt = 1;
        for(int i = 1; i <= 7; i++) {
            if(i >= S) {
                printLine(cnt);
                cnt++;
            } else {
                System.out.print("    ");
            }
        }
        System.out.println();
        int cnt1 = 0;
        while(cnt <= D) {
            if (cnt1 == 7) {
                System.out.println();
                cnt1 = 0;
            }
            printLine(cnt);
            cnt++;
            cnt1++;
        }
    }

    public static void printLine(int cnt) {
        if(cnt < 10) {
            System.out.print("  " + cnt + " ");
        } else {
            System.out.print(" " + cnt + " ");
        }
    }
}
