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
        int V = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] arr = new ArrayList[V + 1];
        boolean b = true;
        for (int i = 0; i <= V; i++) {
            arr[i] = new ArrayList<>();
        }
        while(b == true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v2 = Integer.parseInt(st.nextToken());
            int v1 = Integer.parseInt(st.nextToken());
            if(v1 != 0 && v2 != 0) {
                 arr[v1].add(v2);
            } else {
                b = false;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        int[] vis = new int[V + 1];
        q.add(V);
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int a: arr[cur]) {
                if(vis[a] == 0) {
                    vis[a] = 1;
                    q.add(a);
                }
            }
        }
        int count = 0;
        for(int i = 0; i <= V; i++) {
            if(vis[i] != 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}
