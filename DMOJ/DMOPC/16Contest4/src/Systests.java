import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 2/13/2018.
 */
public class Systests {
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<E> adj = new ArrayList<>();
        int total = 0;
        for(int i = 0; i < N; i++) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            total += C;
            adj.add(new E(A, B, C));
        }
        Collections.sort(adj);
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            int A = Integer.parseInt(br.readLine());
            for(int j = 0; j < adj.size();) {
                if(A <= adj.get(j).e && A >= adj.get(j).f) {
                    total -= adj.get(j).points;
                    adj.remove(j);
                }
                else j++;
            }

        }
        System.out.println(total);
    }

    static class E implements Comparable<E> {
        public int points;
        public int f, e;

        E(int A, int B, int C) {f = A; e = B; points = C;}


        @Override
        public int compareTo(E o) {
            return Integer.compare(f, o.f);
        }
    }
}