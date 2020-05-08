import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by jason_001 on 2/2/2018.
 */
public class AGeometryProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] x = new int[3], y = new int[3]; boolean b = false;
        for(int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken()); y[i] = Integer.parseInt(st.nextToken());
        }
        int i = 0, j = 1, k = 2;
        if(x[i] + x[j] + x[k] == y[i] + y[j] + y[k]) b = true;
        if(x[i] + x[j] + y[k] == y[i] + y[j] + x[k]) b = true;
        if(x[i] + y[j] + x[k] == y[i] + x[j] + y[k]) b = true;
        if(y[i] + x[j] + x[k] == x[i] + y[j] + y[k]) b = true;
        if(b) System.out.println("YES");
        else System.out.println("NO");
    }
}
