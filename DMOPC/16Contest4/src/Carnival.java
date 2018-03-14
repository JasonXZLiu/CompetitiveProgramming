import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 2/13/2018.
 */
public class Carnival {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        E[] stands = new E[N+1];
        for(int i = 1; i <= N; i++) {
            stands[i] = new E(Integer.parseInt(st.nextToken()));
        }
        ArrayList<Integer>[] apple = new ArrayList[101];
        for(int i = 0; i <= 100; i++) apple[i] = new ArrayList<>();
        for(int i = 0; i < S; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
            stands[A].apl.add(B);
            apple[B].add(A);
        }
        int Q = Integer.parseInt(br.readLine());
        for(int t = 0; t < Q; t++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "Q":
                    int q = Integer.parseInt(st.nextToken());
                    int MIN = Integer.MAX_VALUE; int minIdx = Integer.MAX_VALUE;
                    for(int x: apple[q]) {
                        if(stands[x].dis <= MIN) {
                            MIN = stands[x].dis;
                            minIdx = Math.min(minIdx, x);
                        }
                    }
                    if(apple[q].size() == 0) minIdx = -1;
                    System.out.println(minIdx);
                    break;
                case "S":
                    Integer Y = Integer.parseInt(st.nextToken());
                    Integer P = Integer.parseInt(st.nextToken());
                    if(stands[Y].apl.contains(P)) stands[Y].apl.remove(P);
                    if(apple[P].contains(Y)) apple[P].remove(Y);
                    break;
                case "A":
                    int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
                    stands[A].apl.add(B);
                    apple[B].add(A);
                    break;
                default:
                    Integer X = Integer.parseInt(st.nextToken());
                    int K = Integer.parseInt(st.nextToken());
                    for(int boop: stands[X].apl) {
                        if(apple[boop].contains(X)) apple[boop].remove(X);
                    }
                    stands[X].dis = K;
                    break;
            }
        }
    }

    static class E {
        public int dis;
        public ArrayList<Integer> apl = new ArrayList<>();

        E(int d0) {dis = d0;}
    }
}
