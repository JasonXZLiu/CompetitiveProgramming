import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] planet = new int[N+1][2];
        planet[0][0] = 0; planet[0][1] = 0;
        int count = 1;
        for(int i = 2; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            planet[i][0] = planet[P][0] + Integer.parseInt(st.nextToken());
            planet[i][1] = planet[P][1] + Integer.parseInt(st.nextToken());
            boolean b = true;
            for(int j = 1; j < i; j++) {
                if(planet[i][0] == planet[j][0] && planet[i][1] == planet[j][1]) {
                    b = false;
                    break;
                }
            }
            if(b) count++;
        }
        System.out.println(count);
    }
}
