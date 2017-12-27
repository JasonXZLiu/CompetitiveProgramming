import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            Stack<Integer> top = new Stack<>();
            Stack<Integer> branch = new Stack<>();
            for(int i = 0; i < N; i++) {
                top.push(Integer.parseInt(br.readLine()));
            }
            boolean b = true; int next = 1;
            while(b && next <= N) {
                if(top.size() > 0 && next == top.peek()) {
                    top.pop();
                    next++;
                } else if(branch.size() > 0 && branch.peek() == next) {
                    branch.pop();
                    next++;
                } else if (top.size() > 0) {
                    branch.push(top.pop());
                } else {
                    b = false;
                }
            }
            if(b) System.out.println("Y");
            else System.out.println("N");
        }
    }
}
