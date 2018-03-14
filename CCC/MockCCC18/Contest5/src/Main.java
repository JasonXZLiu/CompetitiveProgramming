import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), X = Integer.parseInt(st.nextToken());
        int bigger = 0, smaller = 0;
        int[] adj = new int[101];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int I = Integer.parseInt(st.nextToken());
            if(I > X) bigger++;
            if(I < X) smaller++;
            adj[I]++;
        }
        int total = bigger * smaller * adj[X];
        if(adj[X] > 2) {
            total += (adj[X] * (adj[X] - 1) * (adj[X] - 2)) / 6;
            total += bigger * (adj[X] * adj[X]-1) / 2;
            total += smaller * (adj[X] * adj[X]-1) / 2;
        } else if(adj[X] == 2) {
            total += bigger;
            total += smaller;
        }
        System.out.println(total);
    }
}
