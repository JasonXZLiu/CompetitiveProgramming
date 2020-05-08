import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int groups = s.nextInt();
        double[] prob = new double[groups];
        for (int i = 0; i < groups; i++) {
            double probA = s.nextDouble() / s.nextDouble();
            prob[i] = 1 - probA;
        }
        double totalProb = 1;
        for (int i = 0; i < groups; i++) {
            totalProb *= prob[i];
        }
        if (totalProb == Math.floor(totalProb)) {
            System.out.println((int) (totalProb));
        } else {
            System.out.println(totalProb);
        }
    }
}