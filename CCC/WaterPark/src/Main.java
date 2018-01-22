import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] p = new int[N+1];
        ArrayList<Integer>[] adj = new ArrayList[N+1];
        for(int i = 0; i <= N; i++) {
            p[i] = 0; adj[i] = new ArrayList<>();
        }
        String S = br.readLine();
        int X = 0, Y = 0;
        while(!S.equals("0 0")) {
            StringTokenizer st = new StringTokenizer(S);
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            if(!adj[Y].contains(X)) adj[Y].add(X);
            S = br.readLine();
//            System.out.println(Y + "->" + X);
        }
        while(!adj[N].isEmpty()) {
            int x = adj[N].remove(0);
//            System.out.println(x);
            p[x] = 1;
        }
        for(int i = N-1; i >= 1; i--) {
            while(!adj[i].isEmpty()) {
                int x = adj[i].remove(0);
                p[x] += p[i];
//                System.out.println(x + " " + i + " " + p[x]);
            }
        }
        System.out.println(p[1]);
    }
}
