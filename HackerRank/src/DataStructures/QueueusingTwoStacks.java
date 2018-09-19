package DataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 3/5/2018.
 */
public class QueueusingTwoStacks {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> Q = new LinkedList<>();
        for(int t = 0; t < N; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            switch(A) {
                case 1:
                    Q.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    Q.removeFirst();
                    break;
                case 3:
                    System.out.println(Q.getFirst());
                    break;
            }
        }
    }
}
