import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        // colours red, orange, yellow, green, blue, black
        int[] colours = new int[6];
        for (int i = 0; i < num; i++) {
            String color = s.next();
            switch (color) {
                case "red": colours[0]++; break;
                case "orange": colours[1]++; break;
                case "yellow": colours[2]++; break;
                case "green": colours[3]++; break;
                case "blue": colours[4]++; break;
                default: colours[5]++; break;
            }
        }
        int total = 0;
        Arrays.sort(colours);
        for (int i = 0; i < 5; i++) {
            total += colours[i];
        }
        if (total < colours[5]) {
            System.out.println(total * 2 + 1);
        } else {
            System.out.println(total + colours[5]);
        }
    }

}