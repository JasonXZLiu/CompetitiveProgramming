import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static int count, C;
    public static int[] clubs;

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); C = Integer.parseInt(br.readLine());
        clubs = new int[C];
        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            clubs[i] = x;
        }
        Arrays.sort(clubs);
        count = 0;
        System.out.println("hello");
        sum(5280, 10);
        System.out.println("Roberta wins in " + count + " strokes.");
    }

    public static void sum(int target, int j){
        System.out.println("hello");
        if(target < 0) return;
        if(target == 0) {
            count++;
            return;
        }
        for(int i = j; i < C; i++){
            if(target < clubs[i]) return;
            sum(target - clubs[i], i);
        }
    }
}
