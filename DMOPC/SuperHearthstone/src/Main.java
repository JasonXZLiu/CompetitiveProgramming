import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner s = new Scanner(System.in);
        int numCards = s.nextInt();
        int mana = s.nextInt();
        String temp1;
        int temp2;
        String[] name = new String[numCards];
        int[] cardMana = new int[numCards];
        int[] allMana = new int[10];
        int count = 0;
        boolean b;
        for (int i = 0; i < numCards; i++) {
            b = false;
            temp1 = s.next();
            temp2 = s.nextInt();
            if (temp2 < mana) {
                name[i] = temp1;
                cardMana[i] = temp2;
                for (int j = 0; j < allMana.length; j++) {
                    if (allMana[j] == cardMana[i]) {
                        b = true;
                    }
                }
                if (!b) {
                    allMana[count] = cardMana[i];
                }
            }
        }
    }
}
