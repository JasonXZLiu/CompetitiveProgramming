import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 1/1/2018.
 */
public class WorldDominationFun {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()); long K = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> Q = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            long X = Long.parseLong(st.nextToken());
            Q.add(X);
        }
        while(K > 0) {
            Q.add(Q.poll()+1);
            K--;
        }
        System.out.println(Q.poll());
    }
}