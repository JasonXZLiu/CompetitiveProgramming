import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), T = Integer.parseInt(st.nextToken());
        int[][] adj = new int[N + 1][T + 1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int points = Integer.parseInt(st.nextToken());
            int hours = Integer.parseInt(st.nextToken());
            for(int j = 0; j <= T; j++) {
                if(j < hours) adj[i][j] = adj[i-1][j];
                else {
                    adj[i][j] = Math.max(adj[i-1][j-hours] + points, adj[i-1][j]);
                }
            }
        }
        System.out.println(adj[N][T]);
    }
}
