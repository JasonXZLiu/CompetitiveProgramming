import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner s = new Scanner(System.in);
        int numRes = s.nextInt();
        // [0], [3, 4]
        int[][] listOfNodes = new int[][]{};
        int numPho = s.nextInt();
        for (int i = 0; i < numPho; i++) {
            listOfNodes[i+1][0] = 1;
        }
        for (int i = 0; i < numRes - 1; i++) {
            int parent = s.nextInt();
            listOfNodes[parent + 1][1] = s.nextInt();
        }
//        Tree a = new Tree("a");
    }
}
