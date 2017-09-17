import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner s = new Scanner(System.in);
        int[] row = new int[4];
        int[] col = new int[4];
        int total = 0;
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if(s.nextInt() == 1) {
                    row[j]++;
                    col[i]++;
                    total++;
                }
            }
        }
        if (row[0] != 0 && row[1] != 0 && row[2] != 0 && row[3] != 0 && col[0] != 0 && col[1] != 0 && col[2] != 0 && col[3] != 0 && total == 6) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
