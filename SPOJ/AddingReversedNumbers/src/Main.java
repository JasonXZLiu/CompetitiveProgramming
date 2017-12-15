import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int t = 0; t < N; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();
            String A1 = "";
            String B1 = "";
            for(int i = A.length(); i >= 1; i--) A1 += A.substring(i-1, i);
            for(int i = B.length(); i >= 1; i--) B1 += B.substring(i-1, i);
            int a = Integer.parseInt(A1);
            int b = Integer.parseInt(B1);
            Integer z = a + b;
            String Z = z.toString();
            String Z1 = "";
            for(int i = Z.length(); i >= 1; i--) Z1 += Z.substring(i-1, i);
            System.out.println(Integer.parseInt(Z1));
        }
    }
}
