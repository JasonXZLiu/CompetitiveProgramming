import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        int count = 0;
        String words;
        while (num > 0) {
            words = s.next();
            if (words.length() <= 10) {
                count++;
            }
            num--;
        }
        System.out.println(count);
    }
}