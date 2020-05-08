import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = 0; t < 5; t++) {
            int M = Integer.parseInt(br.readLine());
            ArrayList<Integer>[] adj = new ArrayList[101];
            for(int i = 1; i <= 100; i++) {
                adj[i] = new ArrayList<>();
            }
            for(int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken()); int B = Integer.parseInt(st.nextToken());
                adj[A].add(B); adj[B].add(A);
            }
            Queue<Integer> Q = new LinkedList<>();
            int[] dis = new int[101];
            Arrays.fill(dis, -1);
            Q.add(1); dis[1] = 0;
            while(!Q.isEmpty()) {
                int cur = Q.poll();
                for(int x: adj[cur]) {
                    if(dis[x] == -1) {
                        dis[x] = dis[cur] + 1;
                        Q.add(x);
                    }
                }
            }
            int tot = 0;
            for(int i = 1; i <= 100; i++) {
                for(int x: adj[i]) {
                    if(dis[x] == dis[i]) {
                        tot++;
                    }
                }
            }
            System.out.println(tot/2);
        }
    }
}
