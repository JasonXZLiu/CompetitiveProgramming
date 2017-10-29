import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int minX = 1000;
        int maxX = 0;
        int minY = 1000;
        int maxY = 0;
        for(int i = 0; i < N; i++) {
            int X = s.nextInt();
            int Y = s.nextInt();
            maxX = Math.max(X, maxX);
            maxY = Math.max(Y, maxY);
            minX = Math.min(X, minX);
            minY = Math.min(Y, minY);
        }
        if(maxX - minX > maxY - minY) {
            System.out.println((maxX - minX) * (maxX - minX));
        } else {
            System.out.println((maxY - minY) * (maxY - minY));
        }
    }
}
