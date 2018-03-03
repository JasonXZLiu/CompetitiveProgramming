import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1 {

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double[] vil = new double[N];
        for(int i = 0; i < N; i++) vil[i] = Double.parseDouble(br.readLine());
        Arrays.sort(vil);
        double[] size = new double[N];
        size[0] = Integer.MAX_VALUE;

        size[N-1] = Integer.MAX_VALUE;
        for(int i = 1; i < N - 1; i++) {
            size[i] = (vil[i+1] + vil[i]) / 2 - (vil[i] + vil[i-1]) / 2;
        }
        double MIN = 2000000000;
        for(int i = 0; i < N; i++) {
//            System.out.print(size[i] + " ");
            MIN = Math.min(size[i], MIN);
        }
        System.out.printf("%.1f", MIN);
    }
}
