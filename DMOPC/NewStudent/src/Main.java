import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Integer.parseInt(br.readLine()); double total = 0; double count = 0;
        for(long i = 0; i < N; i++) {
            total += Integer.parseInt(br.readLine()); count++;
        }
        long S = Integer.parseInt(br.readLine());
        for(long i = 0 ; i < S; i++) {
            total += Integer.parseInt(br.readLine()); count++;
            double avg = total / count;
            System.out.printf("%.3f", avg);
            System.out.println();
        }
    }
}
