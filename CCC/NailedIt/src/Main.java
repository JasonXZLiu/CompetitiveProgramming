import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner s = new Scanner(System.in);
        int numWoods = s.nextInt();
        ArrayList<Integer> lengths = new ArrayList<>();
        ArrayList<Integer> planks = new ArrayList<>();
        int count = 1;
        int tmp = 1;
        int ways = 1;
        for (int i = 0; i < numWoods; i++) {
            int b = s.nextInt();
            int size = planks.size();
            planks.add(b);
            for(int j = 0; j < size; j++) {
                int blah = b + planks.get(j);
                if (lengths.contains(blah)) {
                    tmp++;
                    if(count != tmp) {
                        count = Math.max(count, tmp);
                        ways = 1;
                    } else {
                        ways++;
                    }
                } else {
                    lengths.add(blah);
                }
            }
        }
        if(count == 1) {
            System.out.println(count + " " + lengths.size());
        } else {
            System.out.println(count + " " + ways);
        }
    }
}
