import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> dir = new Stack<>();
        Stack<String> place = new Stack<>();
        String S = br.readLine();
        while(!S.equals("SCHOOL")) {
            switch (S) {
                case "R":
                    dir.push("LEFT");
                    break;
                case "L":
                    dir.push("RIGHT");
                    break;
                default:
                    place.push(S);
                    break;
            }
            S = br.readLine();
        }
        while(!place.isEmpty()) {
            System.out.println("Turn " + dir.pop() + " onto " + place.pop() + " street.");
        }
        System.out.println("Turn " + dir.pop() + " into your HOME.");
    }
}
