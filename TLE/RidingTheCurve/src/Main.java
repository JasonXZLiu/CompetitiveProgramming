import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine()); boolean b = true;
        double M = Integer.parseInt(st.nextToken()); double K = Integer.parseInt(st.nextToken()); double N = Integer.parseInt(st.nextToken());
        for(int i = 0; i <= M; i++) {
            double X = (i + K) / N ;
            if(X >= 0.595) {
                System.out.println(i);
                b = false; break;
            }
        }
        if(b) System.out.println("have mercy snew");
    }
}
