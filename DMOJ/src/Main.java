import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int numConnections = 0;
        for (int i = 0; i < 16; i++) {
            if (s.nextInt() == 1) {
                numConnections++;
            }
        }
        if (numConnections > 6 || numConnections == 0 || numConnections % 2 == 1) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }
}