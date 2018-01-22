import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] x = new int[N], y = new int[N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken()); y[i] = Integer.parseInt(st.nextToken());
        }
        double ans = Double.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            for(int j = i + 1 ; j < N; j++) {
                for(int k = j + 1; k < N; k++) {
                    double a = Math.sqrt((x[i]-x[j])*(x[i]-x[j])+(y[i]-y[j])*(y[i]-y[j]));
                    double b = Math.sqrt((x[k]-x[j])*(x[k]-x[j])+(y[k]-y[j])*(y[k]-y[j]));
                    double c = Math.sqrt((x[k]-x[i])*(x[k]-x[i])+(y[k]-y[i])*(y[k]-y[i]));
                    double s = (a + b + c) / 2;
                    double d = 0;
                    if(s == 0 || a*a+b*b-c*c < 0 || b*b+c*c-a*a < 0 || a*a+c*c-b*b < 0) ans = Math.max(ans, Math.max(a, Math.max(b, Math.max(c, d))));
                    else d = 2 * (a * b * c) / (4 * Math.sqrt (s * (s - a) * (s - b) * (s - c)));
                    ans = Math.max(ans, d);
                }
            }
        }
        System.out.printf("%.2f", ans);
    }
}
