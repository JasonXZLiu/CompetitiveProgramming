import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        String wood = s.next();
        ArrayList numWood = new ArrayList();
        int count = 0;
        for(int i = 0; i < num; i ++) {
            if(wood.substring(i, i+1).equals("O")) {
                count++;
            } else {
                if (count != 0) {
                    numWood.add(count);
                    count = 0;
                }
            }
        }
        if (count != 0) {
            numWood.add(count);
            count = 0;
        }
        System.out.println(numWood.size());
        for(int i = 0; i < numWood.size(); i ++) {
            for(int j = 0; j < Integer.parseInt(numWood.get(i).toString()); j++) {
                System.out.print("O");
            }
            System.out.println();
        }
    }
}