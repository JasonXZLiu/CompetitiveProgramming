import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static int C, count;
    public static I[] clubs;

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); C = Integer.parseInt(br.readLine());
        clubs = new I[C];
        for(int i = 0; i < C; i++) {
            int x = Integer.parseInt(br.readLine());
            clubs[i] = new I(x);
        }
        Arrays.sort(clubs); count = Integer.MAX_VALUE;
        sum(N, 0, 0);
        if(count != Integer.MAX_VALUE) System.out.println("Roberta wins in " + count + " strokes.");
        else System.out.println("Roberta acknowledges defeat.");
    }

    public static void sum(int target, int j, int stroke) {
        if(count != Integer.MAX_VALUE) return;
        if(target == 0) {
//            System.out.println(stroke);
            count = stroke;
            return;
        }
        for(int i = j; i < C; i++){
            if(target < 0) return;
            sum(target - clubs[i].x, i, stroke + 1);
        }
    }
}

class I implements Comparable<I> {
    public int x;

    I(int x0) {x = x0;}


    @Override
    public int compareTo(I o) {
        return -(Integer.compare(x, o.x));
    }
}
