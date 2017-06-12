import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner s = new Scanner(System.in);
        int numTubes = s.nextInt();
        int[] tubes = new int[numTubes + 1];
        int count = 0;
        for(int i = 1; i < numTubes + 1; i++) {
            tubes[i] = s.nextInt();
        }
        int[] pos = new int[500000];
        pos[250000] = tubes[1];
        for (int i = 2; i < numTubes + 1; i++) {
            if(tubes[i] - pos[i-1] < 0) {
                pos[i] = tubes[i];
            } else {
                pos[250000-i+1] = tubes[i];
            }
            if(pos[250000-i+1] - pos[250000-i+1-1] < 0 || pos[250000-i+1] - pos[250000+i-1-1] < 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}
