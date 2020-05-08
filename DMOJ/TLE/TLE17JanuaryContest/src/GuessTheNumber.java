import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class GuessTheNumber {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int guess = 50, ans = 0; boolean b = false;
        System.out.println("guess " + guess);
        int N = Integer.parseInt(br.readLine());
        System.out.println("answer " + (50 - N));
    }
}
