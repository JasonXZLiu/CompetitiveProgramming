import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] adj = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int[] arr = new int[A];
            for(int j = 0; j < A; j++) {
                int X = Integer.parseInt(st.nextToken());
                arr[j] = X;
                for(int k = 0; k < j; k++) {
                    adj[arr[k]].add(X);
                    adj[X].add(arr[k]);
                }
            }
        }
        Queue<Integer> Q = new LinkedList<>();
        boolean[] vis = new boolean[N+1];
        Q.add(1); vis[1] = true; int cnt = 1;
        while(!Q.isEmpty()) {
            int cur = Q.poll();
            for(int x: adj[cur]) {
                if(!vis[x]) {
                    cnt++;
                    vis[x] = true;
                    Q.add(x);
                }
            }
        }
        System.out.println(cnt);
        int i = 0;
        while(cnt > 0) {
            if(vis[i]) {
                System.out.print(i + " ");
                cnt--;
            }
            i++;
        }
    }
}
