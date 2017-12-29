import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
            Deque<Integer> Q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) Q.addLast(Integer.parseInt(st.nextToken()));
            for (int i = 0; i < K; i++) {
                int cur = Q.removeLast();
                Q.addFirst(cur);
            }
            while (!Q.isEmpty()) System.out.print(Q.removeFirst() + " ");
            System.out.println();
        }
    }
}
