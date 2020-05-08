import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int i = 1;
        int tmp = N;
        while(tmp > 0) {
            tmp = tmp >> 1;
            i = i << 1;
        }
        System.out.println(i - N - 1);
    }
}
