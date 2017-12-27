import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); int M = Integer.parseInt(br.readLine());
        String[] noun = new String[N]; String[] adj = new String[M];
        for(int i = 0; i < N; i++) noun[i] = br.readLine();
        for(int i = 0; i < M; i++) adj[i] = br.readLine();
        for(String n: noun)
            for(String m: adj)
                System.out.println(n + " as " + m);
    }
}
