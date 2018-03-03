import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<E> adj = new ArrayList<>();
        int[] light = new int[N];
        int idxLeft = 0; int idxRight = 0;
        for(int i = 0; i < N; i++) {
            light[i] = Integer.parseInt(br.readLine());
            if(light[i] == 1) idxRight++;
            else {
                adj.add(new E(idxLeft, idxRight));
                idxLeft = idxRight + 1;
            }
        }
        if(light[N-1] == 1) adj.add(new E(idxLeft, idxRight+1));
        int[] dp = new int[adj.size()];
        for(int i = adj.size()-1; i >= 0; i--) {
            dp[i] = 1000000;
            int num1 = 0; int j = i;
            while(j < adj.size()-1 && adj.get(j).r - adj.get(i).l <= 7) {
                num1 += adj.get(j).r - adj.get(j).l;
                int len = Math.max(4, adj.get(j).r - adj.get(i).l);
                int plus = len - num1;
                if(len == 6 && light[adj.get(i).l + 2] == 1 && light[adj.get(i).l + 3] == 1) {
                    plus = 1000000;
                }
                if(len == 7 && light[adj.get(i).l + 3] == 1) {
                    plus = 1000000;
                }
                dp[i] = Math.min(dp[i], plus + dp[j+1]);
                j++;
            }
        }
        System.out.println(dp[0]);
    }

    static class E {
        public int l, r;

        E(int l0, int r0) {l = l0; r = r0;}
    }
}
