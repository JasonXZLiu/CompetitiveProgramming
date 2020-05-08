import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int t = 0; t < N; t++) {
            int M = Integer.parseInt(br.readLine());
            int div5 = 5; int count5 = 0;
            while(M >= div5) {
                count5 += M / div5;
                div5 *= 5;
            }
            System.out.println((count5));
        }
    }
}
