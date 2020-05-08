import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        String sentence = s.nextLine();
        String[] words = sentence.split(" ");
        for (int i = 1; i < words.length; i++ ){
            if(!words[i].equals(words[i].toLowerCase())) {
                words[i - 1] = words[i - 1] + ".";
            }
        }
        words[words.length-1] = words[words.length-1] + ".";
        for (int i = 0; i < words.length; i++ ) {
            System.out.print(words[i] + " ");
        }
    }
}