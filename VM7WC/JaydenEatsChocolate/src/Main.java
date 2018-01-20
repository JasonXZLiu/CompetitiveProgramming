import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] adj = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken()), Y = Integer.parseInt(st.nextToken()), Z = Integer.parseInt(st.nextToken());
        adj[X] = 1; adj[Y] = 1; adj[Z] = 1;
        for(int i = 0; i < N; i++) {
            if(adj[i] != 0) {
                if(i+X <= N) adj[i+X] = adj[i] + 1;
                if(i+Y <= N) adj[i+Y] = adj[i] + 1;
                if(i+Z <= N) adj[i+Z] = adj[i] + 1;
            }
        }
        System.out.println(adj[N]);
    }
}
